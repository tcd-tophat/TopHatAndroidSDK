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
public class User extends Mapping implements Parcelable {

	private static String API_URI = "users";
	private String name;
	private String email;
	private String created;
	private ArrayList<Game> joinedGames; 
	
	
	/**
	 * 
	 */
	public User()
	{
		this.setId(null);
		this.setName(null);
		this.setCreated(null);
		this.setEmail(null);
		this.setJoinedGames(new ArrayList<Game>());
	}
	
	/**
	 * Setup the User object with the details supplied from the JSON from the platform.
	 * @param user
	 */
	public User(Map<String, Object> user)
	{
		super (user);
		
		this.joinedGames = new ArrayList<Game>();
		
		if (user.containsKey("id"))
			this.setId((Integer)user.get("id"));
		
		if (user.containsKey("created"))
			this.setCreated((String)user.get("created"));
		
		if (user.containsKey("email"))
			this.setEmail((String)user.get("email"));
		
		if (user.containsKey("name"))
			this.setName((String)user.get("name"));
		
		if (user.containsKey("joined_games"))
		{	
			ArrayList<Map<String, Object>> gameslist = (ArrayList<Map<String, Object>>) user.get("joined_games");
			
			for(Map<String, Object> game : gameslist)
			{
				this.joinedGames.add(new Game(game));
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


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
		
		this.setAttribute("email", email);
	}


	/**
	 * @return the created
	 */
	public String getCreated() {
		return created;
	}


	/**
	 * @param created the created to set
	 */
	public void setCreated(String created) {
		this.created = created;
		
		this.setAttribute("created", created);
	}


	/**
	 * @return the joined_games
	 */
	public ArrayList<Game> getJoinedGames() {
		return joinedGames;
	}


	/**
	 * @param joined_games the joined_games to set
	 */
	public void setJoinedGames(ArrayList<Game> joinedGames) {
		this.joinedGames = joinedGames;
		
		ArrayList<Map<String, Object>> gamesMap = new ArrayList<Map<String, Object>>();
		
		//Loop through a list of games and provide this for the attribute map.
		for(Game game : joinedGames)
		{
			gamesMap.add(game.getMap());
		}
		
		this.setAttribute("joined_games", gamesMap);
	}
	
	// Parcelling part
	public User(Parcel in){
		ArrayList<String> data = new ArrayList<String>();
				
		in.readStringList(data);

		this.setName(data.get(0));
		this.setEmail(data.get(1));
		this.setId(Integer.parseInt(data.get(2)));
		
		this.joinedGames = new ArrayList<Game>();
		
		in.readList(this.joinedGames, Game.class.getClassLoader());
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
           public User createFromParcel(Parcel in) {
               return new User(in);
           }

           public User[] newArray(int size) {
               return new User[size];
           }
       };

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		ArrayList<String> data = dest.createStringArrayList ();
		
		data.add(this.getName());
		data.add(this.getEmail());
		
		if (this.getId() != null)
			data.add(this.getId().toString());
		else
			data.add(null);
		
		dest.writeStringList(data);
		
		dest.writeList(this.joinedGames);
		
	}
}
