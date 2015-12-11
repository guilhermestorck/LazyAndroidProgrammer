package com.github.guilhermestorck.lap.builder;

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

    public ListView build(Context ctx) {
        ListView view = new ListView(ctx);
        return fill(view, ctx);
    }

    protected ListView fill(ListView v, Context ctx) {
        v = (ListView) super.fill(v, ctx);
        if(adapter != null) {
            v.setAdapter(adapter);
        } else {
            if(viewMaker != null) {
                v.setAdapter(createLAPAdapter(ctx, items, viewMaker));
            } else {
                v.setAdapter(createLAPAdapter(ctx, items));
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

    private ListAdapter createLAPAdapter(final Context ctx, List<I> items) {
        return createLAPAdapter(ctx, items, new LAPViewMaker() {

            @Override
            public LAPView makeView(Object object) {
                return new LAPTextView(object.toString()).padding(16);
            }

        });
    }

    private ListAdapter createLAPAdapter(final Context ctx, List<I> items, LAPViewMaker<I> viewMaker) {
        return new LAPAdapter<I>(ctx, items, viewMaker);
    }

}
