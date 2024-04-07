package application;

public class Game extends Media {
private double weight;

	public Game(String title, int NUMBER_OF_COPIES_AVAILABLE, double weight,int code) {
		super(title, NUMBER_OF_COPIES_AVAILABLE,code);
		this.weight = weight;
	}
	

	public double getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "||weight=" + weight;
	}





	@Override
	public String getType(){
		return "Game";
	}


	
}
