package org.tophat.android.model;

import java.util.HashMap;
import java.util.Map;

import org.tophat.android.exceptions.HttpException;
import org.tophat.android.mapping.ApiToken;
import org.tophat.android.mapping.Player;
import org.tophat.android.networking.ApiCommunicator;

public class ApiTokenMapper extends Mapper 
{
	public ApiTokenMapper(ApiCommunicator apic)
	{
		super(apic);
	}
	
	/**
	 * This method returns a valid Api
	 * @param username
	 * @param password
	 * @return
	 * @throws HttpException
	 */
	public ApiToken getApiToken(String username, String password) throws HttpException
	{
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("email", username);
		map.put("password", password);
		
		return new ApiToken(this.getApiCommunicator().post(ApiToken.API_URI+"/", (Map)map));
	}
	
	/**
	 * This method posts an empty JSON data packet to the API Url, which returns a valid Anonymous API token 
	 * @return
	 * @throws HttpException
	 * @throws Unimplemented This method may throw an unimplemented 
	 */
	public ApiToken getAnonymousToken() throws HttpException
	{
		return new ApiToken(this.getApiCommunicator().post(ApiToken.API_URI+"/", (Map)new HashMap<String, Object>()));
	}
	
	@Override
	protected ApiToken creator(Map<String, Object> data)
	{
		return new ApiToken(data);
	}
}
