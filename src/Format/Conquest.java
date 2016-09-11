package Format;

import java.util.*;
import Player.*;

public class Conquest implements Format{
	
	public Player play(Player playerOne,Player playerTwo){		
		Player winner;
		Player loser;
		List<Game> games = new ArrayList<Game>();
		
		while(playerOne.hasDecks() && playerTwo.hasDecks()){
			Deck playerOneDeck = playerOne.getUnusedDeck();
			Deck playerTwoDeck = playerTwo.getUnusedDeck();
			
			float playerOneWin = playerOneDeck.getWinPercentage(playerTwoDeck);
			Random rng = new Random();
			float playerTwoWin = rng.nextFloat();
			
			if(playerOneWin > playerTwoWin){
				playerOne.setDeckToUsed(playerOneDeck);
				Game game = new Game(playerOne, playerTwo, playerOneDeck, playerTwoDeck);
				games.add(game);
			}
			else{
				playerTwo.setDeckToUsed(playerTwoDeck);
				Game game = new Game(playerTwo, playerOne, playerTwoDeck, playerOneDeck);
				games.add(game);
			}
		}
		
		if(playerOne.hasDecks()){
			playerOne.resetDecks();
			playerTwo.resetDecks();
			winner = playerTwo;
			loser = playerOne;
		}
		else{
			playerOne.resetDecks();
			playerTwo.resetDecks();
			winner = playerOne;
			loser = playerTwo;
		}
		
		Match match = new Match(winner, loser, games);
		playerOne.addHistory(match);
		playerTwo.addHistory(match);
		return winner;
	}
}