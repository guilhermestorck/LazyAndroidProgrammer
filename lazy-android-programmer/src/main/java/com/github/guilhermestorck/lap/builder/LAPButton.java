package com.github.guilhermestorck.lap.builder;

import android.view.View;

/**
 * Created by gstorck on 09/12/2015.
 */
public final class LAPButton extends ALAPButton<LAPButton> {

    public LAPButton(CharSequence label) {
        this(label, null);
    }

    public LAPButton(CharSequence label, View.OnClickListener callback) {
        text(label);
        onClick(callback);
    }

    @Override
    LAPButton self() {
        return this;
    }
}
