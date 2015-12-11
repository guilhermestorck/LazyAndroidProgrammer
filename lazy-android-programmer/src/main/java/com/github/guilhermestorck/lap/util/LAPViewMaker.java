package com.github.guilhermestorck.lap.util;

import com.github.guilhermestorck.lap.builder.LAPView;

/**
 * Created by gstorck on 30/11/2015.
 */
public interface LAPViewMaker<T> {

    LAPView makeView(T object);

}
