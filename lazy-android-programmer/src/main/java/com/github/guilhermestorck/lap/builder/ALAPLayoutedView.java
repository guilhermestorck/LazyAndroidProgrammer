package com.github.guilhermestorck.lap.builder;

import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by gstorck on 11/12/2015.
 */
abstract class ALAPLayoutedView<T> extends ALAPView<T> {

    ALAPLayoutedView() { }

    private Integer width = null;
    private Integer height = null;
    private Integer weight = null;

    private final Integer WRAP = ViewGroup.LayoutParams.WRAP_CONTENT;
    private final Integer FILL = ViewGroup.LayoutParams.MATCH_PARENT;

    public T width(Integer width) {
        this.width = width;
        return self();
    }

    public T fillWidth() {
        this.width = FILL;
        return self();
    }

    public T wrapWidth() {
        this.width = WRAP;
        return self();
    }

    public T height(Integer height) {
        this.height = height;
        return self();
    }

    public T fillHeight() {
        this.height = FILL;
        return self();
    }

    public T wrapHeight() {
        this.height = WRAP;
        return self();
    }

    public T weight(Integer weight) {
        this.weight = weight;
        return self();
    }

    public ViewGroup.LayoutParams getLayoutParams(ViewGroup viewGroup) {
        if(viewGroup instanceof LinearLayout)
            return getLayoutParams((LinearLayout) viewGroup);
        throw new UnsupportedOperationException("Can't retrieve layout params for this type of ViewGroup yet");
    }

    public LinearLayout.LayoutParams getLayoutParams(LinearLayout layout) {
        Integer defaultWidth = ( layout.getOrientation() == LinearLayout.HORIZONTAL ? WRAP : FILL );
        Integer defaultHeight = ( layout.getOrientation() == LinearLayout.HORIZONTAL ? FILL : WRAP );
        return new LinearLayout.LayoutParams(
            width != null ? width : defaultWidth,
            height != null ? height : defaultHeight,
            weight != null ? weight : 0f
        );
    }
}
