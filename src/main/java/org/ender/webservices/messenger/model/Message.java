package org.ender.webservices.messenger.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Message {
	
	private long id;
	private String message;
	private Date time;
	private String author;
	private Map<Long, Comment> comments=new HashMap<>();
	private List<Link> links= new ArrayList<>();
	
	public Message(){
		
	}
	
	public Message(long id, String message, String author)
	{
		this.id=id;
		this.message=message;
		this.author=author;
		this.time=new Date();
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@XmlTransient //no commentdata tobe showedup  when message is retrieved
					//also works for JSON
	public Map<Long, Comment> getComments(){
		return comments;
	}
	public void setComments(Map<Long, Comment> comments){
		this.comments=comments;
	}
	
	public void addLink(String url, String rel)
	{
		Link link= new Link();
		link.setLink(url);
		link.setRel(rel);
		links.add(link);
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
}
