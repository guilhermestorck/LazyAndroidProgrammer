package com.github.guilhermestorck.lap;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import com.github.guilhermestorck.lap.builder.*;
import com.github.guilhermestorck.lap.util.LAPFragment;

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

    public static LAPFragment LAPFragment(Context ctx, LAPView view)
    {
        return LAPFragment.make(ctx, view);
    }

    public static LAPFragment LAPFragment(View view)
    {
        return LAPFragment.make(view);
    }

}
