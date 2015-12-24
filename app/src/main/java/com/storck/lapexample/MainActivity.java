package com.storck.lapexample;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import static com.github.guilhermestorck.lap.LazyAndroidProgrammer.*;

public class MainActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Activity ctx = MainActivity.this;
            switch (position) {
                case 0:
                    return LAPFragment(
                        LAPVerticalLayout(
                            LAPTextView("LAPTextView"),
                            LAPTextView("This is a LAPTextView").weight(1).height(0)
                        ).build(ctx)
                    );
                case 1:
                    return LAPFragment(
                        LAPVerticalLayout(
                            LAPTextView("LAPButtonView").backgroundColor(Color.GREEN).weight(7),
                            LAPButton("This is a ALAPButton").weight(3).height(0)
                        ).build(ctx)
                    );
                case 2:
                    return LAPFragment(
                        LAPVerticalLayout(
                            LAPTextView("LAPHorizontalLayout"),
                            LAPHorizontalLayout(
                                LAPButton("I'm a wrapped button").wrapHeight().width(100),
                                LAPButton("I'm a button that fills the height").fillHeight().width(100),
                                LAPButton("I have a bigger weight").weight(1)
                            ).fillWidth()
                        ).build(ctx)
                    );
                case 3:
                    return LAPFragment(
                        LAPButton("I'm a pink button").backgroundColorRes(R.color.colorAccent).build(ctx)
                    );
            }
            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Lazy Android Programmer";
        }
    }

}
