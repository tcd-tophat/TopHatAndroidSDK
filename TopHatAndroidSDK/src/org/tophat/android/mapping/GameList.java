package org.tophat.android.mapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * A Class in order to map the game mappings onto.
 * @author Kevin
 *
 */
public class GameList extends Mapping implements Parcelable{
	
	public static String API_URI = "games";
	
	private Integer maxPerpage;
	/**
	 * @return the maxPerpage
	 */
	public Integer getMaxPerpage() {
		return maxPerpage;
	}

	/**
	 * @param maxPerpage the maxPerpage to set
	 */
	public void setMaxPerpage(Integer maxPerpage) {
		this.maxPerpage = maxPerpage;
		
		this.setAttribute("max_perpage", maxPerpage);
	}

	/**
	 * @return the pagination_offset
	 */
	public Integer getPaginationOffset() {
		return paginationOffset;
	}

	/**
	 * @param pagination_offset the pagination_offset to set
	 */
	public void setPaginationOffset(Integer paginationOffset) {
		this.paginationOffset = paginationOffset;
		
		this.setAttribute("pagination_offset", paginationOffset);
	}

	/**
	 * @return the games
	 */
	public ArrayList<Game> getGames() {
		return games;
	}

	/**
	 * @param games the games to set
	 */
	public void setGames(ArrayList<Game> games) {
		this.games = games;
		
		ArrayList<Map<String, Object>> gamesMap = new ArrayList<Map<String, Object>>();
		
		//Loop through a list of games and provide this for the attribute map.
		for(Game game : games)
		{
			gamesMap.add(game.getMap());
		}
		
		this.setAttribute("games", gamesMap);
	}

	private Integer paginationOffset;
	private ArrayList<Game> games;
	
	public GameList()
	{
		this.setGames(new ArrayList<Game>());
		this.setMaxPerpage(null);
		this.setPaginationOffset(null);
	}
	
	public GameList(Map<String, Object> gamelist)
	{
		super(gamelist);
		
		this.setGames(new ArrayList<Game>());
		
		if (gamelist.containsKey("pagination_offset"))
			this.setPaginationOffset((Integer)gamelist.get("pagination_offset"));
		
		if (gamelist.containsKey("max_perpage"))
			this.setMaxPerpage((Integer)gamelist.get("max_perpage"));
		
		if (gamelist.containsKey("games"))
		{
			ArrayList<Map<String, Object>> games = (ArrayList<Map<String, Object>>) gamelist.get("games");
			
			for(Map<String, Object> game : games)
			{
				this.games.add(new Game(game));
			}
		}
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
           public GameList createFromParcel(Parcel in) {
               return new GameList(in);
           }

           public GameList[] newArray(int size) {
               return new GameList[size];
           }
       };

   	public GameList(Parcel in)
   	{
   		this.setMaxPerpage(in.readInt());
   		this.setPaginationOffset(in.readInt());
   		
   		ArrayList<Game> games = new ArrayList<Game>();
   		
   		in.readList(games, Game.class.getClassLoader());
   		
   		this.setGames(games);
   	}
   	
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		
		dest.writeInt(this.getMaxPerpage());
		dest.writeInt(this.getPaginationOffset());
		
		dest.writeList(this.getGames());
	}
}
