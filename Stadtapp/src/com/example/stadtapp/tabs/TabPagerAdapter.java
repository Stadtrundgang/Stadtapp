package com.example.stadtapp.tabs;


import com.example.stadtapp.RegisterActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class TabPagerAdapter extends FragmentStatePagerAdapter {
    public TabPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int i) {
		switch (i) {
        case 0:
            return new PhotoFragmentTab();
        case 1:
            return new MapFragmentTab();
        case 2:
            return new BilderFragmentTab();
        case 3:
            return new RegisterActivity();
        }
		return null;	
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 4; //No of Tabs
	}


    }