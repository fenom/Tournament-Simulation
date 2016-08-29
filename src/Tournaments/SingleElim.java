package Tournaments;
import Player.*;
import Format.*;
import java.util.*;
public class SingleElim implements Tournament{
	BracketNode bracket;
	List<Player> players;
	Format format;
	DataObject data;
	public SingleElim(List<Player> players,Format format){
		this.players=players;
		this.format=format;
		bracket=BracketNode.generateBracketHelper(players);
	}
	public void processRounds(){
		processHelper(bracket);
	}	
	public void processHelper(BracketNode head){
		if(head.left.payload==null && head.right.payload==null){
			processHelper(head.left);
			processHelper(head.right);
		}
		Player playerOne=head.left.payload;
		Player playerTwo=head.right.payload;
		if(playerOne!=null && playerTwo!=null){
			head.payload=format.play(playerOne,playerTwo);
		}
	}
	public BracketNode getBracket(){
		return bracket;
	}
	public void setup(List<Player> players){
		bracket=BracketNode.generateBracketHelper(players);
	}
	public void getResults(){}
}

