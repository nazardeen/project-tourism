package com.travel.app.server.Service;

import java.util.ArrayList;

import com.travel.app.server.Entity.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.app.server.Repository.StatusRepo;

@Service
public class StatusService {

	@Autowired
	StatusRepo statusRepo;
	
	@Autowired
	UserService userService;
	
	public Status submitDataIntoDB(Status status) {
		return statusRepo.save(status);
	}
	
	public ArrayList<Status> retrieveStatus(){
		
		ArrayList<Status> statusList=statusRepo.findAll();
		
		return statusList;
	}
}
