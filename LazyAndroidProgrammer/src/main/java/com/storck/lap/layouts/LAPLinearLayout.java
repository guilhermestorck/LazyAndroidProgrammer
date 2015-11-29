package com.storck.lap.layouts;

import android.content.Context;
import android.widget.LinearLayout;

/**
 * Created by gstorck on 27/11/2015.
 */
public class LAPLinearLayout extends LinearLayout{

    public LAPLinearLayout(Context ctx, int orientation, LAPLayoutedView... views) {
        super(ctx);
        this.setOrientation(orientation);
        for(LAPLayoutedView view : views) {
            this.addView(view.getView(), view.getLayoutParams(this));
        }
    }
}
