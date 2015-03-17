package com.ownits.android.skate.fragments;

import java.util.ArrayList;
import java.util.List;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.Toast;

import com.ownits.android.skate.R;
import com.ownits.android.skate.adapter.VideoAdapter;
import com.ownits.android.skate.be.Video;
import com.ownits.android.skate.model.VideoDAO;

public class VideoListFragment extends ListFragment implements AdapterView.OnItemClickListener {

	private static final int VIDEOS_PER_REQUEST = 10;

	private static int videoStartingPoint = 0;
	
	private List<Video> videoList;
	private ArrayAdapter<Video> mAdapter;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
		videoList = new ArrayList<Video>();
		mAdapter = new VideoAdapter( getActivity(), videoList );

		/*
		//sample videos to get list up before attempting to use rest data
		for( int i = 0; i < 50; i ++ )
		{
			Video v = new Video();
			v.setTitle("Video #" + i );
			videoList.add( v );
		}*/
		
		setListAdapter( mAdapter );
		RetrieveVideoList videoTask = new RetrieveVideoList();
		videoTask.execute();
	}
	
	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		//TODO save state of list/fragment when switching views/fragments
		super.onSaveInstanceState(savedInstanceState);
	}
	
	
	@Override
	public void onItemClick( AdapterView parent, View view, int position, long id ){
		Toast.makeText( getActivity(), position, Toast.LENGTH_SHORT ).show();
	}
	
	private class RetrieveVideoList extends AsyncTask<Void, String, ArrayList<Video>> {

		@Override
		protected ArrayList<Video> doInBackground(Void... params) {
			String url = getResources().getString( R.string.video_search_endpoint );
			return new VideoDAO().getVideoList( url, VIDEOS_PER_REQUEST, videoStartingPoint);
		}

		@Override
		protected void onPostExecute(ArrayList<Video> result){
			super.onPostExecute(result);
			
			if( result != null) {
				/**TODO: handle null case**/
				for( Video v : result ) {
					//videoList.add( v );
					mAdapter.add( v );
				}
			}
			
			videoStartingPoint += VIDEOS_PER_REQUEST;
		}
	}
}
