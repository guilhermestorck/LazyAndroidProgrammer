package com.github.guilhermestorck.lap.builder;

import android.app.Activity;
import android.content.Context;
import android.widget.Button;

abstract class ALAPButton<T> extends ALAPTextView<T> {

    ALAPButton() { }

    public Button build(Activity activity) {
        Button view = new Button(activity);
        return fill(view, activity);
    }

    protected Button fill(Button v, Activity activity) {
        return (Button) super.fill(v, activity);
    }

}
