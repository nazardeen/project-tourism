package com.travel.app.server.Entity;

import com.sun.istack.NotNull;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="Posts")
public class Posts {

	@Id
	@GeneratedValue
	private  int id;

	@NotNull
	private String postId;

	private String userId;
	private String userName;
	private String postPath;
	private Timestamp timeStamp;

	private String postImage;

	private String caption;
	private int likes;

	private String places;


	private String sentiment;

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}


	public Posts() {
		super();
	}
	public Posts(int id, String postId, String userId, String postPath, Timestamp timeStamp, int likeCount, String postimage, String discription, String places, String sentiment ) {
		super();
		this.id = id;
		this.postId = postId;
		this.userId = userId;
		this.postPath = postPath;
		this.timeStamp = timeStamp;
		this.postImage = postImage;
		this.caption = caption;
		this.likes = likeCount;
		this.places = places;
		this.sentiment = sentiment;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPostId() {
		return postId;
	}
	public void setpostId(String postId) {
		this.postId = postId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPostPath() {
		return postPath;
	}
	public void setPostPath(String postPath) {
		this.postPath = postPath;
	}
	public Timestamp getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getPostImage() {
		return postImage;
	}

	public void setPostImage( String postImage) {
		this.postImage = postImage;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption( String caption) {
		this.caption = caption;
	}

	public int getLikes() {
		return likes;
	}
	public void setLikes(int likeCount) {
		this.likes = likeCount;
	}

	public String getPlaces() {
		return places;
	}

	public void setPlaces(String places) {
		this.places = places;
	}

	public String getSentiment() {
		return sentiment;
	}

	public void setSentiment(String sentiment) {
		this.sentiment = sentiment;
	}

	
}
