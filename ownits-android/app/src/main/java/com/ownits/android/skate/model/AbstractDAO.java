package com.ownits.android.skate.model;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;

public abstract class AbstractDAO<Model> {

	protected ArrayList<Model> getArrayList( String url )
	{
		ArrayList<Model> result = new ArrayList<Model>();
		
		try {
			URL u = new URL(url);
			
			HttpURLConnection conn = (HttpURLConnection) u.openConnection();
			conn.setRequestMethod("GET");
			
			System.out.println("endpointURL: " + url );
			
			conn.connect();
			InputStream is = conn.getInputStream();
			
			byte[] b = new byte[1024];
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			
			while( is.read(b) != -1 ){
				baos.write(b);
			}
			
			System.out.println("bytestream length: " + baos.size() );
			String JSONResp = new String(baos.toByteArray());
			
			System.out.println( "json length: " + JSONResp.length() );
			JSONArray arr = new JSONObject(JSONResp).getJSONObject("hits").getJSONArray("hits");
			
			for( int i = 0; i < arr.length(); i++ )
			{
				result.add( parseJsonToObject( arr.getJSONObject(i).getJSONObject("_source")) );
			}
			return result;
		}
		catch( Throwable t ){
			t.printStackTrace();
		}
		return null;
	}
	
	protected abstract Model parseJsonToObject( JSONObject jsonObject ) throws JSONException;
}
