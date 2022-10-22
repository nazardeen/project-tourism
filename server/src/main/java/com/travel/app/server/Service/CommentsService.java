package com.travel.app.server.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.travel.app.server.Entity.Comments;
import com.travel.app.server.Entity.Posts;
import com.travel.app.server.Repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentsService {
	
	@Autowired
	CommentRepo commentRepo;
	
	@Autowired
	UserService userService;
	
	public Comments submitCommentToDB(Comments comment)

	{
		Date date=new Date();
		long time=date.getTime();
		Timestamp timeStamp=new Timestamp(time);

		comment.setTimeStamp(timeStamp);




		return commentRepo.save(comment);
	}
	
	public ArrayList<Comments> getAllCommentsForDB(String postId){
		
		ArrayList<Comments> result=new ArrayList<Comments>();
		result=commentRepo.findAllByPostId((postId));
		return result;
		
	}

	public ArrayList<Comments> getAllCommentsForDBN(String userId){

		ArrayList<Comments> result=new ArrayList<Comments>();
		result=commentRepo.findAllByUserId(userId);
		return result;
	}

	public ArrayList<Comments> getAllCommentsForDBNN(String userName) {

		ArrayList<Comments> results = new ArrayList<Comments>();
		results = commentRepo.findAllByUserName(userName);
		return results;
	}

//	public ArrayList<Comments> getAllCommentsForDB(String postId){
//
//		ArrayList<Comments> commentList=commentRepo.findAllByPostId(postId);
//
//		for(int i=0;i<commentList.size();i++) {
//			Comments commentItem=commentList.get(i);
//			commentItem.setUserName(userService.displayUserMetaData(commentItem.getUserId()).getUserName());
//		}
//
//		return commentList;
//
//	}

}
