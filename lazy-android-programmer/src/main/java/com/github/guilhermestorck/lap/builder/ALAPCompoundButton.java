package com.github.guilhermestorck.lap.builder;

import android.content.Context;
import android.widget.Button;
import android.widget.CompoundButton;

/**
 * Created by gstorck on 10/12/2015.
 */
abstract class ALAPCompoundButton<T> extends ALAPButton<T>{

    ALAPCompoundButton() { }

    protected CompoundButton fill(CompoundButton v, Context ctx) {
        v = (CompoundButton) super.fill(v, ctx);
        if(checked != null) v.setChecked(checked);
        if(onCheckedChange != null) v.setOnCheckedChangeListener(onCheckedChange);
        return v;
    }

    private Boolean checked = null;
    private CompoundButton.OnCheckedChangeListener onCheckedChange = null;

    public T checked(Boolean checked) {
        this.checked = checked;
        return self();
    }

    public T onCheckedChange(CompoundButton.OnCheckedChangeListener onCheckedChange) {
        this.onCheckedChange = onCheckedChange;
        return self();
    }

}
