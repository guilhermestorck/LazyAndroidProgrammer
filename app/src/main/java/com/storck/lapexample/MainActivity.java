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
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.guilhermestorck.lap.builder.LAPView;
import com.github.guilhermestorck.lap.util.LAPBindableViewMaker;
import com.github.guilhermestorck.lap.util.LAPViewMaker;

import java.util.ArrayList;
import java.util.List;

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

    public List<Item> generateList(int size) {
        List<Item> items = new ArrayList<>();
        for(int i = 0; i < size; ++i) {
            Item item = new Item();
            item.nome = String.valueOf((char)('A' + i%23)) + String.valueOf(i/23 + 1);
            item.index = i;
            switch(i%5){
                case 0: item.bla = "Bla"; break;
                case 1: item.bla = "Ble"; break;
                case 2: item.bla = "Bli"; break;
                case 3: item.bla = "Blo"; break;
                case 4: item.bla = "Blu"; break;
            }
            items.add(item);
        }
        return items;
    }

    public class Item {
        public String nome;
        public Integer index;
        public String bla;

        public String toString() {
            return nome + " [" + index + "] " + bla;
        }
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
                        build(LAPVerticalLayout(
                            LAPTextView("LAPTextView"),
                            LAPTextView("This is a LAPTextView").weight(1).height(0)
                        ), ctx)
                    );
                case 1:
                    return LAPFragment(
                        build(LAPVerticalLayout(
                            LAPTextView("LAPButtonView").backgroundColor(Color.GREEN).weight(7),
                            LAPButton("This is a ALAPButton").weight(3).height(0)
                        ), ctx)
                    );
                case 2:
                    return LAPFragment(
                        build(LAPVerticalLayout(
                            LAPTextView("LAPHorizontalLayout"),
                            LAPHorizontalLayout(
                                LAPButton("Wrapping").wrapHeight().gravity(Gravity.CENTER_VERTICAL),
                                LAPButton("Filling").fillHeight(),
                                LAPButton("Bigger weight").weight(1)
                            ).weight(1)
                        ), ctx)
                    );
                case 3:
                    return LAPFragment(
                        build(LAPButton("I'm a pink button").backgroundColorRes(R.color.colorAccent), ctx)
                    );
                case 4:
                    return LAPFragment(
                        build(LAPVerticalLayout(
                            LAPTextView("LAPListView simple"),
                            LAPListView(generateList(50)).weight(1).height(0)
                        ), ctx)
                    );
                case 5:
                    return LAPFragment(
                        build(LAPVerticalLayout(
                            LAPTextView("LAPListView with LAPViewMaker"),
                            LAPListView(generateList(50), new LAPViewMaker<Item>() {
                                @Override
                                public LAPView makeView(Item item) {
                                    return LAPHorizontalLayout(
                                        LAPTextView(item.nome).padding(dp(16)),
                                        LAPTextView(item.bla).allCaps(true).margin(dp(16), dp(8))
                                    );
                                }
                            }).weight(1).height(0)
                        ), ctx)
                    );
                case 6:
                    return LAPFragment(
                        build(LAPVerticalLayout(
                            LAPTextView("LAPListView with LAPViewMaker"),
                            LAPListView(generateList(50), new LAPBindableViewMaker<Item>() {

                                Integer idName = generateId();
                                Integer idBla = generateId();

                                @Override
                                public LAPView makeView() {
                                    return LAPVerticalLayout(
                                        LAPButton("").id(idName).margin(dp(16)),
                                        LAPTextView("").id(idBla).padding(dp(32))
                                    );
                                }

                                @Override
                                public View bind(View v, Item object) {
                                    Button btnName = (Button) v.findViewById(idName);
                                    TextView txtBla = (TextView) v.findViewById(idBla);
                                    btnName.setText(object.nome);
                                    txtBla.setText(object.bla);
                                    txtBla.setAllCaps(object.index % 2 == 0);
                                    return v;
                                }
                            })), ctx)
                    );
            }
            return null;
        }

        @Override
        public int getCount() {
            return 7;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Lazy Android Programmer";
        }
    }

}
