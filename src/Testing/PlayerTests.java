package Testing;
import java.util.*;
import java.util.ArrayList;
import org.junit.*;
import org.junit.Before;
import org.junit.Test;
import Player.*;
public class PlayerTests{
	List<Deck> decks;
	Player david;
	Player owen;
	@Before
	public void before(){
		Deck renoMage=new Deck("Reno Mage",new HashMap<Integer,Integer>(),0);
		Deck comboDruid=new Deck("Combo Druid",new HashMap<Integer,Integer>(),1);
		Deck turboWarrior=new Deck("C'thun Warrior",new HashMap<Integer,Integer>(),2);
		decks=new ArrayList<>();
		decks.add(renoMage);
		decks.add(comboDruid);
		decks.add(turboWarrior);
		david=new Player("David 'BirthdayLion' Steinberg",decks);
		owen=new Player("StarGazer",decks);
	}
	@Test
	public void deckCheck(){
		for(int i=0;i<decks.size();i++){
			assert(david.hasDecks());
			assert(owen.hasDecks());	
			assert(owen.setDeckToUsed(decks.get(i)));
			assert(david.setDeckToUsed(decks.get(i)));
		}
		assert(!owen.hasDecks());	
		assert(!david.hasDecks());	
		owen.resetDecks();
		david.resetDecks();
		assert(owen.hasDecks());
		assert(david.hasDecks());
	}	


}
