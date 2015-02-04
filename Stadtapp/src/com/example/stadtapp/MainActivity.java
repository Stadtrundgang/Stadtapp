package com.example.stadtapp;

import static us.monoid.web.Resty.content;
import static us.monoid.web.Resty.put;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import us.monoid.web.JSONResource;
import us.monoid.web.Resty;

import com.example.stadtapp.R;
import com.example.stadtapp.tabs.BilderFragmentTab;
import com.example.stadtapp.tabs.MapFragmentTab;
import com.example.stadtapp.tabs.PhotoFragmentTab;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;


import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {
	
	Button btn_maps;

		public static FragmentManager fragmentManager;

		ViewPager Tab;
	    com.example.stadtapp.tabs.TabPagerAdapter TabAdapter;
		ActionBar actionBar;
				
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);			
			
			 TabAdapter = new com.example.stadtapp.tabs.TabPagerAdapter(getSupportFragmentManager());
		        
		        Tab = (ViewPager)findViewById(R.id.activity_main);
		        Tab.setOnPageChangeListener(
		                new ViewPager.SimpleOnPageChangeListener() {
		                    @Override
		                    public void onPageSelected(int position) {		                  
		                    	actionBar = getActionBar();
		                    	actionBar.setSelectedNavigationItem(position);                    }
		                });
		        Tab.setAdapter(TabAdapter);
		        
		        actionBar = getActionBar();
		        //Enable Tabs on Action Bar
		        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		        ActionBar.TabListener tabListener = new ActionBar.TabListener(){

					@Override
					public void onTabReselected(android.app.ActionBar.Tab tab,
							FragmentTransaction ft) {
						// TODO Auto-generated method stub				
					}

					@Override
					 public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {		          
			            Tab.setCurrentItem(tab.getPosition());
			        }

					@Override
					public void onTabUnselected(android.app.ActionBar.Tab tab,
							FragmentTransaction ft) {
						// TODO Auto-generated method stub						
					}};
					
					//Add New Tab
					actionBar.addTab(actionBar.newTab().setText("Photo").setTabListener(tabListener));
					actionBar.addTab(actionBar.newTab().setText("Karte").setTabListener(tabListener));
					actionBar.addTab(actionBar.newTab().setText("Bilder").setTabListener(tabListener));
					//actionBar.addTab(actionBar.newTab().setText("DatenSenden").setTabListener(tabListener));
					
					fragmentManager = getFragmentManager();     
		}
		
		
			
}
	

/* NUR ALTER CODE ONE SWIPE FUNKTION	
		// Declaring our tabs and the corresponding fragments.
		//ActionBar.Tab mapTab, photoTab, bilderTab;
		//Fragment mapFragmentTab = new MapFragmentTab();
		//Fragment mapFragmentTab = new RegisterActivity();
		//Fragment photoFragmentTab = new PhotoFragmentTab();
		//Fragment bilderFragmentTab = new BilderFragmentTab();
// Asking for the default ActionBar element that our platform supports.
ActionBar actionBar = getActionBar();
 
// Screen handling while hiding ActionBar icon.
actionBar.setDisplayShowHomeEnabled(false);

// Screen handling while hiding Actionbar title.
actionBar.setDisplayShowTitleEnabled(false);

// Creating ActionBar tabs.
actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

// Setting custom tab icons.
mapTab = actionBar.newTab().setIcon(R.drawable.map_logo);
photoTab = actionBar.newTab().setIcon(R.drawable.photo_logo);
bilderTab = actionBar.newTab().setIcon(R.drawable.bilder_logo);

// Setting tab listeners.
mapTab.setTabListener(new TabListener(mapFragmentTab));
photoTab.setTabListener(new TabListener(photoFragmentTab));
bilderTab.setTabListener(new TabListener(bilderFragmentTab));

// Adding tabs to the ActionBar.
actionBar.addTab(mapTab);
actionBar.addTab(photoTab);
actionBar.addTab(bilderTab);
  */