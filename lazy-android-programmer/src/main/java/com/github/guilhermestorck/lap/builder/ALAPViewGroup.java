package com.github.guilhermestorck.lap.builder;

import android.app.Activity;
import android.view.View;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;

import com.github.guilhermestorck.lap.LAPBuilder;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Created by gstorck on 10/12/2015.
 */
abstract class ALAPViewGroup<T> extends ALAPLayoutedView<T> {

    ALAPViewGroup() { }

    protected ViewGroup fill(ViewGroup v, final Activity activity) {
        final ViewGroup viewGroup = (ViewGroup) ALAPViewGroup.super.fill(v, activity);
        View builtView;
        for(LAPView view : views) {
            builtView = LAPBuilder.build(activity, view);
            if(view instanceof ALAPLayoutedView) {
                builtView.setLayoutParams(((ALAPLayoutedView) view).getLayoutParams(viewGroup));
            }
            viewGroup.addView(builtView);
        }
        invalidateRecursive(viewGroup);
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

    private void invalidateRecursive(ViewGroup viewGroup) {
        int count = viewGroup.getChildCount();
        View child;
        for (int i = 0; i < count; i++) {
            child = viewGroup.getChildAt(i);
            if(child instanceof ViewGroup)
                invalidateRecursive((ViewGroup) child);
            else
                child.invalidate();
        }
    }

}
