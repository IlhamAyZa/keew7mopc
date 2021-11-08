package Media;
public class Film extends Media {

	protected String director;

	public Film(String name, String genre, int numWatched, int likes, String director) {
		super(name, genre, numWatched, likes);
		this.director = director;
	}
	
	public Film(String name, String genre, String director) {
		super(name, genre, 0, 0);
		this.director = director;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}
}