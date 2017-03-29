package com.yf.fengmai.demo3;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by fengmai on 2017/3/23.
 */

public class Fragmentadapter extends FragmentPagerAdapter{
    private ArrayList<Fragment> fragmentlist;

    public Fragmentadapter(FragmentManager fm, ArrayList<Fragment> fragmentlist) {
        super(fm);
        this.fragmentlist = fragmentlist;
    }

    public Fragmentadapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (fragmentlist!=null){
            return fragmentlist.get(position);
        }
        return null;
    }

    @Override
    public int getCount() {
        if (fragmentlist!=null){
            return fragmentlist.size();
        }
        return 0;
    }
}
