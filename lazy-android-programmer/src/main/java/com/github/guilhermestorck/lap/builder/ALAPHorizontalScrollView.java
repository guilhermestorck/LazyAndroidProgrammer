package com.github.guilhermestorck.lap.builder;

import android.app.Activity;
import android.content.Context;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;

/**
 * Created by gstorck on 05/01/2016.
 */
abstract class ALAPHorizontalScrollView<T>  extends ALAPFrameLayout<T> {

    ALAPHorizontalScrollView() {
    }

    public HorizontalScrollView build(Activity activity) {
        HorizontalScrollView view = new HorizontalScrollView(activity);
        return fill(view, activity);
    }

    protected HorizontalScrollView fill(HorizontalScrollView v, Activity activity) {
        return (HorizontalScrollView) super.fill(v, activity);
    }

}
