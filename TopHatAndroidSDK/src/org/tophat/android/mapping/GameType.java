package org.tophat.android.mapping;

import java.util.ArrayList;
import java.util.Map;

import android.os.Parcel;
import android.os.Parcelable;

public class GameType extends Mapping implements Parcelable {

	
	private String name;
	
	public GameType()
	{
		this.setId(null);
		this.setName(null);
	}
	
	public GameType(Parcel in)
	{
		this.setName(in.readString());
		this.setId(in.readInt());
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
		
		this.setAttribute("name", name);
	}

	public GameType(Map<String, Object> gametype)
	{
		super(gametype);
		
		if (gametype.containsKey("id"))
			this.setId((Integer)gametype.get("id"));
		
		if(gametype.containsKey("name"))
			this.setName((String)gametype.get("name"));
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.getName());
		dest.writeInt(this.getId());
	}
	
    /**
    *
    * This field is needed for Android to be able to
    * create new objects, individually or as arrays.
    *
    * This also means that you can use use the default
    * constructor to create the object and use another
    * method to hyrdate it as necessary.
    *
    * I just find it easier to use the constructor.
    * It makes sense for the way my brain thinks ;-)
    *
    */
   public static final Parcelable.Creator CREATOR =
   	new Parcelable.Creator() {
           public GameType createFromParcel(Parcel in) {
               return new GameType(in);
           }

           public GameType[] newArray(int size) {
               return new GameType[size];
           }
       };
	
}
