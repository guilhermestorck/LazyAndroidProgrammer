package com.github.guilhermestorck.lap.builder;

import android.app.Activity;
import android.content.Context;
import android.view.View;

/**
 * Created by gstorck on 18/12/2015.
 */
public final class LAP<V extends View> extends ALAPLayoutedView<LAP<V>> {

    private V view;

    public LAP(V view) {
        this.view = view;
    }

    @Override
    public View build(Activity activity) {
        return fill(view, activity);
    }

    @Override
    LAP self() {
        return this;
    }
}
