package com.travel.app.server.Repository;

import java.util.ArrayList;
import java.util.UUID;

import com.travel.app.server.Entity.Comments;
import com.travel.app.server.Entity.Posts;
import com.travel.app.server.Entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends CrudRepository<Posts, UUID> {

	Posts save(Posts posts);
	ArrayList<Posts> findAll();

	Posts findByPostId(String postId);

	ArrayList<Posts> findAllByUserId(String userId);

	ArrayList<Posts> findAllByUserName(String userName);



}
