package com.github.guilhermestorck.lap.builder;

import android.content.Context;
import android.widget.Button;

abstract class ALAPButton<T> extends ALAPTextView<T> {

    ALAPButton() { }

    public Button build(Context ctx) {
        Button view = new Button(ctx);
        return fill(view, ctx);
    }

    protected Button fill(Button v, Context ctx) {
        v = (Button) super.fill(v, ctx);
        return v;
    }

}
