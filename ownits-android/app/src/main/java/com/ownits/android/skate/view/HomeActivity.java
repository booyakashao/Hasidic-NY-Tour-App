package com.ownits.android.skate.view;

import com.ownits.android.skate.R;
import com.ownits.android.skate.fragments.VideoListFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;

public class HomeActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		Toast toast = Toast.makeText(getApplicationContext(), "Loaded HomeActivity", Toast.LENGTH_SHORT);
		toast.show();
		
		FragmentManager fm = getSupportFragmentManager();
		
		if( savedInstanceState == null ) {
			VideoListFragment vlf = new VideoListFragment();
			fm.beginTransaction().add( R.id.main_fragment_container, vlf ).commit();
			toast = Toast.makeText(getApplicationContext(), "Loaded fragment", Toast.LENGTH_SHORT);
			toast.show();
		}
		
		setContentView(R.layout.activity_home);
	}
}