package com.ownits.android.skate.be;

import java.util.Date;

public class Video {
	
	private long id;
	private long userId;
	private long spotId;

	private String title;
	private String category;
	private String fileName;
	private String snapshot;
	private String userName;
	private String spotName;
	private String competitionCategory;
	private String userPicture;
	
	private int votes;
	
	private Date creationTime;
	private Date lastModified;
	
	public Video(){}
	
	public Video( long id ){
		this.id = id;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getSpotId() {
		return spotId;
	}
	public void setSpotId( long spotId ) {
		this.spotId = spotId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getSnapshot() {
		return snapshot;
	}
	public void setSnapshot(String snapshot) {
		this.snapshot = snapshot;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSpotName() {
		return spotName;
	}
	public void setSpotName(String spotName) {
		this.spotName = spotName;
	}
	public String getCompetitionCategory() {
		return competitionCategory;
	}
	public void setCompetitionCategory(String competitionCategory) {
		this.competitionCategory = competitionCategory;
	}
	public String getUserPicture() {
		return userPicture;
	}
	public void setUserPicture(String userPicture) {
		this.userPicture = userPicture;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public Date getLastModified() {
		return lastModified;
	}
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

}
