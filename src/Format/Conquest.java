import java.util.Random;
import Player.Player;

public class Conquest implements Format{
	
	public Player play(Player playerOne,Player playerTwo){		
		Player winner;
		while(playerOne.hasDecks() || playerTwo.hasDecks()){
			Deck playerOneDeck = playerOne.getUnusedDeck();
			Deck playerTwoDeck = playerTwo.getUnusedDeck();
			
			float playerOneWin = playerOneDeck.getWinPercentage(playerTwoDeck);
			
			Random rng = new Random();
			float playerTwoWin = rng.nextFloat();
			
			if(playerOneWin > playerTwoWin){
				playerOne.setDeckToUsed(playerOneDeck);
			}
			else{
				playerTwo.setDeckToUsed(playerTwoDeck);
			}
		}
		
		if(playerOne.hasDecks()){
			winner = playerTwo;
		}
		else{
			winner = playerOne;
		}
		playerOne.resetDecks();
		playerTwo.resetDecks();
		
		return winner;
	}
}
