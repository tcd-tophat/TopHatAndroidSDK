package org.tophat.android.networking;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.ParseException;
import org.tophat.android.Constants;
import org.tophat.android.exceptions.BadResponse;
import org.tophat.android.exceptions.HttpException;
import org.tophat.android.mapping.ApiToken;
import org.tophat.android.mapping.GameList;
import org.tophat.android.mapping.Mapping;

public class ApiCommunicator 
{

	/**
	 * The APIStream is the lower level HTTP Communicator with the remote server
	 */
	protected TopHatHttpClient http;
	
	protected JsonParser json;

	private ApiToken apiToken;
	
	private Constants c;
	
	/**
	 * 
	 * @param a
	 */
	public ApiCommunicator(Constants c)
	{	
		this.c = c;
		
		this.http = new TopHatHttpClient(this);
		
		this.json = new JsonParser();
		
		//Prepares connection
		this.http.connect();
	}

	/**
	 * 
	 * @param uri
	 * @return
	 * @throws HttpException
	 */
	public Map<String, Object> get(String uri) throws HttpException
	{
		String input;
		
		if(this.getApitoken() != null )
		{
			input = http.get(uri+"?apitoken="+this.getApitoken().getApitoken());
		}
		else
		{
			input = http.get(uri);
		}
		
		if( input == null || input.equals("") )
		{
			throw new BadResponse();
		}
		
		try
		{
			return json.getObjects(input);
		}
		catch(ParseException pe)
		{
			throw new BadResponse();
		}
	}

	public Map<String, Object> post(String uri, Map<String, Object> map) throws HttpException
	{
		return this.post(uri, json.toJson(map));
	}

	/**
	 * 
	 * @param uri
	 * @return
	 * @throws HttpException
	 */
	private Map<String, Object> post(String uri, String data) throws HttpException
	{
		String input;
		
		if(this.getApitoken() != null )
		{
			input = http.post(uri+"?apitoken="+this.getApitoken().getApitoken(), data);
		}
		else
		{
			input = http.post(uri, data);
		}
		
		if( input == null || input.equals("") )
		{
			throw new BadResponse();
		}
		
		try
		{
			return json.getObjects(input);
		}
		catch(ParseException pe)
		{
			throw new BadResponse();
		}
	}
	
	/**
	 * 
	 * @param uri
	 * @return
	 * @throws HttpException
	 */
	public Map<String, Object> put(String uri, Map<String, Object> map) throws HttpException
	{
		String input;
		
		if(this.getApitoken() != null )
		{
			input = http.put(uri+"?apitoken="+this.getApitoken().getApitoken(), json.toJson(map));
		}
		else
		{
			input = http.put(uri, json.toJson(map));
		}
		
		if( input == null || input.equals("") )
		{
			throw new BadResponse();
		}
		
		try
		{
			return json.getObjects(input);
		}
		catch(ParseException pe)
		{
			throw new BadResponse();
		}
	}
	
	/**
	 * 
	 * @param uri
	 * @return
	 * @throws HttpException
	 */
	public Map<String, Object> delete(String uri) throws HttpException
	{
		String input;
		
		if(this.getApitoken() != null )
		{
			input = http.delete(uri+"?apitoken="+this.getApitoken().getApitoken());
		}
		else
		{
			input = http.delete(uri);
		}
		
		if( input == null || input.equals("") )
		{
			throw new BadResponse();
		}
		
		try
		{
			return json.getObjects(input);
		}
		catch(ParseException pe)
		{
			throw new BadResponse();
		}
	}

	public void setApitoken(ApiToken apiToken) {
		this.apiToken = apiToken;
	}
	
	public ApiToken getApitoken()
	{
		return this.apiToken;
	}

	/**
	 * @return the c
	 */
	public Constants getConstants() {
		return c;
	}

	/**
	 * @param c the c to set
	 */
	public void setConstants(Constants c) {
		this.c = c;
	}
}
