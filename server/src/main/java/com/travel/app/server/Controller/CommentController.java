package com.travel.app.server.Controller;

import java.util.ArrayList;

import com.travel.app.server.Entity.Comments;
import com.travel.app.server.Entity.Posts;
import com.travel.app.server.Service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/comments")
public class CommentController {

	@Autowired
	CommentsService commentsService;

	@PostMapping("")
	private Comments submitComment(@RequestBody Comments comment) {
		return commentsService.submitCommentToDB(comment);
	}

	@GetMapping("/{postId}")
	private ArrayList<Comments> getCommentsForPost(@PathVariable("postId") String postId) {
		return commentsService.getAllCommentsForDB(postId);
	}

	@GetMapping("byuser/{userId}")
	private ArrayList<Comments> getCommentsForUser(@PathVariable("userId") String userId) {
		return commentsService.getAllCommentsForDBN(userId);

	}

	@GetMapping("byusername/{userName}")
	private ArrayList<Comments> getCommentsForUserName(@PathVariable("userName") String userName) {
		return commentsService.getAllCommentsForDBNN(userName);

	}
}
