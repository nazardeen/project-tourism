package com.travel.app.server.Repository;

import java.util.ArrayList;

import com.travel.app.server.Entity.Comments;
import com.travel.app.server.Entity.Posts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo extends CrudRepository<Comments, Integer> {
	
	Comments save(Comments comment);

	ArrayList<Comments> findAll();


	ArrayList<Comments> findAllByPostId(String postId);

	ArrayList<Comments> findAllByUserId(String userId);

	ArrayList<Comments> findAllByUserName(String userName);
}
