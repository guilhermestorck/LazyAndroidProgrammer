package com.github.guilhermestorck.lap.builder;

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
    public View build(Context ctx) {
        return fill(view, ctx);
    }

    @Override
    LAP self() {
        return this;
    }
}
