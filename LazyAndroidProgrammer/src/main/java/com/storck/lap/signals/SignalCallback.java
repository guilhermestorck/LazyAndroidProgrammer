package com.storck.lap.signals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * Created by gstorck on 19/11/2015.
 */
public class SignalCallback {

    Map<Method, Object> callbacks;
    Object[] signalParams;

    public SignalCallback(Map<Method, Object> callbacks, Object[] signalParams) {
        this.callbacks = callbacks;
        this.signalParams = signalParams;
    }

    public void execute() {
        try {
            for(Map.Entry<Method, Object> callback : callbacks.entrySet()) {
                callback.getKey().invoke(callback.getValue(), signalParams);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
