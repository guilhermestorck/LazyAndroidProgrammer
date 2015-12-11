package com.storck.lapexample;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.github.guilhermestorck.lap.builder.LAPTextView;
import com.github.guilhermestorck.lap.util.LAPFragment;

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
            Context ctx = MainActivity.this;
            switch (position) {
                case 0:
                    return LAPFragment.make(
                        LAPVerticalLayout(
                            LAPTextView("LAPTextView"),
                            LAPTextView("This is a LAPTextView")
                        ).build(ctx)
                    );
                case 1:
                    return LAPFragment.make(
                        LAPVerticalLayout(
                            LAPTextView("LAPButtonView"),
                            LAPButton("This is a ALAPButton")
                        ).build(ctx)
                    );
                case 2:
                    return LAPFragment.make(
                        LAPVerticalLayout(
                            LAPTextView("LAPHorizontalLayout"),
                            LAPHorizontalLayout(
                                LAPButton("I'm a wrapped button"),
                                LAPButton("I'm a button that fills the height").fillHeight(),
                                LAPButton("I have a bigger weight").weight(1)
                            ).fillWidth()
                        ).build(ctx)
                    );
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Lazy Android Programmer";
        }
    }

}
