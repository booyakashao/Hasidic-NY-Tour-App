package com.ownits.android.skate.model;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import com.ownits.android.skate.be.Video;

public class VideoDAO extends AbstractDAO<Video> {

	public ArrayList<Video> getVideoList( String url, int size, int from ){		
		return getArrayList(url.replaceFirst( "\\$size", "" + size ).replaceFirst( "\\$from", "" + from ));
	}
	
	@Override
	protected Video parseJsonToObject(JSONObject jsonObject) throws JSONException {
		
		Video video = new Video();
		
		video.setId( jsonObject.has( "id" ) ? jsonObject.getLong("id") : 0l );
		video.setUserId( jsonObject.has( "user_id" ) ? jsonObject.getLong("user_id") : 0l );
		video.setSpotId( jsonObject.has( "spot_id" ) ? jsonObject.getLong("spot_id") : 0l );

		video.setTitle( jsonObject.has( "title" ) ? jsonObject.getString("title") : "" );
		video.setCategory( jsonObject.has( "category" ) ? jsonObject.getString("category") : "" );
		video.setFileName( jsonObject.has( "file_name" ) ? jsonObject.getString("file_name") : "" );
		video.setSnapshot( jsonObject.has( "snapshot" ) ? jsonObject.getString("snapshot") : "" );
		video.setUserName( jsonObject.has( "user_first_name" ) ? jsonObject.getString("user_first_name") : "" );
		video.setSpotName( jsonObject.has( "spotname" ) ? jsonObject.getString("spotname") : "" );
		video.setCompetitionCategory( jsonObject.has( "competition_category" ) ? jsonObject.getString("competition_category") : "" );
		video.setUserPicture( jsonObject.has( "user_picture" ) ? jsonObject.getString("user_picture") : "" );
		
		video.setVotes( jsonObject.has( "votes" ) ? jsonObject.getInt("votes") : 0 );
		
		//parse to date, not needed right now
		//video.setCreationTime( df.parse( jsonObject.getString("creation_time") ) );
		//video.setLastModified();
		
		System.out.println(video.toString());
		return video;
	}
	
}
