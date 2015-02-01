package com.example.stadtapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
//JSON
import org.json.JSONException;
import org.json.JSONObject;

import com.loopj.android.http.RequestParams;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Joey extends Fragment {

	private static String uriCouchDB = "http://141.28.100.212:5984/test";
	private static final String URL_KNEIPEN_DB = "http://141.28.100.212:5984/test";

	
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	        final View rootView = inflater.inflate(R.layout.register,
	                container, false);	        
	        
	        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	        StrictMode.setThreadPolicy(policy);
	        
	        Button button = (Button)rootView.findViewById(R.id.btnRegister);
	     	      
	        button.setOnClickListener(new OnClickListener() {
	            public void onClick(View v) {
	            	
	        
	            	CouchDBActivity cdba = new CouchDBActivity();
	            	//cdba.createDatabase("heyaaa");
	            	cdba.getJSONObject("http://141.28.120.50:5984", "kneipe");
	        		    	
			/*
	        			try {	
	        				DefaultHttpClient httpClient = new DefaultHttpClient();
	        				//HttpPost httpPost = new HttpPost("http://141.28.120.50:5984/kneipe");
	        				HttpPost httpPost = new HttpPost("http://141.28.100.212:5984/albums");
	        				String body = createKneipeDoc();
	        				StringEntity entity = new StringEntity(body);
	        				httpPost.setEntity(entity);
	        				httpPost.setHeader("Accept", "application/json");
	        				httpPost.setHeader("Content-type", "aplication/json");
	        				
	        				HttpResponse httpResponse = httpClient.execute(httpPost);
	        				System.out.println(httpResponse.toString());


	        				
	        			} catch (ClientProtocolException e) {
	        				// TODO Auto-generated catch block
	        				e.printStackTrace();
	        			} catch (IOException e) {
	        				// TODO Auto-generated catch block
	        				e.printStackTrace();
	        			}
	                        */
	                        
	                        
	            }
	        });
	        return rootView;
	    }
	 
	 
	 

		
		//JSON____________________________________________
		
		public static String createKneipeDoc() {
			String body = "";
			
			String kname = "Kneipe";
			Double d = Math.random();
			kname += d.toString();
			JSONObject jsonDoc = new JSONObject();
			try{
				jsonDoc.put("name", "Trolololo");
				jsonDoc.put("aoutor", "HXXPTestJavaPost");
				jsonDoc.put("latitude", 58.0);
				jsonDoc.put("longitude",  7.88);
			} catch (JSONException e) {
				e.printStackTrace();
			}//end try
			body = jsonDoc.toString();
			return body;
		}
		
		
	 
	 
	 
	 
}
