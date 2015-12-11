package com.github.guilhermestorck.lap.builder;

import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by gstorck on 27/11/2015.
 */
public final class LAPLinearLayout extends ALAPLinearLayout<LAPLinearLayout> {

    public LAPLinearLayout(int orientation, LAPView... views) {
        for(LAPView view : views) {
            add(view);
        }
        orientation(orientation);
    }

    public LAPLinearLayout(LAPView... views) {
        this(LinearLayout.HORIZONTAL, views);
    }

    @Override
    LAPLinearLayout self() {
        return this;
    }
}
