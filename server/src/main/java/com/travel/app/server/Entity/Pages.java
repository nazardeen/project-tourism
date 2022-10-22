package com.travel.app.server.Entity;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity(name="Pages")
public class Pages {

	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	private String pageId;
	private String pageName;
	private String name;
	private String pageImage;
	
	public Pages() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pages(int id, String pageId, String pageName, String name, String profileImage) {
		super();
		this.id = id;
		this.pageId = pageId;
		this.pageName = pageName;
		this.name = name;
		this.pageImage = pageImage;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPageId() {
		return pageId;
	}
	public void setPageId(String pageId) {
		this.pageId = pageId;
	}
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPageImage() {
		return pageImage;
	}
	public void setPageImage(String profileImage) {
		this.pageImage = profileImage;
	}
}
