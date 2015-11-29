package com.storck.lap;

import android.content.Context;
import android.view.View;

import com.storck.lap.components.LAPButton;

/**
 * Created by gstorck on 19/11/2015.
 */
public class LazyAndroidProgrammer {

    Context ctx;

    public LazyAndroidProgrammer(Context ctx) {
        this.ctx = ctx;
    }

    public LAPButton LAPButton(String label) {
        return new LAPButton(ctx, label);
    }

    public LAPButton LAPButton(String label, View.OnClickListener callback) {
        return new LAPButton(ctx, label, callback);
    }

}
