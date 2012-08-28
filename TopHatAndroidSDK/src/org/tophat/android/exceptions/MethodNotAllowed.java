package org.tophat.android.exceptions;

public class MethodNotAllowed extends HttpException {

	private static String ERROR_MESSAGE = "The method used on this resource is not allowed. eg. creating may be not allowed.";
	
	public MethodNotAllowed()
	{
		super(ERROR_MESSAGE, 405);
	}
	
	public MethodNotAllowed(String json)
	{
		super(ERROR_MESSAGE, json);
	}
}
