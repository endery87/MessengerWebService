package org.ender.webservices.messenger.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.ender.webservices.messenger.model.Profile;
import org.ender.webservices.messenger.service.ProfileService;
import org.glassfish.jersey.server.ParamException.UriParamException;

@Consumes(MediaType.APPLICATION_JSON) //accepts JSON
@Produces(MediaType.APPLICATION_JSON)
@Path("/profiles")	
public class ProfileResource {
	
	private ProfileService pS=new ProfileService();
	
	@GET
	public List<Profile> getProfiles(){
		return pS.getAllProfiles();
	}
	
	@GET
	@Path("/{profileName}")	//variable link
	public Profile getProfile(@PathParam("profileName") String profileName){ //injecting path parameter, annotation d jersey does the conversion
		return pS.getProfile(profileName);
	}
	
	@POST
	public Response addProfile(Profile profile, @Context UriInfo uriInfo)throws URISyntaxException//automatic conversion

	{
		Profile respProfile=pS.addProfile(profile);
		URI uri=uriInfo.getAbsolutePathBuilder().path(String.valueOf(respProfile.getId())).build();
		return Response.created(uri)
			.entity(respProfile)
			.build();
	}
	
	@PUT
	@Path("/{profileName}")	//variable link
	public Profile updateProfile(@PathParam("profileName") String profileName,Profile profile)//automatic conversion
	{
		profile.setProfileName(profileName);
		System.out.println(profileName+"--"+profile);
		return pS.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")	//variable link
	public void deleteProfile(@PathParam("profileName") String profileName)//automatic conversion
	{
		 pS.removeProfile(profileName);
	}

}
