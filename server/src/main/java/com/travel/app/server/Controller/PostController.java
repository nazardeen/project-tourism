package com.travel.app.server.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import com.travel.app.server.Entity.Comments;
import com.travel.app.server.Entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.travel.app.server.Entity.Posts;
import com.travel.app.server.Service.PostService;

@CrossOrigin
@RestController
@RequestMapping("/posts")
public class PostController {

	@Autowired
	PostService postService;

	@PostMapping("")
	private Posts submitPost(@RequestBody Posts posts) throws IOException {
		return postService.submitMetaDataOfPost(posts);


	}

	@GetMapping("/getposts")
	public ArrayList<Posts> retrieveAllPost(){
		return postService.retrivePostFromDB();
	}



	@GetMapping("/{postId}")
	private Posts getPostDetails(@PathVariable("postId") String postId) {
		return postService.displayPostMetaData(postId);
	}




	@GetMapping("byuser/{userId}")
	private ArrayList<Posts> getPostsForUser(@PathVariable("userId") String userId){
		return postService.getAllPostsForDB(userId);
	}

	@GetMapping("byusername/{userName}")
	private ArrayList<Posts> getPostsForUserName(@PathVariable("userName") String userName){
		return postService.getAllPostsForDBN(userName);
	}


}
