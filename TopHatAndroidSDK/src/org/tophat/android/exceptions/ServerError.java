package org.tophat.android.exceptions;

public class ServerError extends HttpException {

	private static String ERROR_MESSAGE = "The server has encountered an internal error.";
	
	public ServerError()
	{
		super(ERROR_MESSAGE, 500);
	}
	
	public ServerError(String json)
	{
		super(ERROR_MESSAGE, json);
	}
}
