package Tournament;
import java.util.*;
import Player.*;
public class BracketNode{
	private BracketNode left;
	private BracketNode right;
	//BracketNode parent;
	Player payload=null;
	
	/*
		Given a list of players and a head node with null pointers, generate a
		complete bracket where all the players are leaf nodes of the bracket.
		Note this only works for lists of size power of 2.
	*/
	public boolean hasPayload(){
		return payload!=null;
	}
	public BracketNode generateBracket(BracketNode node, ListIterator<Player> players,int depth){
		if(depth==0){
			BracketNode retVal=new BracketNode();
			retVal.payload=players.next();
			return retVal;
		}
		node.left=generateBracket(new BracketNode(),players, depth-1);
		node.right=generateBracket(new BracketNode(),players,depth-1);
		return  node;
	}
	public BracketNode generateBracketHelper(List<Player> players){
		return generateBracket(new BracketNode(),players.listIterator(),log2(players.size()));

	}

	public static int log2(int n){
		if(n <= 0) throw new IllegalArgumentException();
    		return 31 - Integer.numberOfLeadingZeros(n);
	}
}
