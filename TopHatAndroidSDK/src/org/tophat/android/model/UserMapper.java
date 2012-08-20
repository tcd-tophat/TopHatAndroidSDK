package org.tophat.android.model;

import java.util.Map;

import org.tophat.android.mapping.User;
import org.tophat.android.networking.ApiCommunicator;

public class UserMapper extends Mapper 
{

	public UserMapper(ApiCommunicator apic) 
	{
		super(apic);
	}
	
	@Override
	protected User creator(Map<String, Object> data)
	{
		return new User(data);
	}

}
