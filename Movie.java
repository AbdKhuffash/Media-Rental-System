package application;


public class Movie extends Media{
	private String rating;

	public Movie(String title, int NUMBER_OF_COPIES_AVAILABLE, String rating,int code) {
		super(title, NUMBER_OF_COPIES_AVAILABLE,code);
		this.rating = rating;
	}
	public String getRating() {
		return rating;
	}


	@Override
	public String toString() {
		return "||rating=" + rating;
	}
	@Override
	public String getType(){
		return "Movie";
	}

	
}

