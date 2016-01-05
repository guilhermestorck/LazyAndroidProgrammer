package com.github.guilhermestorck.lap.builder;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/**
 * Created by gstorck on 05/01/2016.
 */
abstract class ALAPFrameLayout<T> extends ALAPViewGroup<T> {

    ALAPFrameLayout() {
    }

    public FrameLayout build(Context ctx) {
        FrameLayout view = new FrameLayout(ctx);
        return fill(view, ctx);
    }

    protected FrameLayout fill(FrameLayout v, Context ctx) {
        v = (FrameLayout) super.fill(v, ctx);
        return v;
    }

}
