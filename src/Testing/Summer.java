package Testing;
import Tournaments.*;
import Player.*;
import Format.Conquest;
import java.util.*;
import java.io.*;
//import org.junit.*;

public class Summer{
	List<Deck> decks=new ArrayList<>();
	List<Player> players=new ArrayList<>();
	public void getDecks() throws FileNotFoundException{
		File f=new File("Winrate.csv");
		System.out.println(f.canRead());
		Scanner scan=new Scanner(f);
		while(scan.hasNextLine()){
			String line=scan.nextLine();
			String[] values=line.split(",");
			String name=values[0];
			int id=Integer.valueOf(values[1]);
			Map<Integer,Float> map=new HashMap<>();
			Deck d=new Deck(name,map,id);
			for(int i=2;i<values.length;i++){
				map.put(i-1,Float.valueOf(values[i]));
			}
			decks.add(d);
		}
	}
	public void getPlayers() throws FileNotFoundException{
		File f=new File("Players.csv");
		f.canRead();
		Scanner scan=new Scanner(f);
		while(scan.hasNextLine()){
			String line=scan.nextLine();
			String[] values=line.split(",");
			String name=values[1];
			int id=Integer.valueOf(values[0]);
			List<Deck> decks=new LinkedList<>();
			for(int i=2;i<values.length;i++){
				decks.add(this.decks.get(Integer.valueOf(values[i])-1));
			}
			Player p=new Player(name,decks,id);
			players.add(p);
		}
	}
	public void runTournament(){
		Results r=new Results();
		SingleElim tournament=new SingleElim(players, new Conquest());
		for(int i=1;i<9;i++){
			r.setPlayerMap(i);
		}
		tournament.setResults(r);
		for(int i=0;i<100000;i++){
			tournament.processRounds();
			tournament.getResults();
			tournament.setup();
			tournament.resetHistory();
		}
		r.outputPlayerRankings();
	}
	public static void main(String[] args) throws FileNotFoundException{
		Summer s=new Summer();
		s.getDecks();
		s.getPlayers();
		s.runTournament();
	}

}
