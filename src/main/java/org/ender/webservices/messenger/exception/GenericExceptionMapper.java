package org.ender.webservices.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.ender.webservices.messenger.model.ErrorMessage;


//@Provider : registers in jersey
public class GenericExceptionMapper  implements ExceptionMapper<Throwable>
{

	@Override
	public Response toResponse(Throwable ex)
	{
		ErrorMessage errorMessage= new ErrorMessage(ex.getMessage(),500,"blahblah");
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(errorMessage) //sending content back
				.build();
	}
}

