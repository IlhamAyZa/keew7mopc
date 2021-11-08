package Media;

public class Media {

	protected String name;
	protected String genre;
	protected int numWatched;
	protected int likes;
	
	public Media(String name, String genre, int numWatched, int likes) {
		this.name = name;
		this.genre = genre;
		this.numWatched = numWatched;
		this.likes = likes;
	}

	public Media(String name, String genre) {
		this.name = name;
		this.genre = genre;
		this.numWatched = 0;
		this.likes = 0;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getNumWatched() {
		return numWatched;
	}

	public void setNumWatched(int numWatched) {
		this.numWatched = numWatched;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public void addNumWatched(boolean like) {
		if(like) {
			likes++;
		}
		
		numWatched++;
	}	
	
	public double getRating() {
		return likes / numWatched ;
	}

}
