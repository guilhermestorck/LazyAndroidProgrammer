package com.github.guilhermestorck.lap;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import com.github.guilhermestorck.lap.builder.LAPView;

import java.util.concurrent.Semaphore;

/**
 * Created by gstorck on 06/01/2016.
 */
public class LAPBuilder implements Runnable{

    public static <T extends LAPView> View build(final Activity activity, final T lapView) {
        final Semaphore mutex = new Semaphore(0);
        LAPBuilder lapBuilder = new LAPBuilder(mutex, lapView, activity);
        if(Looper.getMainLooper() == Looper.myLooper()) {
            lapBuilder.run();
        } else {
            activity.runOnUiThread(lapBuilder);
        }

        try {
            mutex.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return lapBuilder.getResult();
    }

    View result = null;
    Semaphore mutex = null;
    LAPView lapView = null;
    Activity activity = null;

    private LAPBuilder(Semaphore mutex, LAPView lapView, Activity activity) {
        this.mutex = mutex;
        this.lapView = lapView;
        this.activity = activity;
    }

    public View getResult() {
        return result;
    }

    @Override
    public void run() {
        result = lapView.build(activity);
        mutex.release();
    }

}
