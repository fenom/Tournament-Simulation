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
	private Map<Integer,HashMap<Integer,Integer>> placementMap=new HashMap<>();
	private Map<Integer,HashMap<Integer,Integer>> playerMap=new HashMap<>();
	private Map<Integer,List<List<Match>>> playerIDPath=new HashMap<>();
	private Map<Integer,List<List<Match>>> playerPlacementPath=new HashMap<>();
	private Map<Integer,List<Player>> results;
	private Map<Integer,Integer> playerRankings;
	private Map<Integer,Player> players;
	/*
		The idea here is to have the maps be set with the data I want
		so I'll never have to insert into the maps, all the buckets
		will be there on initialization.
	*/

	public Map<Integer,Player> getPlayers(){
		return players;
	}
	public Map<Integer,Integer> getPlayerRankings(){
		return playerRankings;
	}
	public Map<Integer,HashMap<Integer,Integer>> getPlayerMap(){
		return playerMap;
	}
	public Map<Integer,HashMap<Integer,Integer>> getPlacementMap(){
		return placementMap;
	}
	public Map<Integer,List<List<Match>>> getPlacementPathMap(){
		return playerPlacementPath;
	}
	
	public void setPlacementMap(int i){
		if(placementMap.get(i)==null)
			placementMap.put(i,new HashMap<Integer,Integer>());
	}
	public void setPlayerMap(int i){
		if(playerMap.get(i)==null)
			playerMap.put(i,new HashMap<Integer,Integer>());
	}
	public void setPlayerPathMap(int i){
		if(playerIDPath.get(i)==null)
			playerIDPath.put(i,new LinkedList<List<Match>>());
	}
	public Map<Integer,List<List<Match>>> getPlayerPathMap(){
		return playerIDPath;
	}
	public void setPlacementPathMap(int i){
		if(playerPlacementPath.get(i)==null)
			playerPlacementPath.put(i,new LinkedList<List<Match>>());
	}
	
	/*
		I think I want to update the maps with data using a 
		Map<Ranking,List<Player>> thus I can just iterate over the keyset
		of the stored maps.  This reduces my time to the space used by the
		objects in this class.
	*/
	public void updateMaps(Map<Integer,List<Player>> map,Map<Integer,Integer> playerRankings){
		results=map;
		this.playerRankings=playerRankings;
		updatePlacementMap();
		updatePlayerMap();
		updatePlacementPathMap();
		updatePlayerPathMap();
	}
	public void updatePlacementMap(){
		for(Integer i: placementMap.keySet()){
			if(results.get(i)!=null){
				Map<Integer,Integer> map=placementMap.get(i);
				for(Player p: results.get(i)){
					int id=p.id;
					if(map.get(id)!=null)
						map.put(id,map.get(id)+1);
					else
						map.put(id,1);
				}
			}
		}		
	}
	public void updatePlayerMap(){
		for(Integer i: playerMap.keySet()){
			Map<Integer,Integer> map=playerMap.get(i);
			int rank=playerRankings.get(i);
			if(map.get(rank)==null)
				map.put(rank,1);
			else
				map.put(rank,map.get(rank)+1);
		}
	}
	public void updatePlacementPathMap(){
		for(Integer i: playerPlacementPath.keySet()){
			List<List<Match>> list=playerPlacementPath.get(i);
			if(results.containsKey(i)){
				for(Player p: results.get(i)){
					if(list==null){
						list=new LinkedList<List<Match>>();
						list.add(p.history);
					}else{
						list.add(p.history);
					}
				}
			}
		}
	}
	public void updatePlayerPathMap(){
		for(Integer i: playerIDPath.keySet()){
			List<List<Match>> list=playerIDPath.get(i);
			if(list==null)
				list=new LinkedList<List<Match>>();
			list.add(players.get(i).history);
			
		}
	}
}