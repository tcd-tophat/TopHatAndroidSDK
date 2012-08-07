package org.tophat.android.model;

import java.util.Map;

import org.tophat.android.mapping.Game;
import org.tophat.android.networking.ApiCommunicator;

public class GameMapper extends Mapper {

	public GameMapper(ApiCommunicator apic) {
		super(apic);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected Game creator(Map<String, Object> data)
	{
		return new Game(data);
	}

}
