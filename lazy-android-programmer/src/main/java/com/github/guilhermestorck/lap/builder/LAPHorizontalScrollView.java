package com.github.guilhermestorck.lap.builder;

/**
 * Created by gstorck on 05/01/2016.
 */
public final class LAPHorizontalScrollView extends ALAPScrollView<LAPHorizontalScrollView> {

    public LAPHorizontalScrollView(LAPView view) {
        add(view);
    }

    @Override
    LAPHorizontalScrollView self() {
        return this;
    }
}
