package com.example.stadtapp;

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

import com.example.stadtapp.R;
import com.example.stadtapp.tabs.BilderFragmentTab;
import com.example.stadtapp.tabs.MapFragmentTab;
import com.example.stadtapp.tabs.PhotoFragmentTab;
import com.example.stadtapp.tabs.TabListener;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends FragmentActivity{

	Button btn_maps;
		
		// Declaring our tabs and the corresponding fragments.
		ActionBar.Tab mapTab, photoTab, bilderTab;
		Fragment mapFragmentTab = new MapFragmentTab();
		Fragment photoFragmentTab = new PhotoFragmentTab();
		Fragment bilderFragmentTab = new BilderFragmentTab();
		public static FragmentManager fragmentManager;
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);
			
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
	        
	        fragmentManager = getFragmentManager();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/* Funzt nicht der Driss
		JSONObject jsonDoc = new JSONObject();
		try {
		jsonDoc.put("name", "Lolipop"); // erstellt Name=Value‐Paar
		jsonDoc.put("latitude", 58.0);
		jsonDoc.put("longitude", 7.88);
		} catch (JSONException e) {
		e.printStackTrace();
		} // end try
		String body = jsonDoc.toString();
		JSONperHTTP jsonHTTP = new JSONperHTTP(); // eigene Hilfsklasse
		String returnPost = jsonHTTP.makeHttpPost("http://141.28.100.212:5984/_utils/index.html", "POST", null,
		body);
		
		
		
		
		findViewById(R.id.btn_gmap).setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        //Inform the user the button has been clicked
		        Toast.makeText(MainActivity.this, "Button1 clicked.", Toast.LENGTH_SHORT).show(); 
		        Intent intent = new Intent(MainActivity.this, GoogleMapsActivity.class);
	            startActivity(intent);
		    }
		});
		
		findViewById(R.id.btn_photo).setOnClickListener( new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        //Inform the user the button has been clicked
		        Toast.makeText(MainActivity.this, "Button1 clicked.", Toast.LENGTH_SHORT).show(); 
		        Intent intent = new Intent(MainActivity.this, EventsDemoActivity.class);
	            startActivity(intent);
		    }
		});
		
	}


	public static HttpResponse makeUpdateRequest(String uri, Bitmap bmp) {
	    try {
	        HttpPut httpPut = new HttpPut(uri);
	        ByteArrayOutputStream stream = new ByteArrayOutputStream();
	        bmp.compress(Bitmap.CompressFormat.PNG, 0, stream);
	        ByteArrayEntity entity = new ByteArrayEntity(stream.toByteArray());
	        entity.setContentType("image/png");
	        entity.setChunked(true);
	        httpPut.setEntity(entity);
	        return new DefaultHttpClient().execute(httpPut);
	    } catch (UnsupportedEncodingException e) {
	        e.printStackTrace();
	    } catch (ClientProtocolException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
*/

	}
	

	
	


