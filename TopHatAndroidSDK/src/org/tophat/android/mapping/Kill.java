package org.tophat.android.mapping;

import java.util.ArrayList;
import java.util.Map;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 
 * This class is mapping for the user 
 * @author Kevin
 *
 */
public class Kill extends Mapping implements Parcelable {

	public static String API_URI = "kills";
	private Player victim;
	
	/**
	 * @return the victim
	 */
	public Player getVictim() {
		return victim;
	}

	/**
	 * @param victim the victim to set
	 */
	public void setVictim(Player victim) {
		this.victim = victim;
		
		this.setAttribute("victim", victim);
	}

	/**
	 * @return the killer
	 */
	public Player getKiller() {
		return killer;
	}

	/**
	 * @param killer the killer to set
	 */
	public void setKiller(Player killer) {
		this.killer = killer;
		
		this.setAttribute("killer", killer);
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
		this.setAttribute("time", time);
	}

	/**
	 * @return the verified
	 */
	public Boolean getVerified() {
		return verified;
	}

	/**
	 * @param verified the verified to set
	 */
	public void setVerified(Boolean verified) {
		this.verified = verified;
	}

	private Player killer;
	private String time;
	private Boolean verified;

	/**
	 * 
	 */
	public Kill()
	{
		super();
		this.setAccessUrl(API_URI);
		this.setKiller(null);
		this.setVictim(null);
		this.setTime(null);
		this.setVerified(null);
	}
	
	/**
	 * Setup the User object with the details supplied from the JSON from the platform.
	 * @param kill
	 */
	public Kill(Map<String, Object> kill)
	{
		super (kill);
		
		if (kill.containsKey("time"))
			this.setTime((String)kill.get("time"));
		
		if (kill.containsKey("killer"))
			this.setKiller(new Player((Map<String, Object>)kill.get("killer")));
		
		if (kill.containsKey("victim"))
			this.setVictim(new Player((Map<String, Object>)kill.get("victim")));
	}
	
	// Parcelling part
	public Kill(Parcel in){
		this.setId(in.readInt());
		this.setKiller((Player)in.readParcelable(Player.class.getClassLoader()));
		this.setTime(in.readString());
		this.setVictim((Player)in.readParcelable(Player.class.getClassLoader()));
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
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
           public Kill createFromParcel(Parcel in) {
               return new Kill(in);
           }

           public Kill[] newArray(int size) {
               return new Kill[size];
           }
       };

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(this.getId());	
		dest.writeParcelable(this.getKiller(), 0);
		dest.writeString(this.getTime());
		dest.writeParcelable(this.getVictim(), 0);
	}
}
