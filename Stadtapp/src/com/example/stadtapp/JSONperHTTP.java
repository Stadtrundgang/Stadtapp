package com.example.stadtapp;





import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.loopj.android.http.AsyncHttpClient;

import android.net.http.*;


public class JSONperHTTP {
	

	public String makeHttpPost(String url, String string2, Object object,
			String body) throws ClientProtocolException, IOException {
		// body ist String‐Parameter & enthält JSON‐Object als String
		DefaultHttpClient httpclient = new DefaultHttpClient();
		StringEntity entity = new StringEntity(body);
		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(entity);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content‐type", "application/json");
		HttpResponse httpResponse = httpclient.execute(httpPost);
		return null;
		
	}

}
