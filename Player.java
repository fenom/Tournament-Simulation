public class Player{
	public String name;
	public int[] decks;
	public double[][] winMatrix;
	Player(String name, int[] decks, double[][] matrix){
		this.name=name;
		this.decks=decks;
		winMatrix=matrix;
	}


}
