package Media;

public class Series extends Media {

	protected int numEpisodes;
	protected int seasons;
	
	public Series(String name, String genre, int numWatched, int likes, int numEpisodes, int seasons) {
		super(name, genre, numWatched, likes);
		this.numEpisodes = numEpisodes;
		this.seasons = seasons;
	}

	public Series(String name, String genre, int numEpisodes, int seasons) {
		super(name, genre, 0, 0);
		this.numEpisodes = numEpisodes;
		this.seasons = seasons;
	}

	public int getNumEpisodes() {
		return numEpisodes;
	}

	public void setNumEpisodes(int numEpisodes) {
		this.numEpisodes = numEpisodes;
	}

	public int getSeasons() {
		return seasons;
	}

	public void setSeasons(int seasons) {
		this.seasons = seasons;
	}
}