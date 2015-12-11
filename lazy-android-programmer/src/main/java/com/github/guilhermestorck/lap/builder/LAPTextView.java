package com.github.guilhermestorck.lap.builder;

/**
 * Created by gstorck on 30/11/2015.
 */
public final class LAPTextView extends ALAPTextView<LAPTextView> {

    public LAPTextView(CharSequence label) {
        text(label);
    }

    @Override
    LAPTextView self() {
        return this;
    }
}
