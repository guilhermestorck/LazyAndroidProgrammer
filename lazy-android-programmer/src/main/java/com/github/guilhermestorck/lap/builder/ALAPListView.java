package com.github.guilhermestorck.lap.builder;

import android.app.Activity;
import android.content.Context;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.github.guilhermestorck.lap.util.LAPAdapter;
import com.github.guilhermestorck.lap.util.LAPViewMaker;

import java.util.List;

/**
 * Created by gstorck on 10/12/2015.
 */
abstract class ALAPListView<T, I> extends ALAPViewGroup<T> {

    List<I> items = null;
    ListAdapter adapter = null;
    LAPViewMaker<I> viewMaker = null;

    ALAPListView() {  }

    public ListView build(Activity activity) {
        ListView view = new ListView(activity);
        return fill(view, activity);
    }

    protected ListView fill(ListView v, Activity activity) {
        v = (ListView) super.fill(v, activity);
        if(adapter != null) {
            v.setAdapter(adapter);
        } else {
            if(viewMaker != null) {
                v.setAdapter(createLAPAdapter(activity, items, viewMaker));
            } else {
                v.setAdapter(createLAPAdapter(activity, items));
            }
        }
        return v;
    }

    public T adapter(ListAdapter adapter) {
        this.adapter = adapter;
        this.items = null;
        this.viewMaker = null;
        return self();
    }

    public T adapter(List<I> items, LAPViewMaker<I> viewMaker) {
        this.adapter = null;
        this.items = items;
        this.viewMaker = viewMaker;
        return self();
    }

    public T adapter(List<I> items) {
        this.adapter = null;
        this.items = items;
        this.viewMaker = null;
        return self();
    }

    private ListAdapter createLAPAdapter(final Activity activity, List<I> items) {
        return createLAPAdapter(activity, items, new LAPViewMaker() {

            @Override
            public LAPView makeView(Object object) {
                return new LAPTextView(object.toString()).padding(16);
            }

        });
    }

    private ListAdapter createLAPAdapter(final Activity activity, List<I> items, LAPViewMaker<I> viewMaker) {
        return new LAPAdapter<I>(activity, items, viewMaker);
    }

}
