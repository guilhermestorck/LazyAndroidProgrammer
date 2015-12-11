package com.github.guilhermestorck.lap.builder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by gstorck on 10/12/2015.
 */
abstract class ALAPLinearLayout<T> extends ALAPViewGroup<T> {

    ALAPLinearLayout() { }

    public LinearLayout build(Context ctx) {
        LinearLayout view = new LinearLayout(ctx);
        return fill(view, ctx);
    }

    protected LinearLayout fill(LinearLayout v, Context ctx) {
        v = (LinearLayout) super.fill(v, ctx);
        if(gravity != null) v.setGravity(gravity);
        if(dividerDrawable != null) v.setDividerDrawable(dividerDrawable);
        if(orientation != null) v.setOrientation(orientation);
        if(weightSum != null) v.setWeightSum(weightSum);
        return v;
    }

    private Integer gravity = null;
    private Drawable dividerDrawable = null;
    private Integer orientation = null;
    private Float weightSum = null;

    public T gravity(Integer gravity) {
        this.gravity = gravity;
        return self();
    }

    public T dividerDrawable(Drawable dividerDrawable) {
        this.dividerDrawable = dividerDrawable;
        return self();
    }

    public T orientation(Integer orientation) {
        this.orientation = orientation;
        return self();
    }

    public T weightSum(Float weightSum) {
        this.weightSum = weightSum;
        return self();
    }

}
