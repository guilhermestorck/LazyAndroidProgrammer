package com.github.guilhermestorck.lap.builder;

import android.widget.LinearLayout;

/**
 * Created by gstorck on 01/02/2016.
 */
public final class LAPRelativeLayout extends ALAPRelativeLayout<LAPRelativeLayout> {

    public LAPRelativeLayout(LAPView... views) {
        for(LAPView view : views) {
            add(view);
        }
    }

    @Override
    LAPRelativeLayout self() {
        return this;
    }

}
