package com.example.stadtapp;

	import android.os.Bundle;
	import android.view.LayoutInflater;
	import android.view.View;
	import android.view.ViewGroup;
	import android.app.Fragment;
	 
	public class PhotoFragmentTab extends Fragment {
	    @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	        View rootView = inflater.inflate(R.layout.photo_layout, container, false);
	        return rootView;
	    }
	}
