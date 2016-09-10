package Tournaments;
import Player.*;
import Format.*;
import java.util.*;
public class SingleElim implements Tournament{
	BracketNode bracket;
	List<Player> players;
	Format format;
	DataObject data;
	Results results;
	public SingleElim(List<Player> players,Format format){
		this.players=players;
		this.format=format;
		this.setup();
	}
	public void processRounds(){
		processHelper(bracket);
	}	
	public void processHelper(BracketNode head){
		if(head.left.payload==null && head.right.payload==null){
			processHelper(head.left);
			processHelper(head.right);
		}
		//Evaluate play in matches.
		if(head.left.payload==null)
			processHelper(head.left);
		if(head.right.payload==null)
			processHelper(head.right);
		Player playerOne=head.left.payload;
		Player playerTwo=head.right.payload;
		//We have two players, lets evaluate this round.
		if(playerOne!=null && playerTwo!=null)
			head.payload=format.play(playerOne,playerTwo);
	}
	public void setResults(Results r){
		results=r;
	}
	public BracketNode getBracket(){
		return bracket;
	}
	public void setup(){	
		bracket=BracketConstruction.generateBracketHelper(this.players);
	}
	public void getResults(){
		Map<Integer,List<Player>> rankMap=new HashMap<Integer,List<Player>>();
		Map<Integer,Integer> idRank=new HashMap<Integer,Integer>();
		populateMaps(rankMap,idRank,bracket,1);
		results.updateMaps(rankMap,idRank);
	}
	public void populateMaps(Map<Integer,List<Player>> rank, Map<Integer,Integer> id, BracketNode node, int depth){
		if(node==null)
			return;
		Player p=node.payload;
		List<Player> list=rank.get(depth);
		if(id.get(p.id)==null){
			if(list==null){
				list=new LinkedList<Player>();
				list.add(p);
				rank.put(depth,list);
			}else{
				list.add(p);
			}
		}
		if(id.get(p.id)==null)
			id.put(p.id,depth);
		populateMaps(rank,id,node.left,depth*2);
		populateMaps(rank,id,node.right,depth*2);
	}
}

