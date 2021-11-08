package Stream;

import java.util.ArrayList;

import Media.*;

public class StreamingService {

	protected String serviceName;
	protected ArrayList<User> users = new ArrayList<>();
	protected ArrayList<Media> media = new ArrayList<>();
	
	public StreamingService(String serviceName) {
		this.serviceName = serviceName;
	}

	public void addMedia(Media m) {
		media.add(m);
	}
	
	public boolean addUser(User user) {
		if (users.contains(user)) {
			System.out.println("User with same username already exists.");
			return false;
		}
		
		users.add(user);
		return true;
	}
	
	private User getMostSimilarUser(User user) {
		double max_sim = 0;
		int max_idx = 0;
		for(int i = 0; i < users.size(); i++) {
			if (max_sim < users.get(i).measureSimilarityWith(user)) {
				max_sim = users.get(i).measureSimilarityWith(user);
				max_idx = i;
			}
		}
		
		return users.get(max_idx);		
	}
	
	public Film recommendFilmBySimilarUser(User user) {
		User u = this.getMostSimilarUser(user);
		Film emptyFilm = new Film("anEmptyFilm", user.getFavoriteGenre(), "unknownDirector");
		
		System.out.println("Most similar user is " +u.getUsername() + " with a score of " + u.measureSimilarityWith(user));
		
		for (Media m : u.getLiked()) {
			if(m instanceof Film) {
				if(user.getWatched().contains(m) == false) {
					return (Film)m;
				}
			}
		}
		
		System.out.println("There is no film that is unliked of unwatched to recommend to user");
		return emptyFilm;
	}
	
	public Media recommendByGenre(User user) {
		
		Media emptyMedia = new Media("anEmptyMedia", user.getFavoriteGenre());
		
		System.out.println("Your favorite genre is:" + user.getFavoriteGenre());
		
		for (Media m : user.getLiked()) {
			if(m.getGenre() == user.getFavoriteGenre()) {
				if(user.getWatched().contains(m) == false) {
					return m;
				}
			}
		}
		
		System.out.println("There is no media of user's favourite genre that he/she has not been watched");
		return emptyMedia;
	}
}