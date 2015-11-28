package com.storck.lazyandriodprogrammer.components;

import android.content.Context;
import android.widget.Button;

public class LAPButton extends Button {

    public LAPButton(Context context, String label) {
        this(context, label, null);
    }

    public LAPButton(Context context, String label, OnClickListener callback) {
        super(context);
        setText(label);
        setOnClickListener(callback);
    }
}
