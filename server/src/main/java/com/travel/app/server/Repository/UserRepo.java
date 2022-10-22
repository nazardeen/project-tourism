package com.travel.app.server.Repository;

import com.travel.app.server.Entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepo extends CrudRepository<Users, Integer>{

	Users save(Users user);
	Users findByUserId(String userId);

	ArrayList<Users> findAll();

//	Users findByuserName(String userName);
}
