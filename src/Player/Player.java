package Player;
import java.util.Random;
import java.util.List;
public class Player{
	public String name;
	private List<Deck> decks;
	public int id; //This seems like it will be useful, not sure.
	public boolean isActive=true; //Used for Last hero standing
	private boolean[] usedDecks; //False indicates a deck is unused.
	public	Player(String name, List<Deck> decks,int id){
		this.name=name;
		this.decks=decks;
		this.id=id;
		usedDecks=new boolean[decks.size()];
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
	public boolean equals(Player p){
		return p.id==this.id;
	}
}
