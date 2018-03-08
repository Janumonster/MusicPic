package com.example.peanut.reviewmyskill.adptor;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.example.peanut.reviewmyskill.R;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Peanut on 2018/3/8.
 */

public class Fragment_adapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;

    public Fragment_adapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragmentList=fragments;

    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

}
