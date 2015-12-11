package com.github.guilhermestorck.lap.builder;

import android.content.Context;
import android.view.ViewGroup;
import android.view.View;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by gstorck on 10/12/2015.
 */
abstract class ALAPViewGroup<T> extends ALAPLayoutedView<T> {

    ALAPViewGroup() { }

    protected ViewGroup fill(ViewGroup v, Context ctx) {
        v = (ViewGroup) super.fill(v, ctx);
        for(LAPView view : views) {
            if(view instanceof ALAPLayoutedView) {
                v.addView(view.build(ctx), ((ALAPLayoutedView) view).getLayoutParams(v));
            } else {
                v.addView(view.build(ctx));
            }
        }
        return v;
    }

    List<LAPView> views = new LinkedList<>();

    public T add(LAPView view) {
        views.add(view);
        return self();
    }

    public T add(LAPView view, int index) {
        views.add(index, view);
        return self();
    }

}
