package com.namMysuruData.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class PagerAdapterTab extends FragmentStatePagerAdapter {


    List<Fragment> fragmentList = new ArrayList<>();
    List<String> fragmentNameList = new ArrayList<>();

    public PagerAdapterTab(@NonNull FragmentManager fm, int numberofTabs) {
        super(fm, numberofTabs);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentNameList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    public void addFragment(Fragment fragment, String title) {
        fragmentList.add(fragment);
        fragmentNameList.add(title);

    }
}
