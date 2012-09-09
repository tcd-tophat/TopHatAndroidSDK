package org.tophat.android.networking;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import org.tophat.android.exceptions.Forbidden;
import org.tophat.android.exceptions.HttpException;
import org.tophat.android.exceptions.MethodNotAllowed;
import org.tophat.android.exceptions.NotFound;
import org.tophat.android.exceptions.ServerError;
import org.tophat.android.exceptions.Unauthorised;
import org.tophat.android.exceptions.Unimplemented;

public class ResponseProcessor {

	public ResponseProcessor()
	{}
	
	public String process(HttpResponse response) throws HttpException, ParseException, IOException
	{
		HttpEntity entity = response.getEntity();
		
		if( response.getStatusLine().getStatusCode() < 300 )
		{
			return entityToString(entity);
		}
		else if ( response.getStatusLine().getStatusCode() == 401 )
		{
			throw new Unauthorised(entityToString(entity));
		}
		else if ( response.getStatusLine().getStatusCode() == 403 )
		{
			throw new Forbidden(entityToString(entity));
		}
		else if ( response.getStatusLine().getStatusCode() == 404 )
		{
			throw new NotFound(entityToString(entity));
		}
		else if ( response.getStatusLine().getStatusCode() == 405 )
		{
			throw new MethodNotAllowed(entityToString(entity));
		}
		else if ( response.getStatusLine().getStatusCode() == 500 )
		{
			throw new ServerError(entityToString(entity));
		}
		else if ( response.getStatusLine().getStatusCode() == 501 )
		{
			throw new Unimplemented(entityToString(entity));
		}		
		else
		{
			throw new HttpException("HTTP Error "+response.getStatusLine().getStatusCode(), entityToString(entity));
		}
	}
	
	private String entityToString(HttpEntity entity) throws ParseException, IOException
	{
		return EntityUtils.toString(entity).replaceAll("\\p{Cntrl}", "");
	}
}
