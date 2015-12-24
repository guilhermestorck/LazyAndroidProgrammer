package com.github.guilhermestorck.lap;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toolbar;

import com.github.guilhermestorck.lap.builder.LAP;
import com.github.guilhermestorck.lap.builder.LAPButton;
import com.github.guilhermestorck.lap.builder.LAPCheckBox;
import com.github.guilhermestorck.lap.builder.LAPLinearLayout;
import com.github.guilhermestorck.lap.builder.LAPTextView;
import com.github.guilhermestorck.lap.builder.LAPView;
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

    /* Linear Layouts */
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

    public LazyAndroidProgrammer() {
        LAPVerticalLayout(
            LAPButton("Teste").onClick(null),
            LAPButton("Outro teste").onClick(null)
        );
        LAPButton("Teste").text("Another label").onClick(null).build(null);
    }

}
