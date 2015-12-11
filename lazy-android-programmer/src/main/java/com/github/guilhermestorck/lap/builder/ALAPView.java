package com.github.guilhermestorck.lap.builder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.*;

/**
 * Created by gstorck on 08/12/2015.
 */
abstract class ALAPView<T> implements LAPView {

    abstract T self();

    ALAPView() {  }

    public View build(Context ctx) {
        View view = new View(ctx);
        return fill(view, ctx);
    }

    protected View fill(View v, Context ctx) {
        if(onClick != null) v.setOnClickListener(onClick);
        if(id != null) v.setId(id);
        if(alpha != null) v.setAlpha(alpha);
        if(background != null) v.setBackgroundDrawable(background);
        if(backgroundColor != null) v.setBackgroundColor(backgroundColor);
        if(backgroundResource != null) v.setBackgroundResource(backgroundResource);
        //TODO how do I manage that?
        //if(elevation != null) v.setElevation(elevation);
        if(enabled != null) v.setEnabled(enabled);
        if(minHeight != null) v.setMinimumHeight(minHeight);
        if(minWidth != null) v.setMinimumWidth(minWidth);
        if(onLongClick != null) v.setOnLongClickListener(onLongClick);
        v.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        //TODO and that
        // if(textAlignment != null) v.setTextAlignment(textAlignment);
        // if(textDirection != null) v.setTextDirection(textDirection);
        if(visibility != null) v.setVisibility(visibility);
        return v;
    }

    private OnClickListener onClick = null;
    private Integer id = null;
    private Float alpha = null;
    private Drawable background = null;
    private Integer backgroundColor = null;
    private Integer backgroundResource = null;
    //private Float elevation = null;
    private Boolean enabled = null;
    private Integer minHeight = null;
    private Integer minWidth = null;
    private OnLongClickListener onLongClick = null;
    private Integer paddingLeft = 0, paddingRight = 0, paddingTop = 0, paddingBottom = 0;
    //private Integer textAlignment = null;
    //private Integer textDirection = null;
    private Integer visibility = null;

    public T onClick(OnClickListener onClick) {
        this.onClick = onClick;
        return self();
    }

    public T id(Integer id) {
        this.id = id;
        return self();
    }

    public T alpha(Float alpha) {
        this.alpha = alpha;
        return self();
    }

    public T background(Drawable background) {
        this.background = background;
        return self();
    }

    public T backgroundColor(Integer backgroundColor) {
        this.backgroundColor = backgroundColor;
        return self();
    }

    public T backgroundResource(Integer backgroundResource) {
        this.backgroundResource = backgroundResource;
        return self();
    }

    public T enabled(Boolean enabled) {
        this.enabled = enabled;
        return self();
    }

    public T minHeight(Integer minHeight) {
        this.minHeight = minHeight;
        return self();
    }

    public T minWidth(Integer minWidth) {
        this.minWidth = minWidth;
        return self();
    }

    public T onLongClick(OnLongClickListener onLongClick) {
        this.onLongClick = onLongClick;
        return self();
    }

    public T paddingLeft(Integer paddingLeft) {
        this.paddingLeft = paddingLeft;
        return self();
    }

    public T paddingRight(Integer paddingRight) {
        this.paddingRight = paddingRight;
        return self();
    }

    public T paddingTop(Integer paddingTop) {
        this.paddingTop = paddingTop;
        return self();
    }

    public T paddingBottom(Integer padding) {
        this.paddingBottom = padding;
        return self();
    }

    public T padding(Integer paddingTopBottom, Integer paddingLeftRight) {
        this.paddingTop = paddingTopBottom;
        this.paddingBottom = paddingTopBottom;
        this.paddingLeft = paddingLeftRight;
        this.paddingRight = paddingLeftRight;
        return self();
    }

    public T padding(Integer padding) {
        this.paddingTop = padding;
        this.paddingBottom = padding;
        this.paddingLeft = padding;
        this.paddingRight = padding;
        return self();
    }

    public T visibility(Integer visibility) {
        this.visibility = visibility;
        return self();
    }

    public T invisible() {
        this.visibility = View.INVISIBLE;
        return self();
    }

    public T visible() {
        this.visibility = View.VISIBLE;
        return self();
    }

    public T gone() {
        this.visibility = View.GONE;
        return self();
    }
}
