package com.github.guilhermestorck.lap.builder;

import android.app.Activity;
import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by gstorck on 05/01/2016.
 */
abstract class ALAPEditText<T> extends ALAPTextView<T> {

    ALAPEditText() {}

    public EditText build(Activity activity) {
        EditText view = new EditText(activity);
        return fill(view, activity);
    }

    private TextWatcher textWatcher = null;

    protected EditText fill(EditText v, Activity activity) {
        v = (EditText) super.fill(v, activity);
        if(textWatcher != null) v.addTextChangedListener(textWatcher);
        return v;
    }

    public T textWatcher(TextWatcher textWatcher) {
        this.textWatcher = textWatcher;
        return self();
    }

}
