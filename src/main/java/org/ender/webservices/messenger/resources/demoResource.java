package org.ender.webservices.messenger.resources;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;


@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class demoResource {
	
	@GET
	@Path("annotations")
	public String getParamsUsingAnnotations(@MatrixParam("param") String matrixparam,
											@HeaderParam("customHeaderVal") String header,
											@CookieParam("name") String cookie){
		return matrixparam+"Test"+header;
	}
	
	@GET
	@Path("context")
	public String getParamsUsingContext(@Context UriInfo myUri, @Context HttpHeaders headers){
	//to get all params at ones
		return headers.getCookies().toString();
	}
	
	

}
