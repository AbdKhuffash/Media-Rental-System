package application;

public interface MediaRentalInt {
	void addCustomer(String name, String address, String plan,int id,String mobile);
	void addMovie(String title, int NUMBER_OF_COPIES_AVAILABLE, String rating,int code);
	void addGame(String title, int NUMBER_OF_COPIES_AVAILABLE, double weight,int code);
	void addAlbum(String title ,int NUMBER_OF_COPIES_AVAILABLE,String artist, String songs,int code);
	void setLimitedPlanLimit(int value);
	String getAllCustomersInfo();
	String getAllMediaInfo();
	boolean addToCart(int id ,int code);
	boolean removeFromCart(int id,int code);
	String ProcessRequests();
	boolean returnMedia(int custid,int medcode);
}

