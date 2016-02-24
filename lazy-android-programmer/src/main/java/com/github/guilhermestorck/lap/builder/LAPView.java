package com.github.guilhermestorck.lap.builder;

import android.app.Activity;
import android.view.View;

/**
 * Created by gstorck on 10/12/2015.
 */
public interface LAPView {

    View build(Activity activity);

    interface OnViewBuilt {

        void onViewBuilt(View view, Activity activity);

    }

}
