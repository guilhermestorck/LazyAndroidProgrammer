package com.github.guilhermestorck.lap.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by gstorck on 30/11/2015.
 */
public class LAPAdapter<T> extends BaseAdapter {

    private List<T> items;
    private LAPViewMaker<T> viewMaker;
    private Context ctx;

    public LAPAdapter(final Context ctx, List<T> items, LAPViewMaker<T> viewMaker) {
        this.ctx = ctx;
        this.items = items;
        this.viewMaker = viewMaker;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return viewMaker.makeView( (T) getItem(position) ).build(ctx);
    }
}
