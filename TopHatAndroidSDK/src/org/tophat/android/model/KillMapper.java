package org.tophat.android.model;

import java.util.Map;

import org.tophat.android.mapping.Kill;
import org.tophat.android.networking.ApiCommunicator;

public class KillMapper extends Mapper {

	public KillMapper(ApiCommunicator apic) {
		super(apic);
	}
	
	@Override
	protected Kill creator(Map<String, Object> data)
	{
		return new Kill(data);
	}


}
