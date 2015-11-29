package com.storck.lap.signals;

import android.util.Log;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.view.View;

public class SignalBus {

    Map<String, Map<Method, Object>> registeredCallbacks;
    private static SignalBus bus;

    private SignalBus() {
        registeredCallbacks = new HashMap<>();
    }

    public static synchronized void registerCallbacks(Object obj) {
        if(bus == null) {
            bus = new SignalBus();
        }
        bus.internalRegisterCallbacks(obj);
    }

    public static synchronized void unregisterCallbacks(Object obj) {
        if(bus != null) {
            for(Map<Method, Object> callbacks : bus.registeredCallbacks.values()) {
                for(Map.Entry<Method, Object> callback : callbacks.entrySet()) {
                    if(callback.getValue() == obj)
                        callbacks.remove(callback.getKey());
                }
            }
        }
    }

    //TODO create functions signalOnClick, signalOnBlablabla to return OnClickListeners, BlablablaListeners and whatever
    public static SignalCallback signal(String signalName, Object... signalParams) {
        //if it was not initiated, then there is nothing to call
        if(bus == null) return new SignalCallback(new HashMap<Method, Object>(), signalParams);

        Map<Method, Object> callbacks = bus.registeredCallbacks.get(signalName);
        if(callbacks == null) // there is no callback for that signal
            return new SignalCallback(new HashMap<Method, Object>(), signalParams);

        Class[] signalParamTypes = new Class[signalParams.length];
        for(int i = 0; i < signalParams.length; ++i) {
            if(signalParams[i] == null)
                signalParamTypes = null;
            signalParamTypes[i] = signalParams[i].getClass();
        }

        Map<Method, Object> matchingCallbacks = new HashMap<>();
        for(Map.Entry<Method, Object> callback : callbacks.entrySet()) {
            Class[] callbackParamTypes = callback.getKey().getParameterTypes();

            if(signalParamTypes.length != callbackParamTypes.length)
                continue; //different number of parameters. Bounce off.

            boolean areParamTypesTheSame = true;
            for(int i = 0; i < signalParamTypes.length; ++i) {
                if(signalParamTypes[i] != null && !callbackParamTypes[i].isAssignableFrom(signalParamTypes[i])) {
                    areParamTypesTheSame = false;
                    break; //if param cant be assigned, then bounce off.
                }
            }

            if(areParamTypesTheSame)
                matchingCallbacks.put(callback.getKey(), callback.getValue()); //all set. this method is compatible with params given.
        }

        return new SignalCallback(matchingCallbacks, signalParams);
    }

    public static View.OnClickListener signalOnClick(final String signalName, final Object... signalParams) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signal(signalName, signalParams).execute();
            }
        };
    }

    private void internalRegisterCallbacks(Object obj) {
        for(Map.Entry<Method, OnSignal> callback : getMethodsAnnotatedWith(obj.getClass(), OnSignal.class).entrySet()) {
            register(callback.getValue().value(), callback.getKey(), obj);
        }
    }

    private void register(String signalName, Method callback, Object receiver) {
        if(registeredCallbacks.get(signalName) == null) {
            registeredCallbacks.put(signalName, new HashMap<Method, Object>());
        }
        registeredCallbacks.get(signalName).put(callback, receiver);
    }

    private <T extends Annotation> Map<Method, T> getMethodsAnnotatedWith(final Class<?> type, final Class<T> annotation) {
        final Map<Method, T> methods = new HashMap<>();
        Class<?> klass = type;
        while (klass != Object.class) {
            final List<Method> allMethods = new ArrayList<Method>(Arrays.asList(klass.getDeclaredMethods()));
            for (final Method method : allMethods) {
                if (method.isAnnotationPresent(annotation)) {
                    Log.d("SignalBus", "Found method " + method.getName());
                    T annotInstance = method.getAnnotation(annotation);
                    methods.put(method, (T)annotInstance);
                }
            }
            klass = klass.getSuperclass();
        }
        return methods;
    }

}
