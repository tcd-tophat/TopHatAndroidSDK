package org.tophat.android.mapping;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * A Class in order to map the game mappings onto.
 * @author Kevin
 *
 */
public class Game extends Mapping implements Parcelable {
	
	private static String API_URI = "games";
	private User creator;
	private String time;
	private String name;
	private GameType gameType;
	
	public Game()
	{
		super();
	}
	
	private void setGameType(GameType gametype) {
		this.gameType = gametype;
	}

	public Game(Map<String, Object> game)
	{
		super(game);
		
		if (game.containsKey("time"))
			this.setTime((String)game.get("time"));
		
		if (game.containsKey("name"))
			this.setName((String)game.get("name"));
		
		if (game.containsKey("creator"))
			this.setCreator(new User((Map<String, Object>)game.get("creator")));
		
		if (game.containsKey("game_type"))
			this.setGameType(new GameType((Map<String, Object>)game.get("game_type")));
	}
	
	/**
	 * @return the creator
	 */
	public User getCreator() {
		return creator;
	}


	/**
	 * @param creator the creator to set
	 */
	public void setCreator(User creator)
	{
		if(creator != null)
		{
			creator = new User();
		}
		
		this.creator = creator;
		
		this.setAttribute("user", creator.getMap());
	}


	/**
	 * @return the time
	 */
	public String getTime() 
	{
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


	/**
	 * @return the gameType
	 */
	public GameType getGameType() {
		return gameType;
	}

	// Parcelling part
	public Game(Parcel in){
		ArrayList<String> data = new ArrayList<String>();
				
		in.readStringList(data);
		
		this.setName(data.get(0));
		this.setTime(data.get(1));
		this.setId(Integer.parseInt(data.get(2)));
		
		this.setCreator((User)in.readParcelable(User.class.getClassLoader()));
		this.setGameType((GameType)in.readParcelable(GameType.class.getClassLoader()));
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		ArrayList<String> data = dest.createStringArrayList ();
		
		data.add(this.getName());
		data.add(this.getTime());
		data.add(this.getId().toString());
		
		dest.writeStringList(data);
		
		dest.writeParcelable(this.getCreator(), 0);
		dest.writeParcelable(this.getGameType(), 0);
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
           public Game createFromParcel(Parcel in) {
               return new Game(in);
           }

           public Game[] newArray(int size) {
               return new Game[size];
           }
       };
}
