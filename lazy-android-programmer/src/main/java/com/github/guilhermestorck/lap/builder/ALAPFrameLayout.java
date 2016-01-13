package com.github.guilhermestorck.lap.builder;

import android.app.Activity;
import android.content.Context;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/**
 * Created by gstorck on 05/01/2016.
 */
abstract class ALAPFrameLayout<T> extends ALAPViewGroup<T> {

    ALAPFrameLayout() {
    }

    public FrameLayout build(Activity activity) {
        FrameLayout view = new FrameLayout(activity);
        return fill(view, activity);
    }

    protected FrameLayout fill(FrameLayout v, Activity activity) {
        v = (FrameLayout) super.fill(v, activity);
        return v;
    }

}
