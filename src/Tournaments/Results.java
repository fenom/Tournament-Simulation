package Tournaments;
import Player.*;
import java.util.*;
public class Results{
	/*
	"I would have stored data on each player, their lineup, their path through the bracket including match/game results, and their finish

Tracking lineup: A trie structure would work best for retrieval of data.  But this is not efficient for creation and updating.  We could have a list of deck id's, then we would need to make sure these are normalized (sorted) so they would all hash to the same bucket.  We can't have [1,2,3] and [2,1,3].

Need to be able to index by player id and by placement in tournament as well.  Each of these should be done with maps, so we will need the following maps:

Player Placement Map<Place in tournament,Map<Players id,# of times finished>>
Player id Map<Player id,Map<Place,times>>
Player path Map<Player id, List<List<Matches>><
Player path Map<Place in tournament, List<List<Matches>>

and you could index by player ID and also provide an index by placement

so you could ask, what were the top 8 lineups

or did player 112 make top 8

or how many players brought zoo and how many players with zoo made top 8
"

	*/
	private Map<Integer,HashMap<Integer,Integer>> placementMap;
	private Map<Integer,HashMap<Integer,Integer>> playerMap;
	private Map<Integer,List<List<Match>>> playerIDPath;
	private Map<Integer,List<List<Match>>> playerPlacementPath;

	public void setPlacementMap(Map<Integer,HashMap<Integer,Integer>> map){
		placementMap=map;
	}

	public Map<Integer,HashMap<Integer,Integer>> getPlacementMap(){
		return placementMap;
	}	
	public void setPlayerMap(Map<Integer,HashMap<Integer,Integer>> map){
		playerMap=map;
	}
	public Map<Integer,HashMap<Integer,Integer>> getPlayerMap(){
		return playerMap;
	}
	public void setPlayerPathMap(Map<Integer,List<List<Match>>> map){
		playerIDPath=map;
	}
	public Map<Integer,List<List<Match>>> getPlayerPathMap(){
		return playerIDPath;
	}
	public void setPlacementPathMap(Map<Integer,List<List<Match>>> map){
		playerPlacementPath=map;
	}
	public Map<Integer,List<List<Match>>> getPlacementPathMap(){
		return playerPlacementPath;
	}

}


