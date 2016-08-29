package Tournaments;
import Player.*;
import Format.*;
public class SingleElim implements Tournament{
	BracketNode bracket;
	List<Player> players;
	Format format;
	DataObject data;
	public SingleElim(List<Players> players,Format format){
		this.players=players;
		this.format=format;
		bracket=BracketNode.generateBracketHelper(players);
	}
	public void processRounds(){

	}	

	public void getResults(){

	}

	public void setup(
}
