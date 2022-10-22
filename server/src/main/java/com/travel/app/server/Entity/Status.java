package com.travel.app.server.Entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="Status")
public class Status {

	@Id
	@GeneratedValue
	private int id;
	
	private String statusId;
	private String userId;
	private String userName;

	private String caption;

	private String image;

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Status(int id, String statusId, String userId, String caption, String image) {
		super();
		this.id = id;
		this.statusId = statusId;
		this.userId = userId;
		this.caption = caption;
		this.image = image;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatusId() {
		return statusId;
	}
	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getImage() {return image;}
	public void setImage(String image) {
		this.image = image;
	}	
}
