package com.github.guilhermestorck.lap.util;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.guilhermestorck.lap.LAPBuilder;
import com.github.guilhermestorck.lap.builder.LAPView;

/**
 * Created by gstorck on 01/12/2015.
 */
public class LAPFragment extends Fragment {

    public LAPFragment() {
    }

    View view;

    public static LAPFragment make(View view) {
        LAPFragment frag = new LAPFragment();
        frag.view = view;
        return frag;
    }

    public static LAPFragment make(Activity activity, LAPView view) {
        LAPFragment frag = new LAPFragment();
        frag.view = LAPBuilder.build(view, activity);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return view;
    }
}
