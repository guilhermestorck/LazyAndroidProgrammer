package com.github.guilhermestorck.lap.builder;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ScrollView;

/**
 * Created by gstorck on 05/01/2016.
 */
abstract class ALAPScrollView<T> extends ALAPFrameLayout<T> {

    ALAPScrollView() {
    }

    public ScrollView build(Context ctx) {
        ScrollView view = new ScrollView(ctx);
        return fill(view, ctx);
    }

    protected ScrollView fill(ScrollView v, Context ctx) {
        v = (ScrollView) super.fill(v, ctx);
        return v;
    }

}
