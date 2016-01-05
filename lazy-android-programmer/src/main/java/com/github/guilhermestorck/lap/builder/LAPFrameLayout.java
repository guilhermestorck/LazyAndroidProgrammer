package com.github.guilhermestorck.lap.builder;

/**
 * Created by gstorck on 05/01/2016.
 */
public final class LAPFrameLayout extends ALAPFrameLayout<LAPFrameLayout> {

    public LAPFrameLayout(LAPView view) {
        add(view);
    }

    @Override
    LAPFrameLayout self() {
        return this;
    }
}
