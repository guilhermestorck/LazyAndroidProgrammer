package com.github.guilhermestorck.lap;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;

import com.github.guilhermestorck.lap.builder.*;
import com.github.guilhermestorck.lap.util.LAPFragment;
import com.github.guilhermestorck.lap.util.LAPViewMaker;

import java.util.List;

/**
 * Created by gstorck on 19/11/2015.
 */
public class LazyAndroidProgrammer {

    /* Text View */
    public static LAPTextView LAPTextView(String label)
    {
        return new LAPTextView(label);
    }

    public static LAPTextView LAPTextView(Integer labelRes)
    {
        return new LAPTextView(labelRes);
    }

    /* Buttons */
    public static LAPButton LAPButton(String label)
    {
        return new LAPButton(label);
    }

    public static LAPButton LAPButton(String label, View.OnClickListener callback)
    {
        return new LAPButton(label, callback);
    }

    public static LAPButton LAPButton(Integer labelRes)
    {
        return new LAPButton(labelRes);
    }

    public static LAPButton LAPButton(Integer labelRes, View.OnClickListener callback)
    {
        return new LAPButton(labelRes, callback);
    }

    public static LAPCheckBox LAPCheckBox(String label)
    {
        return new LAPCheckBox(label);
    }

    public static LAPCheckBox LAPCheckBox(String label, Boolean checked)
    {
        return new LAPCheckBox(label, checked);
    }

    public static LAPCheckBox LAPCheckBox(Integer labelRes)
    {
        return new LAPCheckBox(labelRes);
    }

    public static LAPCheckBox LAPCheckBox(Integer labelRes, Boolean checked)
    {
        return new LAPCheckBox(labelRes, checked);
    }

    public static LAPRadioButton LAPRadioButton(String label)
    {
        return new LAPRadioButton(label);
    }

    public static LAPRadioButton LAPRadioButton(String label, Boolean checked)
    {
        return new LAPRadioButton(label, checked);
    }

    public static LAPRadioButton LAPRadioButton(Integer labelRes)
    {
        return new LAPRadioButton(labelRes);
    }

    public static LAPRadioButton LAPRadioButton(Integer labelRes, Boolean checked)
    {
        return new LAPRadioButton(labelRes, checked);
    }

    /* Layouts */
    public static LAPLinearLayout LAPLinearLayout(int orientation, LAPView... views)
    {
        return new LAPLinearLayout(orientation, views);
    }

    public static LAPLinearLayout LAPVerticalLayout(LAPView... views)
    {
        return new LAPLinearLayout(LinearLayout.VERTICAL, views);
    }

    public static LAPLinearLayout LAPHorizontalLayout(LAPView... views)
    {
        return new LAPLinearLayout(LinearLayout.HORIZONTAL, views);
    }

    public static LAPFrameLayout LAPFrameLayout(LAPView view)
    {
        return new LAPFrameLayout(view);
    }

    public static LAPScrollView LAPScrollView(LAPView view)
    {
        return new LAPScrollView(view);
    }

    public static LAPHorizontalScrollView LAPHorizontalScrollView(LAPView view)
    {
        return new LAPHorizontalScrollView(view);
    }

    /* Wrappers */
    public static <T extends View> LAP<T> LAP(T view)
    {
        return new LAP<T>(view);
    }

    public static LAPFragment LAPFragment(Activity activity, LAPView view)
    {
        return LAPFragment.make(activity, view);
    }

    public static LAPFragment LAPFragment(View view)
    {
        return LAPFragment.make(view);
    }

    /* List views */
    public static <T> LAPListView<T> LAPListView(ListAdapter adapter)
    {
        return new LAPListView<T>(adapter);
    }

    public static <T> LAPListView<T> LAPListView(List<T> items)
    {
        return new LAPListView<T>(items);
    }

    public static <T> LAPListView<T> LAPListView(List<T> items, LAPViewMaker<T> viewMaker)
    {
        return new LAPListView<T>(items, viewMaker);
    }

    public static <T extends LAPView> View build(T lapView, Activity activity)
    {
        return LAPBuilder.build(lapView, activity);
    }

    /* Utils */
    public static int dp(int n)
    {
        return applyDimension(n, TypedValue.COMPLEX_UNIT_DIP);
    }

    public static int sp(int n)
    {
        return applyDimension(n, TypedValue.COMPLEX_UNIT_SP);
    }

    private static int applyDimension(int n, int unit)
    {
        return (int) TypedValue.applyDimension(unit, n, Resources.getSystem().getDisplayMetrics());
    }

}
