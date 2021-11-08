package Stream;

import java.util.ArrayList;

import Media.Film;
import Media.Media;

public class User {

	protected String username;
	protected ArrayList<Media> watched = new ArrayList<>();
	protected ArrayList<Media> liked = new ArrayList<>();
	
	public User(String username) {
		super();
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ArrayList<Media> getWatched() {
		return watched;
	}

	public void setWatched(ArrayList<Media> watched) {
		this.watched = watched;
	}

	public ArrayList<Media> getLiked() {
		return liked;
	}

	public void setLiked(ArrayList<Media> liked) {
		this.liked = liked;
	}

	public void watch(Media m, boolean like) {
		
		if(watched.contains(m) == false){
			watched.add(m);
			
			if (like) {
				liked.add(m);
			}
		}
		
		m.addNumWatched(like);
	}
	
	public String getFavoriteGenre() {

		int sci = 0;
		int dra = 0;
		
		for (Media m : liked) {
			String key = m.getGenre();
			
			   
			switch (key) {
			
			case "Sci-Fi":
				sci++;
			case "drama":
				dra++;
			
			}	
		}
			
		if (sci < dra) {
			return "Sci-Fi";
		}
		return "drama" ;
	}
	
	public double measureSimilarityWith(User u) {
		int similarity = 0;
		
		for (Media m : u.getLikedFilms()) {
			if (this.liked.contains(m)) {
				similarity++;
			}
		}
		
		return similarity;
	}

	public ArrayList<Film> getLikedFilms(){
		ArrayList<Film> new_array = new ArrayList<>();
		
		for (Media m : liked) {
			if(m instanceof Film) {
				new_array.add((Film) m);
			}
		}
		
		return new_array;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", watched=" + watched + ", liked=" + liked + "]";
	}

}
