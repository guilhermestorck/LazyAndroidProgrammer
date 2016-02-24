package com.github.guilhermestorck.lap.builder;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.github.guilhermestorck.lap.util.LAPAdapter;
import com.github.guilhermestorck.lap.util.LAPBindableAdapter;
import com.github.guilhermestorck.lap.util.LAPBindableViewMaker;
import com.github.guilhermestorck.lap.util.LAPViewMaker;

import java.util.List;

/**
 * Created by gstorck on 10/12/2015.
 */
abstract class ALAPListView<T, I> extends ALAPViewGroup<T> {

    List<I> items = null;
    ListAdapter adapter = null;
    LAPViewMaker<I> viewMaker = null;
    LAPBindableViewMaker<I> bindableViewMaker = null;
    Drawable dividerDrawable = null;
    Integer dividerHeight = null;

    ALAPListView() {  }

    public ListView build(Activity activity) {
        ListView view = new ListView(activity);
        return fill(view, activity);
    }

    protected ListView fill(ListView v, Activity activity) {
        if(dividerDrawable != null) v.setDivider(dividerDrawable);
        if(dividerHeight != null) v.setDividerHeight(dividerHeight);
        if(adapter != null) {
            v.setAdapter(adapter);
        } else {
            if(viewMaker != null) {
                v.setAdapter(createLAPAdapter(activity, items, viewMaker));
            } else if(bindableViewMaker != null) {
                v.setAdapter(createLAPAdapter(activity, items, bindableViewMaker));
            } else {
                v.setAdapter(createLAPAdapter(activity, items));
            }
        }
        return (ListView) super.fill(v, activity);
    }

    public T dividerDrawable(Drawable dividerDrawable) {
        this.dividerDrawable = dividerDrawable;
        return self();
    }

    public T dividerHeight(Integer dividerHeight) {
        this.dividerHeight = dividerHeight;
        return self();
    }

    public T adapter(ListAdapter adapter) {
        this.adapter = adapter;
        this.items = null;
        this.viewMaker = null;
        this.bindableViewMaker = null;
        return self();
    }

    public T adapter(List<I> items, LAPViewMaker<I> viewMaker) {
        this.adapter = null;
        this.items = items;
        this.viewMaker = viewMaker;
        this.bindableViewMaker = null;
        return self();
    }

    public T adapter(List<I> items, LAPBindableViewMaker<I> viewMaker) {
        this.adapter = null;
        this.items = items;
        this.viewMaker = null;
        this.bindableViewMaker = viewMaker;
        return self();
    }

    public T adapter(List<I> items) {
        this.adapter = null;
        this.items = items;
        this.viewMaker = null;
        this.bindableViewMaker = null;
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

    private ListAdapter createLAPAdapter(final Activity activity, List<I> items, LAPBindableViewMaker<I> viewMaker) {
        return new LAPBindableAdapter<I>(activity, items, viewMaker);
    }

}
