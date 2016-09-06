package Testing;
import Tournaments.*;
import Player.*;
import java.util.*;
import org.junit.*;
public class BracketNodeTests{
	int size=32;
	BracketNode test;
	@Before
	public void setup(){
		List<Player> players=new LinkedList<>();
		for(int i=0;i<size;i++){
			players.add(new Player(String.valueOf(i)));
		}
		test=BracketConstruction.generateBracketHelper(players);
	}
	@Test
	public void testNumberOfPlayers(){
		assert(countPlayers(test)==size);
	}
	@Test
	public void testSpace(){
		assert(countSpace(test)==(2*size-1));
	}
	@Test
	public void testPlayersAtLeaves(){
		assert(playersAtLeaves(test));
	}
	public boolean playersAtLeaves(BracketNode head){
		if(head.payload!=null){
			return head.left!=null && head.right!=null;
		}
		return playersAtLeaves(head.left) && playersAtLeaves(head.right);
	}
	public int countPlayers(BracketNode head){
		if(head.payload!=null)
			return 1;
		return countPlayers(head.left)+countPlayers(head.right);
	}
	public int countSpace(BracketNode head){
		if(head==null)
			return 0;
		return 1+countSpace(head.left)+countSpace(head.right);
	}


}
