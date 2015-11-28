package com.storck.lazyandriodprogrammer.layouts;

import android.view.View;
import android.widget.LinearLayout;

public class LAPLayoutedView {

    View theView;

    //constants
    Integer FILL_PARENT = -1;
    Integer WRAP_CONTENT = -2;

    //params
    Integer width = null;
    Integer height = null;
    Float weight = null;
    Integer id = null;

    public LAPLayoutedView(View v) {
        theView = v;
    }

    public LAPLayoutedView width(int w) {
        width = w;
        return this;
    }

    public LAPLayoutedView wrapWidth() {
        width = WRAP_CONTENT;
        return this;
    }

    public LAPLayoutedView fillWidth() {
        width = FILL_PARENT;
        return this;
    }

    public LAPLayoutedView height(int h) {
        height = h;
        return this;
    }

    public LAPLayoutedView wrapHeight() {
        height = WRAP_CONTENT;
        return this;
    }

    public LAPLayoutedView fillHeight() {
        height = FILL_PARENT;
        return this;
    }

    public LAPLayoutedView weight(float w) {
        weight = w;
        return this;
    }

    public LAPLayoutedView id(int id) {
        this.id = id;
        return this;
    }

    public LinearLayout.LayoutParams getLayoutParams(LinearLayout layout) {
        Integer defaultWidth = ( layout.getOrientation() == LinearLayout.HORIZONTAL ? LinearLayout.LayoutParams.WRAP_CONTENT : FILL_PARENT );
        Integer defaultHeight = ( layout.getOrientation() == LinearLayout.HORIZONTAL ? FILL_PARENT : WRAP_CONTENT );
        return new LinearLayout.LayoutParams(
                width != null ? width : defaultWidth,
                height != null ? height : defaultHeight,
                weight != null ? weight : 0f
        );
    }

    public View getView() {
        return theView;
    }

}
