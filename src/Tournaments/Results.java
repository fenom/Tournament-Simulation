package Tournaments;
public class Results{
	/*
	"I would have stored data on each player, their lineup, their path through the bracket including match/game results, and their finish

Tracking lineup: A trie structure would work best for retrieval of data.  But this is not efficient for creation and updating.  We could have a list of deck id's, then we would need to make sure these are normalized (sorted) so they would all hash to the same bucket.  We can't have [1,2,3] and [2,1,3].

Need to be able to index by player id and by placement in tournament as well.  Each of these should be done with maps, so we will need the following maps:

Player Placement Map<Place in tournament,Map<Players id,# of times finished>>
Player id Map<Player id,List<Placements>>
Player path Map<Player id, List<List<Matches>><
Player path Map<Place in tournament, List<List<Matches>>



and you could index by player ID and also provide an index by placement

so you could ask, what were the top 8 lineups

or did player 112 make top 8

or how many players brought zoo and how many players with zoo made top 8
"

	*/
}
