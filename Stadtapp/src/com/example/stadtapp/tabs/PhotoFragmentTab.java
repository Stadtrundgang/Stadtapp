package com.example.stadtapp.tabs;

	import static us.monoid.web.Resty.content;
import static us.monoid.web.Resty.put;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import us.monoid.web.JSONResource;
import us.monoid.web.Resty;
import static us.monoid.web.Resty.*;
import com.example.stadtapp.R;
import com.example.stadtapp.R.id;
import com.example.stadtapp.R.layout;
import com.google.android.gms.location.LocationListener;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.DocumentsContract.Root;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
	
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;	
	
	
	public class PhotoFragmentTab extends Fragment {

		
	    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 1888;
	    Button button, button2;
	    ImageView imageView;
	    
	    private TextView latituteField;
	    private TextView longitudeField;
	    private LocationManager locationManager;
	    private String provider;
	    
	    @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {

	        final View rootView = inflater.inflate(R.layout.photo_layout,
	                container, false);

	        button = (Button) rootView.findViewById(R.id.button_photo);
	        button2 = (Button) rootView.findViewById(R.id.button_upload);
	        imageView = (ImageView) rootView.findViewById(R.id.imageview);

	        OnClickListener listener = new OnClickListener(){

				@Override
				public void onClick(View view) {
					
					switch(view.getId()){
		        	
		        	case R.id.button_photo :
		            	{
		        		Toast.makeText(getActivity(),"photo!",Toast.LENGTH_SHORT).show();
			                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
			                startActivityForResult(intent,
			                CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
		            		break;
		            	}
		        	case R.id.button_upload :
		            	{       
		            		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		                    StrictMode.setThreadPolicy(policy);
		        			Toast.makeText(getActivity(),"uploading!",Toast.LENGTH_SHORT).show();
		            		Resty r = new Resty();	            		
		            		JSONResource json;
		    				try {
		    					json = r.json("http://141.28.100.212:5984/");
		    						System.out.println("Database UUID: " + json.get("uuid"));	            		
		            		json = r.json("http://141.28.100.212:5984/stadtapp/" + System.currentTimeMillis(),
		            				put(content("{\"latitude \":\"48.124\", \"longitude\":\"12.133\"t, \"beschreibung\":\"stehe vor der kirche\"}")));	
		            				//put(content("{\"nick_name\":\"xxx\", \"real_name\":\"Max xxx\", \"email\":\"user@mustermann.de\", \"password\":\"geheim\"}")));	            			
		            		if(!(Boolean)json.get("ok")) {
		            			throw new Exception(json.get("error") + ": " + json.get("cause"));    			
		            		}	            		
		            		String doc = json.get("id").toString();
		            		System.out.println("Created user " + doc);	            		
		            		json = r.json("http://141.28.100.212:5984/stadtapp/" + doc);
		            		System.out.println("Refetched user from db:");
		            		System.out.println("\tid: " + json.get("_id"));
		            		System.out.println("\trev: " + json.get("_rev"));
		            		//System.out.println("\tnick_name: " + json.get("nick_name"));
		            		//System.out.println("\treal_name: " + json.get("real_name"));
		            		//System.out.println("\temail: " + json.get("email"));
		            		//System.out.println("\tpassword: " + json.get("password"));
		    				    					
		    				} catch (IOException e) {
		    					// TODO Auto-generated catch block
		    					e.printStackTrace();
		    				} catch (Exception e) {
		    					// TODO Auto-generated catch block
		    					e.printStackTrace();
		    				}      			            		
		        		break;
		        	}
		        	
		        	default:
		        		break;
		        	
		        	
		        	}
				}   	
	        };
	        
	        rootView.findViewById(R.id.button_photo).setOnClickListener(listener);
	        rootView.findViewById(R.id.button_upload).setOnClickListener(listener);

	       	 // Get the location manager 
	        locationManager = 
	        (LocationManager)getActivity().getSystemService(Context.LOCATION_SERVICE);
	        // Define the criteria how to select the locatioin provider -> use
	        // default
	        Criteria criteria = new Criteria();
	        provider = locationManager.getBestProvider(criteria, false);
	        Location location = locationManager.getLastKnownLocation(provider);
      
	        return rootView;

	    }
	    
	    
	    
	    

	    @Override
	    public void onActivityResult(int requestCode, int resultCode, Intent data) {
	        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
	            if (resultCode == Activity.RESULT_OK) {

	                Bitmap bmp = (Bitmap) data.getExtras().get("data");
	                ByteArrayOutputStream stream = new ByteArrayOutputStream();

	                bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
	                byte[] byteArray = stream.toByteArray();

	                // Convert ByteArray to Bitmap::

	                Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0,
	                        byteArray.length);

	                imageView.setImageBitmap(bitmap);

	            }
	        }        
	    }   
	    
	}
	
	
	
	
	
	
/*	 
	public class PhotoFragmentTab extends Fragment {
	    @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	        View rootView = inflater.inflate(R.layout.photo_layout, container, false);
	        return rootView;
	    }
	}
*/