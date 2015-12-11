package com.github.guilhermestorck.lap;

import android.view.View;
import android.widget.LinearLayout;

import com.github.guilhermestorck.lap.builder.LAPButton;
import com.github.guilhermestorck.lap.builder.LAPLinearLayout;
import com.github.guilhermestorck.lap.builder.LAPTextView;
import com.github.guilhermestorck.lap.builder.LAPView;

/**
 * Created by gstorck on 19/11/2015.
 */
public class LazyAndroidProgrammer {

    public static LAPTextView LAPTextView(String label) {
        return new LAPTextView(label);
    }

    public static LAPButton LAPButton(String label) {
        return new LAPButton(label);
    }

    public static LAPButton LAPButton(String label, View.OnClickListener callback) {
        return new LAPButton(label, callback);
    }

    public static LAPLinearLayout LAPLinearLayout(int orientation, LAPView... views) { return new LAPLinearLayout(orientation, views); }
    public static LAPLinearLayout LAPVerticalLayout(LAPView... views) { return new LAPLinearLayout(LinearLayout.VERTICAL, views); }
    public static LAPLinearLayout LAPHorizontalLayout(LAPView... views) { return new LAPLinearLayout(LinearLayout.HORIZONTAL, views); }

    //public static LAPView LAPView(View v) {}

    public LazyAndroidProgrammer() {
        LAPVerticalLayout(
            LAPButton("Teste").onClick(null),
            LAPButton("Outro teste").onClick(null)
        );
        LAPButton("Teste").text("Another label").onClick(null).build(null);
    }

}
