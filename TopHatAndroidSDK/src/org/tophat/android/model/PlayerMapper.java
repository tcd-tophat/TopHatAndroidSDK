package org.tophat.android.model;

import java.util.Map;

import org.tophat.android.exceptions.HttpException;
import org.tophat.android.mapping.Player;
import org.tophat.android.networking.ApiCommunicator;

public class PlayerMapper extends Mapper {

	public PlayerMapper(ApiCommunicator apic) {
		super(apic);
	}
	
	@Override
	protected Player creator(Map<String, Object> data)
	{
		return new Player(data);
	}
	
	public Player get(Integer id) throws HttpException
	{
		return (Player)this.get(new Player(), id);
	}
}
