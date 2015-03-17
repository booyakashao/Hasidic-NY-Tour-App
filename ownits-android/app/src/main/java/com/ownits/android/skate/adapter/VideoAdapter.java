package com.ownits.android.skate.adapter;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ownits.android.skate.R;
import com.ownits.android.skate.be.Video;

public class VideoAdapter extends ArrayAdapter<Video> {

	private Context context;
	private boolean useList = true;
	
	public VideoAdapter( Context context, List<Video> videos ) {
		super( context, android.R.layout.simple_list_item_1, videos );
		this.context = context;
	}
	
	private class ViewHolder{
		TextView catTypeText;
		TextView userNameText;
	}
	
	/**
	 * @param position 
	 * @param convertView 
	 * @param parent 
	 * @return 
	 */
	public View getView( int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		Video item = (Video)getItem( position );
		View viewToUse = null;
		
		LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		
		if( convertView == null ) {
			if( useList ){
				viewToUse = mInflater.inflate( R.layout.explore_video_list_item, null );
			} else {
				//grid layout does not exist for now
				//viewToUser = mInflater.inflate( R.layout.example_grid_item, null );
			}
			
			holder = new ViewHolder();
			holder.catTypeText = (TextView)viewToUse.findViewById( R.id.category_type );
			holder.userNameText = (TextView)viewToUse.findViewById(R.id.user_name);
			viewToUse.setTag(holder);
		} else {
			viewToUse = convertView;
			holder = (ViewHolder) viewToUse.getTag();
		}
		
		holder.catTypeText.setText( item.getCompetitionCategory() );
		holder.userNameText.setText( item.getUserName() );
		return viewToUse;
	}
	
}
