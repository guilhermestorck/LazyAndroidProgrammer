package com.github.guilhermestorck.lap.builder;

import android.app.Activity;
import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ScrollView;

/**
 * Created by gstorck on 05/01/2016.
 */
abstract class ALAPScrollView<T> extends ALAPFrameLayout<T> {

    ALAPScrollView() {
    }

    public ScrollView build(Activity activity) {
        ScrollView view = new ScrollView(activity);
        return fill(view, activity);
    }

    protected ScrollView fill(ScrollView v, Activity activity) {
        v = (ScrollView) super.fill(v, activity);
        return v;
    }

}
