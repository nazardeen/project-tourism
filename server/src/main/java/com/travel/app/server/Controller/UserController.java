package com.travel.app.server.Controller;


import com.travel.app.server.Entity.Comments;
import com.travel.app.server.Entity.Posts;
import com.travel.app.server.Entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.app.server.Service.UserService;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;

	@PostMapping("")
	private Users submitUser(@RequestBody Users users) {
		return userService.submitMetaDataOfUser(users);
	}

	@GetMapping("/getAllUsers")
	public ArrayList<Users> getAllUserDetails() {
		return userService.retrieveAllUserDetails();
	}
	
	@GetMapping("/{userid}")
	private Users getUserDetails(@PathVariable("userid") String userId) {
		return userService.displayUserMetaData(userId);
	}


}
