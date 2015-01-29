package com.example.stadtapp;

import com.example.stadtapp.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity{

	Button btn_maps;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
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




}
	
	


