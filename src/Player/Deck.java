package Player;
import java.util.Map;
public class Deck{
	public String name;
	public Map<Integer,Integer> matchups;
	public int id;
	public Deck(String name, Map<Integer,Integer> matchups,int id){
		this.name=name;
		this.matchups=matchups;
		this.id=id;
	}
	public int getWinPercentage(Deck deck){
		return this.matchups.get(deck.id);
	}
}
