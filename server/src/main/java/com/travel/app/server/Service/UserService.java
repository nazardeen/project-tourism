package com.travel.app.server.Service;

import com.travel.app.server.Entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.app.server.Repository.UserRepo;

import java.util.ArrayList;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
	
	public Users submitMetaDataOfUser(Users user) {
		return userRepo.save(user);
	}
	
	public Users displayUserMetaData(String userid) {
		return userRepo.findByUserId(userid);
	}

	public ArrayList<Users> retrieveAllUserDetails(){
		return userRepo.findAll();
	}

////	public Users displayUserByName(String userName) {
////		return userRepo.findByuserName(userName);
//	}


}
