package org.ender.webservices.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.ender.webservices.messenger.database.DatabaseClass;
import org.ender.webservices.messenger.model.Comment;
import org.ender.webservices.messenger.model.ErrorMessage;
import org.ender.webservices.messenger.model.Message;

public class CommentService {
	
	private Map<Long, Message> messages =DatabaseClass.getMessages();
	
	public CommentService(){
		//comments.put(1L, new Comment(1,"mes1", "enro"));
		//comments.put(2L, new Comment(3,"mes2", "enro"));
	}
	
	/*
	public List<Comment> getAllComments(){
		return new ArrayList<Comment>(comments.values());
	}
	
	public List<Comment> getAllCommentsForYear(int year){
		List<Comment> commentsForYear = new ArrayList<>();
		Calendar cal= Calendar.getInstance();
		for(Comment comment: comments.values()){
			cal.setTime(comment.getTime());
			if(cal.get(Calendar.YEAR)==year)
				commentsForYear.add(comment);
		}
		return commentsForYear;
		
	}
	
	public List<Comment> getAllCommentsPaginated(int start, int size){
		ArrayList<Comment> list=new ArrayList<Comment>(comments.values());
		if(start+size>list.size())
			return new ArrayList<Comment>();
		return  list.subList(start,start+size);
		
	}
	
	public Comment addComment(Comment comment)
	{
		comment.setId(comments.size()+1);
		comments.put(comment.getId(),comment);
		return comment;	//return comment with Id added
	}
	
	public Comment updateComment(Comment comment)
	{
		System.out.println(comment.getId()+"xxx"+comment);
		if(comment.getId()<=0)
			return null;
		comments.put(comment.getId(),comment);
		System.out.println(comments);
		return comment; //return comment itself
	}
	
	public Comment removeComment(long id){
		return comments.remove(id);//return the removed comment instanced
	}
	*/
	public Comment getComment(long cId, long mId)
	{
		ErrorMessage errorMessage= new ErrorMessage("NotFound",404,"mywebappexception");
		Response response=Response.status(Status.NOT_FOUND)
				.entity(errorMessage) //sending content back
				.build();
		Message  message=messages.get(mId);
		if(message==null)
		{
			throw new WebApplicationException(response);
		}
		Map<Long, Comment> comments=messages.get(mId).getComments();	
		Comment comment=comments.get(cId);
		if(comment==null)
		{
			throw new NotFoundException(response);
		}
		return comments.get(cId);
	}
	

}
