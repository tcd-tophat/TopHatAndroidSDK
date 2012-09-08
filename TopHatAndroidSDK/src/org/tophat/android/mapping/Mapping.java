package org.tophat.android.mapping;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Mapping
{
	
	@JsonIgnore private Map<String, Object> data;
	private static String API_URI;

	public Mapping()
	{
		this.data = new HashMap<String, Object>();
		this.setId(null);
		this.setAccessUrl(API_URI);
	}
	
	public Mapping(Map<String, Object> data)
	{
		this.setAccessUrl(API_URI);
		this.data = data;
		
		if (data.containsKey("id"))
			this.setId((Integer)data.get("id"));
	}
	
	@JsonIgnore
	public Map<String, Object> getMap()
	{
		if( this.data == null)
		{
			this.data = new HashMap<String, Object>();
		}
		
		return data;
	}
	
	/**
	 * This method is used in particular to get dynamic attributes that have been added by the developer to the server side but are unavailable via standard mapping in java/android
	 * @param key
	 * @return Returns the Object requested, or null, if the object does not exist, or if the data map has not been set.
	 */
	@JsonIgnore
	public Object getAttribute(String key)
	{
		if ( this.data != null )
		{
			if ( this.data.containsKey(key) )
			{
				return this.data.get(key);
			}
			else
			{
				return null;
			}
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * Allows the setting of dynamic objects in the mapping classes
	 * @param key
	 * @param value
	 */
	public void setAttribute(String key, Object value)
	{
		if ( this.data == null)
		{
			this.data = new HashMap<String, Object>();
		}
		
		this.data.put(key, value);
	}
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
		
		this.setAttribute("id", id);
	}

	/**
	 * @return the accessUrl
	 */
	@JsonIgnore
	public String getAccessUrl() {
		return accessUrl;
	}

	/**
	 * @param accessUrl the accessUrl to set
	 */
	public void setAccessUrl(String accessUrl) {
		this.accessUrl = accessUrl;
	}

	protected Integer id;
	protected String accessUrl;
}
