package com.example.stadtapp;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;
 
import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
 
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
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
        final View rootView = inflater.inflate(R.layout.register,
                container, false);
        button = (Button)rootView.findViewById(R.id.btnRegister);
        // Find Name Edit View control by ID
        nameET = (EditText)rootView.findViewById(R.id.editText1);
        // Find Email Edit View control by ID
        emailET = (EditText)rootView.findViewById(R.id.editText2);
      
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
            	
            	
            	//CouchDBActivity cdba = new CouchDBActivity();
            	
         
                String name = nameET.getText().toString();
                // Get Email ET control value
                String email = emailET.getText().toString();       
                RequestParams params = new RequestParams();
                // When Name Edit View, Email Edit View and Password Edit View have values other than Null
                        // Put Http parameter name with value of Name Edit View control
                        params.put("name", name);
                        // Put Http parameter username with value of Email Edit View control
                        params.put("username", email);          
                        invokeWS(params);
                       
                        
                        
                        
            }
        });
        return rootView;
    }
 
    /**
     * Method gets triggered when Register button is clicked
     * 
     * @param view
     */
    public void registerUser(View view){
        // Get NAme ET control value
        String name = nameET.getText().toString();
        // Get Email ET control value
        String email = emailET.getText().toString();       
        RequestParams params = new RequestParams();
        // When Name Edit View, Email Edit View and Password Edit View have values other than Null
                // Put Http parameter name with value of Name Edit View control
                params.put("name", name);
                // Put Http parameter username with value of Email Edit View control
                params.put("username", email);    
                params.put("latitude", 58.0);
                params.put("longitude", 7.88);
                invokeWS(params);
        } 
        // When any of the Edit View control left blank

 
    
 
    /**
     * Method that performs RESTful webservice invocations
     * 
     * @param params
     */
    public void invokeWS(RequestParams params){
        // Show Progress Dialog 
        
        // Make RESTful webservice call using AsyncHttpClient object
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://141.28.100.212:5984/albums",params ,new AsyncHttpResponseHandler() {
            // When the response returned by REST has Http response code '200'
            public void onSuccess(String response) {
                // Hide Progress Dialog
                
                 try {
                          // JSON Object
                         JSONObject obj = new JSONObject(response);
                         // When the JSON response has status boolean value assigned with true
                         if(obj.getBoolean("status")){
                             // Set Default Values for Edit View controls
                             setDefaultValues();
                             // Display successfully registered message using Toast
                             Toast.makeText(getActivity().getApplicationContext(), "You are successfully registered!", Toast.LENGTH_LONG).show();
                         } 
                         // Else display error message
                         else{
                             
                             Toast.makeText(getActivity().getApplicationContext(), obj.getString("error_msg"), Toast.LENGTH_LONG).show();
                         }
                 } catch (JSONException e) {
                     // TODO Auto-generated catch block
                     Toast.makeText(getActivity().getApplicationContext(), "Error Occured [Server's JSON response might be invalid]!", Toast.LENGTH_LONG).show();
                     e.printStackTrace();
 
                 }
             }
             // When the response returned by REST has Http response code other than '200'
             public void onFailure(int statusCode, Throwable error,
                 String content) {
                 // Hide Progress Dialog
                
                 // When Http response code is '404'
                 if(statusCode == 404){
                     Toast.makeText(getActivity().getApplicationContext(), "Requested resource not found", Toast.LENGTH_LONG).show();
                 } 
                 // When Http response code is '500'
                 else if(statusCode == 500){
                     Toast.makeText(getActivity().getApplicationContext(), "Something went wrong at server end", Toast.LENGTH_LONG).show();
                 } 
                 // When Http response code other than 404, 500
                 else{
                     Toast.makeText(getActivity().getApplicationContext(), "Unexpected Error occcured! [Most common Error: Device might not be connected to Internet or remote server is not up and running]", Toast.LENGTH_LONG).show();
                 }
             }
			@Override
			public void onFailure(int statusCode, Header[] arg1, byte[] arg2,
					Throwable arg3) {
		         // Hide Progress Dialog 
		         //prgDialog.hide();
		         // When Http response code is '404'
		         if(statusCode == 404){
		             Toast.makeText(getActivity().getApplicationContext(), "Requested resource not found", Toast.LENGTH_LONG).show();
		         } 
		         // When Http response code is '500'
		         else if(statusCode == 500){
		             Toast.makeText(getActivity().getApplicationContext(), "Something went wrong at server end", Toast.LENGTH_LONG).show();
		         } 
		         // When Http response code other than 404, 500
		         else{
		             Toast.makeText(getActivity().getApplicationContext(), "Unexpected Error occcured! [Most common Error: Device might not be connected to Internet or remote server is not up and running]", Toast.LENGTH_LONG).show();
		         }
		         }
			@Override
			public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
				// TODO Auto-generated method stub
				Toast.makeText(getActivity().getApplicationContext(), "You are successfully registered!", Toast.LENGTH_LONG).show();
				
			}
         });
    }
 

 
    /**
     * Set degault values for Edit View controls
     */
    public void setDefaultValues(){
        nameET.setText("a");
        emailET.setText("b");
        
    }
 
}