package Format;

import java.util.*;
import Player.*;

public class LastHeroStanding implements Format{
	
	public Player play(Player playerOne,Player playerTwo){		
		Player winner;
		Player loser;
		getBans(playerOne,playerTwo);
		Deck playerOneDeck = playerOne.getUnusedDeck();
		Deck playerTwoDeck = playerTwo.getUnusedDeck();
		List<Game> games = new LinkedList<Game>();
		
		while(playerOne.hasDecks() && playerTwo.hasDecks()){
			if(playerOne.isActive){
				playerOneDeck = playerOne.getUnusedDeck();
			}
			if(playerTwo.isActive){
				playerTwoDeck = playerTwo.getUnusedDeck();
			}
			
			float playerOneWin = playerOneDeck.getWinPercentage(playerTwoDeck);
			Random rng = new Random();
			float playerTwoWin = rng.nextFloat();
			
			if(playerOneWin > playerTwoWin){
				playerTwo.setDeckToUsed(playerTwoDeck);
				playerOne.isActive = false;
				playerTwo.isActive = true;
				// when the player gets added as a game, their decks are messed up
				Game game = new Game(playerOne, playerTwo, playerOneDeck, playerTwoDeck);
				games.add(game);
			}
			else{
				playerOne.setDeckToUsed(playerOneDeck);
				playerOne.isActive = true;
				playerTwo.isActive = false;
				Game game = new Game(playerTwo, playerOne, playerTwoDeck, playerOneDeck);
				games.add(game);
			}
		}
		
		if(playerTwo.hasDecks()){
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
	public void getBans(Player p1,Player p2){
                p1.setDeckToUsed(p2.getBan(p1));
                p2.setDeckToUsed(p1.getBan(p2));
        }  

}
