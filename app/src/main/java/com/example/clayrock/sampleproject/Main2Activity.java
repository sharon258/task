package com.example.clayrock.sampleproject;

import android.graphics.*;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private TabLayout mTabLayout;
    private Toolbar mToolbar;

    private final int tabsCount = 3;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager,viewPager;
    private int[] tabIconsGrey = {
            R.drawable.videoprimary,
            R.drawable.imagess,
            R.drawable.milestoneimages
    };
    private int[] tabIconsPrimary = {
            R.drawable.ic_action_name,
            R.drawable.imageprimary,
            R.drawable.milestoneprimary

    };
    private static final int NUM_PAGES = 3;
    private String [] names = {"VIDEOS","IMAGES","MILESTONES"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mToolbar=(Toolbar)findViewById(R.id.toolbar);
        mToolbar.setTitle("HOME");
        setSupportActionBar(mToolbar);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        viewPager=(ViewPager)findViewById(R.id.viewPager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mTabLayout=(TabLayout)findViewById(R.id.tabs);
        mTabLayout.setupWithViewPager(mViewPager);
        viewPager.setAdapter(new ScreenSlidePagerAdapter(getSupportFragmentManager()));

        setupTabIcons();

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i =0 ;i< tabsCount;i++){

                    TextView text  =(TextView) mTabLayout.getTabAt(i).getCustomView();
                    if(text != null){
                        if(i == position){
                            text.setTextColor(getResources().getColor(R.color.colorPrimary));
                            text.setCompoundDrawablesWithIntrinsicBounds(0, tabIconsPrimary[i], 0, 0);
                        }
                        else{
                            text.setTextColor(getResources().getColor(R.color.colorGrey));
                            text.setCompoundDrawablesWithIntrinsicBounds(0, tabIconsGrey[i], 0, 0);

                        }
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Dashboard_Viewpager_Fragment fragment = new Dashboard_Viewpager_Fragment();
            Bundle bundle = new Bundle();
            bundle.putInt("NUM", position);
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

    private void setupTabIcons() {

        for (int i =0 ;i< tabsCount;i++){
            TextView text = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
            text.setText(names[i]);

            if(i == 0){
                text.setTextColor(getResources().getColor(R.color.colorPrimary));
                text.setCompoundDrawablesWithIntrinsicBounds(0, tabIconsPrimary[i], 0, 0);
            }else{

                text.setCompoundDrawablesWithIntrinsicBounds(0, tabIconsGrey[i], 0, 0);
            }
            TabLayout.Tab v = mTabLayout.getTabAt(i);
            if( v != null)
                v.setCustomView(text);

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView;
            if(getArguments().getInt(ARG_SECTION_NUMBER) == 1){
                rootView = inflater.inflate(R.layout.fragment_vides, container, false);
                RecyclerView r = (RecyclerView) rootView.findViewById(R.id.cards_);
                List<Movie> movies = new ArrayList();
                movies.add(new Movie(R.drawable.rockstar,"HELLO HELLO LILA","18 Hours Ago","this song is dedicated to all andriod application developers.."));
                movies.add(new Movie(R.drawable.rockstar,"KEVU KEKA NAA SAMIRANGA","10 Hours Ago","this song is dedicated to all andriod application developers.."));
                movies.add(new Movie(R.drawable.rockstar,"THAMUDU NEE THIKAMAKA DIGULEEEE","12 Hours Ago","this song is dedicated to all andriod application developers.."));
                movies.add(new Movie(R.drawable.rockstar,"VAREVAA EMII PESIII ACHAM ","10 Hours Ago","this song is dedicated to all andriod application developers.."));
                movies.add(new Movie(R.drawable.rockstar,"VERAM MISAM LAGA ","8 Hours Ago","this song is dedicated to all andriod application developers.."));

                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
                r.setHasFixedSize(true);
                r.setLayoutManager(mLayoutManager);

                CardsAdapter adapter = new CardsAdapter(getContext(), movies);
                r.setAdapter(adapter);
//                TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//                textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            }
            else if (getArguments().getInt(ARG_SECTION_NUMBER) == 2){
                rootView = inflater.inflate(R.layout.fragment_images, container, false);
//                TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//                textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            }
            else {
                rootView = inflater.inflate(R.layout.fragment_milestone, container, false);
//                TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//                textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            }

            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return tabsCount;
        }
    }
}
