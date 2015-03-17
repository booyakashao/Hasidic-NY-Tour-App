package com.ownits.android.skate.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.ownits.android.skate.R;


public class LoginActivity extends Activity {

	public static final String PARAM_TOKEN = "access_token";
	public static final String RESULT_KEY = "com.ownits.skate.result_key";
	
	public static final String OAUTH_URL = "http://ws.ownits.com/oauth/authorize";

	public static final String OAUTH_CLIENT_ID = "ownits-skate-ios";
	
	private Intent mIntent;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mIntent = new Intent( this, HomeActivity.class );
		WebView webView = (WebView)findViewById(R.id.webview);
		webView.setWebViewClient( new WebViewClient()
		{

			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url)
			{
				System.out.println("redirect to: " + url);
				Toast.makeText(getApplicationContext(), "Redirect!" + url,
	                      Toast.LENGTH_SHORT).show();
                /*
				if( url.contains( getResources().getString( R.string.ownits_callback ) ) )
				{
					Uri uri = Uri.parse( url );
					String oauthVerifier = uri.getQueryParameter( PARAM_TOKEN );
					mIntent.putExtra( PARAM_TOKEN, oauthVerifier );
					mIntent.putExtra( RESULT_KEY, RESULT_OK );
					//finish();
                    Toast.makeText(getApplicationContext(), "localhost redirect: " + url, Toast.LENGTH_LONG).show();
					System.out.println("callback caught!: " + url);
					startActivity(mIntent);
					finish();
					return true;
				}
				*/
				return false;
			}
		});
		System.out.println("launch with url: " + getResources().getString(R.string.ownits_login));
		webView.loadUrl(getResources().getString(R.string.ownits_login));
    }

}
