package com.yf.fengmai.demo3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by fengmai on 2017/3/23.
 */

public class Fragment extends android.support.v4.app.Fragment{
    private FragmentManager fm;
    private ArrayList<Fragment> list;
    private ViewPager vp;
    private Fragmentadapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment,null);
        vp= (ViewPager) view.findViewById(R.id.headervp);
        list=new ArrayList<>();
        for (int i = 0; i < 3; i++) {

        }
        return view;
    }
}
