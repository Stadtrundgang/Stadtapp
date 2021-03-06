package com.example.stadtapp.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;
import android.util.Base64;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

public class CouchDBActivity extends Activity{
    /** Called when the activity is first created. */
	private static String hostUrl = "http://141.28.100.212:5984/_utils/";
	private static String username = "cs160";
	private static String password = "306soda";

	public Boolean createDatabase(String dbName)
	{
		return putJSONObject(this.hostUrl, dbName);
	}
	
	public JSONObject getJSONObject(String hosturl,String databaseName) {
		try {
	        HttpGet httpGetRequest = new HttpGet(hostUrl + databaseName);
	        JSONObject jsonResult = sendCouchRequest(httpGetRequest);
	        Log.d("Got it:", jsonResult.toString());
	        System.out.println("kneipe gefunden");
	        return jsonResult;
	    } 
	    catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
		
	}
	
	private Boolean putJSONObject(String hosturl, String databaseName)
	{
		 try {
		        HttpPut httpPutRequest = new HttpPut(hostUrl + databaseName);
		        

		        
			    httpPutRequest.setHeader("Accept", "application/json");
			    httpPutRequest.setHeader("Content-type", "application/json");
			    //httpPutRequest.setHeader("Authorization","Basic " + (Base64.encodeToString("cs160:306soda".getBytes(), Base64.DEFAULT)).trim());
			    
		        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
		        nameValuePairs.add(new BasicNameValuePair("key10", "value10"));
		        nameValuePairs.add(new BasicNameValuePair("key11", "value11"));
		        httpPutRequest.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		        JSONObject jsonResult = sendCouchRequest(httpPutRequest);

		        return jsonResult.getBoolean("ok");
		    } 
		    catch (Exception e) {
		        e.printStackTrace();
		    }
		    return false;
	}
	
	private static JSONObject sendCouchRequest(HttpUriRequest request) {
	    try {
	        HttpResponse httpResponse = (HttpResponse) new DefaultHttpClient().execute(request);
	        HttpEntity entity = httpResponse.getEntity();
	        if (entity != null) {
	            InputStream instream = entity.getContent();
	            String resultString = convertStreamToString(instream);
	            instream.close();
	            JSONObject jsonResult = new JSONObject(resultString);

	            return jsonResult;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	
	 private static String convertStreamToString(InputStream is) {
	        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	        StringBuilder sb = new StringBuilder();
	 
	        String line = null;
	        try {
	            while ((line = reader.readLine()) != null) {
	            	sb.append(line + "\n");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                is.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        return sb.toString();
	    }
}