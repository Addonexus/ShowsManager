package com.example.showsmanager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.showsmanager.PopularShowsFragment;

public class TabPager extends FragmentPagerAdapter {
    private static final int NUM_ITEMS = 4;

    public TabPager(FragmentManager fragmentManager){super(fragmentManager);}
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new PopularShowsFragment();
            case 1:
                return new PopularShowsFragment();
            case 2:
                return new PopularShowsFragment();
            case 3:
                return new PopularShowsFragment();
            default:
                return null;
        }
    }

    @Override
        public int getCount() {
            return NUM_ITEMS;
        }
    }

