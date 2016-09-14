package Tournaments;
import Format.*;
import Player.*;
import java.uitl.*;
public class DoublElim extends SingleElim{
	SingleElim losersBracket;
	public DoubleElim(List<Players> players,Format format){
		super(players,format);
	}
	public void processRounds(){
		super.processRounds();
		List<Players> losers=new LinkedList<Players>;
		getLosers(this.bracket,losers);
		//make a second bracket out of losers.
	}
	public void getLosers(BracketNode head,List<Players> players){
		if(head.left==null && head.right==null)
			return;
		Player p=head.payload;
		if(p.id==head.left.id){
			players.add(head.right.payload);
			getLosers(head.right,players);
		}else{
			players.add(head.left.payload);
			getLosers(head.left,players);
		}
	}
	public void getResults(){
		//stuff
	}
	public void setup(){
		super.setup();
	}
}
