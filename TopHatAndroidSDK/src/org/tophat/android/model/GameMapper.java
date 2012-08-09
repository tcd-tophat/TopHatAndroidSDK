package org.tophat.android.model;

import java.util.ArrayList;
import java.util.Map;

import org.tophat.android.exceptions.HttpException;
import org.tophat.android.mapping.Game;
import org.tophat.android.mapping.GameList;
import org.tophat.android.mapping.Mapping;
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

	public GameList getGameList() throws HttpException
	{
		return new GameList(this.getApiCommunicator().get(GameList.API_URI));
	}
	
}
