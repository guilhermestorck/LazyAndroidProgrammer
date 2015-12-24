package com.github.guilhermestorck.lap.builder;

/**
 * Created by gstorck on 10/12/2015.
 */
public final class LAPCheckBox extends ALAPCompoundButton<LAPCheckBox> {

    public LAPCheckBox(CharSequence label) {
        this(label, false);
    }

    public LAPCheckBox(CharSequence label, Boolean checked) {
        text(label);
        checked(checked);
    }

    public LAPCheckBox(Integer labelRes) {
        this(labelRes, false);
    }

    public LAPCheckBox(Integer labelRes, Boolean checked) {
        textRes(labelRes);
        checked(checked);
    }

    @Override
    LAPCheckBox self() {
        return this;
    }

}
