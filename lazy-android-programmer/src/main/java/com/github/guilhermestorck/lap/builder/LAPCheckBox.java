package com.github.guilhermestorck.lap.builder;

/**
 * Created by gstorck on 10/12/2015.
 */
public final class LAPCheckBox<T> extends ALAPCompoundButton<LAPCheckBox> {

    public LAPCheckBox(CharSequence label) {
        this(label, false);
    }

    public LAPCheckBox(CharSequence label, Boolean checked) {
        text(label);
        checked(checked);
    }

    @Override
    LAPCheckBox self() {
        return this;
    }

}
