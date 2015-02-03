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
            //Fragement for Android Tab
            return new MapFragmentTab();
        case 1:
           //Fragment for Ios Tab
            //return new Ios();
            return new PhotoFragmentTab();
        case 2:
            //Fragment for Windows Tab
            return new BilderFragmentTab();
        case 3:
            //Fragment for Windows Tab
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