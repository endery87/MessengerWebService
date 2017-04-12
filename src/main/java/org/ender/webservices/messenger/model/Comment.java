package org.ender.webservices.messenger.model;

import java.util.Date;

public class Comment {
	
	
	private long id;
	private String comment;
	private Date time;
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	private String author;
	
	public Comment(){
		
	}

	public Comment(long id, String comment, String author){
		this.id=id;
		this.comment=comment;
		this.author=author;
		this.time=new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
