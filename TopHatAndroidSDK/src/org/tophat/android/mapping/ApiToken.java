package org.tophat.android.mapping;

import java.util.Map;

import android.os.Parcel;
import android.os.Parcelable;

public class ApiToken extends Mapping implements Parcelable {
	
	public static String API_URI = "apitokens";
	private String apitoken;
	private User user;
	
	
	public ApiToken()
	{
		this.apitoken = null;
		this.user = null;
		this.setAccessUrl(API_URI);
	}
	
	public ApiToken(Map<String, Object> apitoken)
	{
		super(apitoken);
		
		if(apitoken.containsKey("apitoken"))
		{
			this.apitoken = (String) apitoken.get("apitoken");
		}
		
		if(apitoken.containsKey("user"))
		{
			this.user = new User((Map<String, Object>)apitoken.get("user"));
		}
	}

	// Parcelling part
	public ApiToken(Parcel in){
		this.setApitoken(in.readString());
		
		this.setUser((User)in.readParcelable(User.class.getClassLoader()));
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.getApitoken());
		
		dest.writeParcelable(this.getUser(), 0);
	}
	
    /**
	 * @return the apitoken
	 */
	public String getApitoken() {
		return apitoken;
	}

	/**
	 * @param apitoken the apitoken to set
	 */
	public void setApitoken(String apitoken) {
		this.apitoken = apitoken;
		
		//Set the attribute in the mapping in addition to the variable in the local class
		this.setAttribute("apitoken", apitoken);
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
		this.setAttribute("user", user.getMap());
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
           public ApiToken createFromParcel(Parcel in) {
               return new ApiToken(in);
           }

           public ApiToken[] newArray(int size) {
               return new ApiToken[size];
           }
       };
}
