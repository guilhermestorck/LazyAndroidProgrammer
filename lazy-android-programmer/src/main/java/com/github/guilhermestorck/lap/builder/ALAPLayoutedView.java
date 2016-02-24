package com.github.guilhermestorck.lap.builder;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by gstorck on 11/12/2015.
 */
abstract class ALAPLayoutedView<T> extends ALAPView<T> {

    ALAPLayoutedView() { }

    private Integer width = null;
    private Integer height = null;
    private Integer weight = null;

    private Integer marginLeft = 0, marginRight = 0, marginTop = 0, marginBottom = 0;

    private List<RelativeLayoutRule> relativeLayoutRules = new ArrayList<>();

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

    public T marginLeft(int marginLeft) {
        this.marginLeft = marginLeft;
        return self();
    }

    public T marginRight(int marginRight) {
        this.marginRight = marginRight;
        return self();
    }

    public T marginTop(int marginTop) {
        this.marginTop = marginTop;
        return self();
    }

    public T marginBottom(int margin) {
        this.marginBottom = margin;
        return self();
    }

    public T margin(int marginTopBottom, int marginLeftRight) {
        this.marginTop = marginTopBottom;
        this.marginBottom = marginTopBottom;
        this.marginLeft = marginLeftRight;
        this.marginRight = marginLeftRight;
        return self();
    }

    public T margin(int margin) {
        this.marginTop = margin;
        this.marginBottom = margin;
        this.marginLeft = margin;
        this.marginRight = margin;
        return self();
    }

    public T addRule(int verb, int anchor) {
        relativeLayoutRules.add(new RelativeLayoutRule(verb, anchor));
        return self();
    }

    public T above(int anchor) { return addRule(RelativeLayout.ABOVE, anchor); }
    public T below(int anchor) { return addRule(RelativeLayout.BELOW, anchor); }

    public T alignBaseline(int anchor) { return addRule(RelativeLayout.ALIGN_BASELINE, anchor); }
    public T alignBottom(int anchor) { return addRule(RelativeLayout.ALIGN_BOTTOM, anchor); }
    public T alignEnd(int anchor) { return addRule(RelativeLayout.ALIGN_END, anchor); }
    public T alignLeft(int anchor) { return addRule(RelativeLayout.ALIGN_LEFT, anchor); }
    public T alignStart(int anchor) { return addRule(RelativeLayout.ALIGN_START, anchor); }
    public T alignRight(int anchor) { return addRule(RelativeLayout.ALIGN_RIGHT, anchor); }
    public T alignTop(int anchor) { return addRule(RelativeLayout.ALIGN_TOP, anchor); }

    public T alignParentBottom() { return addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, -1); }
    public T alignParentTop() { return addRule(RelativeLayout.ALIGN_PARENT_TOP, -1); }
    public T alignParentLeft() { return addRule(RelativeLayout.ALIGN_PARENT_LEFT, -1); }
    public T alignParentRight() { return addRule(RelativeLayout.ALIGN_PARENT_RIGHT, -1); }
    public T alignParentStart() { return addRule(RelativeLayout.ALIGN_PARENT_START, -1); }
    public T alignParentEnd() { return addRule(RelativeLayout.ALIGN_PARENT_END, -1); }

    public T centerHorizontal() { return addRule(RelativeLayout.CENTER_HORIZONTAL, -1); }
    public T centerVertical() { return addRule(RelativeLayout.CENTER_VERTICAL, -1); }
    public T center() { return addRule(RelativeLayout.CENTER_IN_PARENT, -1); }

    public T endOf(int anchor) { return addRule(RelativeLayout.END_OF, anchor); }
    public T startOf(int anchor) { return addRule(RelativeLayout.START_OF, anchor); }
    public T rightOf(int anchor) { return addRule(RelativeLayout.RIGHT_OF, anchor); }
    public T leftOf(int anchor) { return addRule(RelativeLayout.LEFT_OF, anchor); }

    public ViewGroup.LayoutParams getLayoutParams(ViewGroup viewGroup) {
        if(viewGroup instanceof LinearLayout)
            return getLayoutParams((LinearLayout) viewGroup);
        if(viewGroup instanceof RelativeLayout)
            return getLayoutParams((RelativeLayout) viewGroup);
        throw new UnsupportedOperationException("Can't retrieve layout params for this type of ViewGroup yet");
    }

    public LinearLayout.LayoutParams getLayoutParams(LinearLayout layout) {
        Integer defaultWidth = ( layout.getOrientation() == LinearLayout.HORIZONTAL ? WRAP : FILL );
        Integer defaultHeight = ( layout.getOrientation() == LinearLayout.HORIZONTAL ? FILL : WRAP );
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
            width != null ? width : defaultWidth,
            height != null ? height : defaultHeight,
            weight != null ? weight : 0f
        );
        params.setMargins(marginLeft, marginTop, marginRight, marginBottom);
        return params;
    }

    public RelativeLayout.LayoutParams getLayoutParams(RelativeLayout layout) {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
            width != null ? width : WRAP,
            height != null ? height : WRAP
        );
        params.setMargins(marginLeft, marginTop, marginRight, marginBottom);
        for(RelativeLayoutRule rule : relativeLayoutRules) {
            params.addRule(rule.verb, rule.anchor);
        }
        return params;
    }

    private class RelativeLayoutRule {
        int verb, anchor;
        RelativeLayoutRule(int verb, int anchor) {
            this.verb = verb;
            this.anchor = anchor;
        }
    }
}
