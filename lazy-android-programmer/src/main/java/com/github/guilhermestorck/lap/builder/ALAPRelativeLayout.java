package com.github.guilhermestorck.lap.builder;

import android.app.Activity;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by gstorck on 01/02/2016.
 */
abstract class ALAPRelativeLayout<T> extends ALAPViewGroup<T>{

    ALAPRelativeLayout() {}

    public RelativeLayout build(Activity activity) {
        RelativeLayout view = new RelativeLayout(activity);
        return fill(view, activity);
    }

    protected RelativeLayout fill(RelativeLayout v, Activity activity) {
        return (RelativeLayout) super.fill(v, activity);
    }
}
