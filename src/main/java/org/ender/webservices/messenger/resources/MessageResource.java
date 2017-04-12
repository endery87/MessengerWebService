package org.ender.webservices.messenger.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.ender.webservices.messenger.service.MessageService;
import org.ender.webservices.messenger.model.Message;
import org.ender.webservices.messenger.resources.beans.MessageFilterBean;
import org.ender.webservices.messenger.resources.CommentResource;



@Path("/messages")
public class MessageResource{
	
	MessageService mS= new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(@BeanParam MessageFilterBean filterBean){
		if(filterBean.getYear()>=1)
			return mS.getAllMessagesForYear(filterBean.getYear());
		if(filterBean.getStart()>=0 && filterBean.getSize()>0)
			return mS.getAllMessagesPaginated(filterBean.getStart(),filterBean.getSize());
		return mS.getAllMessages();

	
	}
	
	@GET
	@Path("/{messageId}")	//variable link
	@Produces(MediaType.APPLICATION_JSON)//automatic JSON conversion
	public Message getMessage(@PathParam("messageId") long id, @Context UriInfo uriInfo){ //injecting path parameter, annotation d jersey does the conversion
		Message message= mS.getMessage(id);
		String uri = getUriForSelf(uriInfo, message);		
		message.addLink(uri,"self");
		System.out.println("--"+uri);
		return message;
		
	}

	private String getUriForSelf(UriInfo uriInfo, Message message) {
		String uri=uriInfo.getBaseUriBuilder()
			.path(MessageResource.class)
			.path(Long.toString(message.getId()))
			.build()
			.toString();
		return uri;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON) //accepts JSON
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMessage(Message message)//automatic conversion
	{
		Message respMessage=mS.addMessage(message);
		return Response.status(Status.CREATED)
			.entity(respMessage)
			.build();
		//return mS.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")	//variable link
	@Consumes(MediaType.APPLICATION_JSON) //accepts JSON
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") long id,Message message)//automatic conversion
	{
		message.setId(id);
		System.out.println(id+"--"+message);
		return mS.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")	//variable link
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("messageId") long id)//automatic conversion
	{
		 mS.removeMessage(id);
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource(){
		return new CommentResource();
		
	}
}

