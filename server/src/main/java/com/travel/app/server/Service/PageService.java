package com.travel.app.server.Service;

import com.travel.app.server.Entity.Pages;
import com.travel.app.server.Repository.PageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PageService {

	@Autowired
	PageRepo pageRepo;
	
	public Pages submitMetaDataOfPage(Pages page) {
		return pageRepo.save(page);
	}
	
	public Pages displayPageMetaData(String pageid) {
		return pageRepo.findByPageId(pageid);
	}

	public ArrayList<Pages> retrieveAllPageDetails(){
		return pageRepo.findAll();
	}
}
