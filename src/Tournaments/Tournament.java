package Tournament;
public interface Tournament{
	List<Player> players;
	Format format;
	//Need a structure to hold current rounds and standings
	/*
	Simulates the next round of play.
	*/
	public void processRound();
	/*
	Once the tournament is finished, gives you standings of all players
	*/
	public void getResults();

}
