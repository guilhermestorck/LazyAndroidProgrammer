package com.github.guilhermestorck.lap.util;

import com.github.guilhermestorck.lap.builder.LAPView;
import android.view.View;

/**
 * Created by gstorck on 17/12/2015.
 */
public interface LAPBindableViewMaker<T> {

    LAPView makeView();

    View bind(View v, T object);

}
