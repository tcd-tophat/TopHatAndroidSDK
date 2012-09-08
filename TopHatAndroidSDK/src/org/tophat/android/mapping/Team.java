package org.tophat.android.mapping;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.tophat.android.exceptions.BadResponse;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * A Class in order to map the game mappings onto.
 * @author Kevin
 *
 */
public class Team extends Mapping implements Parcelable {
	
	private static String API_URI = "teams";
	private String name;
	
	private ArrayList<Player> players;
	/**
	 * @return the players
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}

	/**
	 * @param players the players to set
	 */
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	private Game game;
	
	public Team()
	{
		super();
	}
	
	public Team(Map<String, Object> team)
	{
		super(team);
		
		if (team.containsKey("game"))
			this.setGame(new Game((Map<String, Object>)team.get("game")));
		
		if (team.containsKey("name"))
			this.setName((String)team.get("name"));
		
		if (team.containsKey("players"))
		{
			this.players = new ArrayList<Player>();
			ArrayList<Map<String, Object>> players = (ArrayList<Map<String, Object>>) team.get("players");
			
			for(Map<String, Object> player : players)
			{
				try
				{
					this.players.add(new Player(player));
				}
				catch(NullPointerException nep)
				{
					nep.printStackTrace();
				}
			}
		}
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

	// Parcelling part
	public Team(Parcel in){
		this.setName(in.readString());
		this.setId(Integer.parseInt(in.readString()));
		
		this.setGame((Game)in.readParcelable(Game.class.getClassLoader()));

   		ArrayList<Player> players = new ArrayList<Player>();
   		
   		in.readList(players, Player.class.getClassLoader());
   		
   		this.setPlayers(players);
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		
		dest.writeString(this.getName());
		dest.writeString(this.getId().toString());
		dest.writeParcelable(this.getGame(), 0);
		dest.writeList(this.getPlayers());
	}
	
    /**
	 * @return the game
	 */
	public Game getGame() {
		return game;
	}

	/**
	 * @param game the game to set
	 */
	public void setGame(Game game) {
		this.game = game;
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
           public Team createFromParcel(Parcel in) {
               return new Team(in);
           }

           public Team[] newArray(int size) {
               return new Team[size];
           }
       };
}
