package co.com.techandsolve.cargueperezoso.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class AppExceptionMapper implements ExceptionMapper<Exception>{

	@Override
	public Response toResponse(Exception excepcion) {
		
		return Response.status(Status.INTERNAL_SERVER_ERROR).header("ERR_DESC", excepcion.getMessage()).build();
	}
}
