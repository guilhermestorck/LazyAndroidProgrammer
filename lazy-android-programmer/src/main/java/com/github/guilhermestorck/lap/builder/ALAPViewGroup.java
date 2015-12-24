package com.github.guilhermestorck.lap.builder;

import android.content.Context;
import android.view.ViewGroup;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by gstorck on 10/12/2015.
 */
abstract class ALAPViewGroup<T> extends ALAPLayoutedView<T> {

    ALAPViewGroup() { }

    protected ViewGroup fill(ViewGroup v, final Context ctx) {
        final ViewGroup viewGroup = (ViewGroup) ALAPViewGroup.super.fill(v, ctx);
        Runnable worker = new Runnable() {
            @Override
            public void run() {
                for(LAPView view : views) {
                    if(view instanceof ALAPLayoutedView) {
                        viewGroup.addView(view.build(ctx), ((ALAPLayoutedView) view).getLayoutParams(viewGroup));
                    } else {
                        viewGroup.addView(view.build(ctx));
                    }
                }
            }
        };
        viewGroup.post(worker);
        return viewGroup;
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
