package com.github.guilhermestorck.lap.builder;

import android.content.Context;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;

/**
 * Created by gstorck on 05/01/2016.
 */
abstract class ALAPHorizontalScrollView<T>  extends ALAPFrameLayout<T> {

    ALAPHorizontalScrollView() {
    }

    public HorizontalScrollView build(Context ctx) {
        HorizontalScrollView view = new HorizontalScrollView(ctx);
        return fill(view, ctx);
    }

    protected HorizontalScrollView fill(HorizontalScrollView v, Context ctx) {
        v = (HorizontalScrollView) super.fill(v, ctx);
        return v;
    }

}
