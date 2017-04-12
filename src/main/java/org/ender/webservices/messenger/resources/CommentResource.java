package org.ender.webservices.messenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.ender.webservices.messenger.model.Comment;
import org.ender.webservices.messenger.service.CommentService;
import org.ender.webservices.messenger.service.MessageService;


@Path("/")
public class CommentResource {
	
	CommentService cS= new CommentService();

	
	@GET
	public String test(){
		return "new sub resource";
	}
	
	@GET
	@Path("/{commentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Comment getComment(@PathParam("commentId") long cId, @PathParam("messageId") long mId){
		return cS.getComment(cId, mId);
	}
	
}
