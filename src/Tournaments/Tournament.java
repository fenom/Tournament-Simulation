package Tournaments;
import Format.*;
public interface Tournament{
	List<Player> players;
	Format format;
	DataObject data;
	//Need a structure to hold current rounds and standings
	/*
	Simulates the next round of play.
	*/
	public void processRounds();
	/*
	Once the tournament is finished, gives you standings of all players
	*/
	public void getResults();

	public void setup(List<Player> players);
}
