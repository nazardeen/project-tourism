package com.travel.app.server.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;


import com.travel.app.server.Entity.Comments;
import com.travel.app.server.Entity.Users;
import com.travel.app.server.Repository.UserRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.app.server.Entity.Posts;
import com.travel.app.server.Repository.PostRepo;



@Service
public class PostService {

	@Autowired
	PostRepo postRepo;
	
	@Autowired
	UserService userService;
	@Autowired
	DocumentCategorizerService documentCategorizerService;
	@Autowired
	LocationFinder locationFinder;

	public Posts submitMetaDataOfPost(Posts post) throws IOException {

		Date date=new Date();
		long time=date.getTime();
		Timestamp timeStamp=new Timestamp(time);

		post.setLikes(0);
		post.setTimeStamp(timeStamp);
		String Input = post.getCaption();
		System.out.println("Test Input");
		System.out.println(Input);
		String Sentiment = documentCategorizerService.getCategory(Input);
		post.setSentiment(Sentiment);
		System.out.println(Sentiment);
		String Places = locationFinder.findLocation(Input);
		post.setPlaces(Places);
		System.out.println(Places);


		return postRepo.save(post);
	}

	public Posts displayPostMetaData(String postid) {
		return postRepo.findByPostId(postid);
	}

	public ArrayList<Posts> retrivePostFromDB(){

		ArrayList<Posts> postList=postRepo.findAll();

		return postList;
	}

	public ArrayList<Posts> getAllPostsForDB(String userId){

		ArrayList<Posts> result=new ArrayList<Posts>();
		result=postRepo.findAllByUserId(userId);
		return result;


	}


	public ArrayList<Posts> getAllPostsForDBN(String userName){

		ArrayList<Posts> results;
		results=postRepo.findAllByUserName(userName);
		return results;

		}



//	public Posts findByUser(String userName) {
//		User user = (User) userRepo.findByuserName(userName);
//
//
//		return null;
//	}


	
}
