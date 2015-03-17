package com.ownits.android.skate.be;

import java.util.Date;

public class User {

	private long id;
	
	private String firstName;
	private String lastName;
	private String email;
	private String category;
	
	private int totalVideos;
	private int spotsOwned;
	
	private Date createdDate;
	private Date lastModified;
	
	public User() { }
	
	public User( long id ){
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getTotalVideos() {
		return totalVideos;
	}

	public void setTotalVideos(int totalVideos) {
		this.totalVideos = totalVideos;
	}

	public int getSpotsOwned() {
		return spotsOwned;
	}

	public void setSpotsOwned(int spotsOwned) {
		this.spotsOwned = spotsOwned;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	
}
