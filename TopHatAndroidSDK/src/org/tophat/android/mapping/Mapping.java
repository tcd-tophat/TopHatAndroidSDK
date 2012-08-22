package org.tophat.android.mapping;

import java.util.HashMap;
import java.util.Map;

public class Mapping {
	
	private Map<String, Object> data;

	public Mapping()
	{
		this.data = new HashMap<String, Object>();
		this.setId(null);
	}
	
	public Mapping(Map<String, Object> data)
	{
		this.data = data;
	}
	
	public Map<String, Object> getMap()
	{
		return data;
	}
	
	/**
	 * This method is used in particular to get dynamic attributes that have been added by the developer to the server side but are unavailable via standard mapping in java/android
	 * @param key
	 * @return Returns the Object requested, or null, if the object does not exist, or if the data map has not been set.
	 */
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
	public String getAccessUrl() {
		return accessUrl;
	}

	/**
	 * @param accessUrl the accessUrl to set
	 */
	public void setAccessUrl(String accessUrl) {
		this.accessUrl = accessUrl;
	}

	private Integer id;
	private String accessUrl;
}
