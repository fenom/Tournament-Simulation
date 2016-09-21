package Player;
import java.util.Map;
public class Deck{
	//Not sure if I need to use an enum for class, making it a string for now.
	public String className;
	public String name;
	//Maps a deck ID to the win % this deck has versus the key deck ID.
	public Map<Integer,Float> matchups;
	public int id;
	public Deck(String name, Map<Integer,Float> matchups,int id){
		this.name=name;
		this.matchups=matchups;
		this.id=id;
	}
	public Float getWinPercentage(Deck deck){
//		if(deck.id==this.id)
//			return .5f;
		return this.matchups.get(deck.id);
	}
        public boolean equals(Deck d){ 
                return this.id==d.id;
        }   
}
