package Format;
import java.util.Random;
import Player.*;

public class LastHeroStanding implements Format{
	
	public Player play(Player playerOne,Player playerTwo){		
		Player winner;
		Deck playerOneDeck;
		Deck playerTwoDeck;
		
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
			}
			else{
				playerOne.setDeckToUsed(playerOneDeck);
				playerOne.isActive = true;
				playerTwo.isActive = false;
			}
		}
		
		if(playerTwo.hasDecks()){
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
