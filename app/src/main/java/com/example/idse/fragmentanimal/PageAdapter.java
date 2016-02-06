package com.example.idse.fragmentanimal;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Baptiste on 05/02/2016.
 */
public class PageAdapter extends FragmentStatePagerAdapter {

    private String[] titles = {"Choose", "View"};
    private Tab1Fragment tab1Fragment;
    private Tab2Fragment tab2Fragment;

    public PageAdapter(FragmentManager fm) {
        super(fm);
        tab1Fragment=new Tab1Fragment();
        tab2Fragment=new Tab2Fragment();
    }

    @Override
    public Fragment getItem(int i) {
        switch(i){
            case 0:
                return tab1Fragment;
            case 1:
                return tab2Fragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}