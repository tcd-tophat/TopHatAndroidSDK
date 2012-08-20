package org.tophat.android.exceptions;

public class Unimplemented extends HttpException {

	private static String ERROR_MESSAGE = "The given resource/method is unimplemented.";
	
	public Unimplemented()
	{
		super(ERROR_MESSAGE, 501);
	}
	
	public Unimplemented(String json)
	{
		super(ERROR_MESSAGE, json);
	}
}
