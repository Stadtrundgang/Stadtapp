package com.example.stadtapp;





import ch.boye.httpclientandroidlib.HttpResponse;
import ch.boye.httpclientandroidlib.client.methods.HttpPost;
import ch.boye.httpclientandroidlib.entity.StringEntity;
import android.net.http.*;


public class JSONperHTTP {
	

	public String makeHttpPost(String url, String string2, Object object,
			String body) {
	
	// body ist String‐Parameter & enthält JSON‐Object als String
	StringEntity entity = new StringEntity(body);
	HttpPost httpPost = new HttpPost(url);
	httpPost.setEntity(entity);
	httpPost.setHeader("Accept", "application/json");
	httpPost.setHeader("Content‐type", "application/json");
	HttpResponse httpResponse = httpclient.execute(httpPost);

		
		
		return null;
	}

}
