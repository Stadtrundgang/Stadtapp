package com.example.stadtapp.test;

import static us.monoid.web.Resty.*;
import us.monoid.web.AbstractContent;
import us.monoid.web.Resty.*;
import java.io.IOException;

import com.example.stadtapp.R;
import com.example.stadtapp.R.id;
import com.example.stadtapp.R.layout;

import us.monoid.web.JSONResource;
import us.monoid.web.Resty;
import static us.monoid.web.Resty.*;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * 
 * Register Activity Class
 */
public class RegisterActivity extends Fragment {

	Button button;
    EditText nameET;
    // Email Edit View Object
    EditText emailET;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	
    	
    	StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        
        final View rootView = inflater.inflate(R.layout.register,
                container, false);
        button = (Button)rootView.findViewById(R.id.btnRegister);
        // Find Name Edit View control by ID
        nameET = (EditText)rootView.findViewById(R.id.editText1);
        // Find Email Edit View control by ID
        emailET = (EditText)rootView.findViewById(R.id.editText2);
      
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
            	
            	Resty r = new Resty();
        		
        		JSONResource json;
				try {
					json = r.json("http://141.28.100.212:5984/");
						System.out.println("Database UUID: " + json.get("uuid"));
        		
        		json = r.json("http://141.28.100.212:5984/stadtrundgang_users/" + "Test00".hashCode(),
        				put(content("{\"nick_name\":\"User\", \"real_name\":\"Max User\", \"email\":\"user@mustermann.de\", \"password\":\"geheim\"}")));
        			
        		if(!(Boolean)json.get("ok")) {
        			throw new Exception(json.get("error") + ": " + json.get("cause"));    			
        		}
        		
        		String doc = json.get("id").toString();
        		System.out.println("Created user " + doc);
        		
        		json = r.json("http://141.28.100.212:5984/stadtrundgang_users/" + doc);
        		System.out.println("Refetched user from db:");
        		System.out.println("\tid: " + json.get("_id"));
        		System.out.println("\trev: " + json.get("_rev"));
        		System.out.println("\tnick_name: " + json.get("nick_name"));
        		System.out.println("\treal_name: " + json.get("real_name"));
        		System.out.println("\temail: " + json.get("email"));
        		System.out.println("\tpassword: " + json.get("password"));
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	

       }
        });
        return rootView;
    }
 


 
}