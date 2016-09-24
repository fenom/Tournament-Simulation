package Format;

import java.util.*;
import Player.*;

public class Conquest implements Format{
	
	public Player play(Player playerOne,Player playerTwo){		
		Player winner;
		Player loser;
		List<Game> games = new LinkedList<Game>();
		//If bans enabled
		getBans(playerOne,playerTwo);
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
	public void getBans(Player p1,Player p2){
		Deck d1=p2.getBan(p1);
		Deck d2=p1.getBan(p2);
//		System.out.println(p1.name+" id: "+p1.id+" bans "+d2.name);
//		System.out.println(p2.name+" id: "+p2.id+" bans "+d1.name);
/*		if(p1.id==1 && p2.id==2){
			while(d1.id!=10)
				d1=p1.getUnusedDeck();
			while(d2.id!=2)
				d2=p2.getUnusedDeck();
		}else if(p1.id==2 && p2.id==4){
			while(d1.id!=3)
				d1=p1.getUnusedDeck();
			while(d2.id!=1)
				d2=p2.getUnusedDeck();
		}else if(p1.id==4 && p2.id==8){
                        while(d1.id!=1)
                                d1=p1.getUnusedDeck();
                        while(d2.id!=13)
                                d2=p2.getUnusedDeck();
                }else if(p1.id==5 && p2.id==8){
                        while(d1.id!=11)
                                d1=p1.getUnusedDeck();
                        while(d2.id!=13)
                                d2=p2.getUnusedDeck();
                }else if(p1.id==5 && p2.id==6){
                        while(d1.id!=10)
                                d1=p1.getUnusedDeck();
                        while(d2.id!=3)
                                d2=p2.getUnusedDeck();
                }else if(p1.id==3 && p2.id==4){
                        while(d1.id!=3)
                                d1=p1.getUnusedDeck();
                        while(d2.id!=1)
                                d2=p2.getUnusedDeck();
                }else if(p1.id==7 && p2.id==8){
                        while(d1.id!=13)
                                d1=p1.getUnusedDeck();
                        while(d2.id!=12)
                                d2=p2.getUnusedDeck();
                } 
*/
		//Pseudo strategic ban
//Cydonia always bans zoo
/*		if(p1.id==1){
			for(Deck d:p2.getDecks()){
				if(d.id==4)
					d2=d;
			}
		}
*/	//	System.out.println(p1.name+" id: "+p1.id+" bans "+d2.name);
	//	System.out.println(p2.name+" id: "+p2.id+" bans "+d1.name);
		p1.setDeckToUsed(d1);
		p2.setDeckToUsed(d2);
		//Random Bans
//		p1.setDeckToUsed(p1.getUnusedDeck());
//		p2.setDeckToUsed(p2.getUnusedDeck());
		//Actual bans
	}
	
}
