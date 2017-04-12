package org.ender.webservices.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.ender.webservices.messenger.model.ErrorMessage;

@Provider //registers in JAX-RS
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>
{

	@Override
	public Response toResponse(DataNotFoundException ex)
	{
		ErrorMessage errorMessage= new ErrorMessage(ex.getMessage(),404,"blahblah");
		return Response.status(Status.NOT_FOUND)
				.entity(errorMessage) //sending content back
				.build();
	}
}
