package com.github.guilhermestorck.lap.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by gstorck on 17/12/2015.
 */
public class LAPBindableAdapter<T> extends BaseAdapter {

    private List<T> items;
    private LAPBindableViewMaker<T> viewMaker;
    private Context ctx;

    public LAPBindableAdapter(final Context ctx, List<T> items, LAPBindableViewMaker<T> viewMaker) {
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
        View bindView;
        if (convertView == null) {
            bindView = viewMaker.makeView().build(ctx);
        } else {
            bindView = convertView;
        }

        viewMaker.bind(bindView, (T) getItem(position));

        return bindView;
    }

}
