package Player;
import java.util.Random;
import java.util.*;
public class Player{
	public String name;
	private List<Deck> decks;
	public int id; //This seems like it will be useful, not sure.
	public boolean isActive=true; //Used for Last hero standing
	private boolean[] usedDecks; //False indicates a deck is unused.
	public List<Match> history;
	public	Player(String name, List<Deck> decks,int id){
		this.name=name;
		this.decks=decks;
		this.id=id;
		usedDecks=new boolean[decks.size()];
		history = new LinkedList<Match>();
	}
	//Just for testing purposes.
	public Player(String name){
		this.name=name;
	}
	public boolean hasDecks(){
		for(boolean b: usedDecks){
			if(!b)
				return true;
		}
		return false;
	}
	public Deck getUnusedDeck(){
		if(!this.hasDecks())
			return null; //You messed up, no more decks.
		
		Random rng=new Random();
		int index=rng.nextInt(decks.size());
		while(usedDecks[index])
			index=rng.nextInt(decks.size());
		return decks.get(index);
	}
	public boolean setDeckToUsed(Deck deck){
		if(usedDecks[decks.lastIndexOf(deck)])
			return false; //Deck is already used
		
		usedDecks[decks.lastIndexOf(deck)]=true;
		return true;
	}
	public void resetDecks(){
		usedDecks=new boolean[decks.size()];
	}
	public void addHistory(Match match){
		history.add(match);
	}
	public void resetHistory(){
		history=new LinkedList<Match>();
	}
	public boolean equals(Player p){
		return p.id==this.id;
	}
	public List<Deck> getDecks(){
		return decks;
	}
	public Deck getBan(Player p){
		List<Deck> opponentDecks=p.getDecks();
		Deck ban=null;
		float f=0;
		for(Deck d:opponentDecks){
			float temp=0;
			for(Deck d2:this.decks){
				temp+=d.getWinPercentage(d2);
			}
			if(temp>f)
				ban=d;
		}
		return ban;
	}
}
