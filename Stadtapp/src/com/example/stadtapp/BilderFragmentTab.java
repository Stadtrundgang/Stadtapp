package com.example.stadtapp;

	import android.os.Bundle;
	import android.view.LayoutInflater;
	import android.view.View;
	import android.view.ViewGroup;
	import android.app.Fragment;
	 
	public class BilderFragmentTab extends Fragment {
	    @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	        View rootView = inflater.inflate(R.layout.bilder_layout, container, false);
	        return rootView;
	    }
	}
