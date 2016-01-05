package com.github.guilhermestorck.lap.builder;

/**
 * Created by gstorck on 05/01/2016.
 */
public final class LAPScrollView extends ALAPScrollView<LAPScrollView> {

    public LAPScrollView(LAPView view) {
        add(view);
    }

    @Override
    LAPScrollView self() {
        return this;
    }

}
