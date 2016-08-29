package Testing;
import Tournaments.*;
import Player.*;
import Format.*;
import java.util.*;
public class SingleElimTests{
	Tournament tournament;
	@Before
	public void setup(){	
		Map<Integer,Float> matchUpsOne=new HashMap<>();
		matchUpsOne.put(1,.5);
		matchUpsOne.put(2,.4);	
		Map<Integer,Float> matchUpsTwo=new HashMap<>();
		matchUpsTwo.put(0,.5);
		matchUpsTwo.put(2,.4);
		Map<Integer,Float> matchUpsThree=new HashMap<>();
		matchUpsThree.put(0,.6);
		matchupsThree.put(1,.6);
		List<Deck> decks=new LinkedList<>();
		decks.add("Deck zero",matchUpsOne,0);
		decks.add("Deck one",matchUpsTwo,1);
		decks.add("Deck two",matchUpsThree,2);
		List<Player> players=new LinkedList<>();
		for(int i=0;i<128;i++){
			players.add(new Player(String.valueOf(i)),decks,i);
		}
		Format format=new Conquest();
		tournament=new SingleElim(players,format);
		tournament.processRounds();
	}
	@Test
	public void verifyBracket(){
		assert(verifyPlayers(tournament.bracket));
	}
	public boolean verifyPlayers(BracketNode head){
		Player p=head.payload;
		if(head.left==null && head.right==null)
			return true;
		if(head.left.payload.equals(p) ^^ head.right.payload.equals(p)){
			return verifyPlayers(head.left) && verifyPlayers(head.right);
	}else
		return false;
	}

}
