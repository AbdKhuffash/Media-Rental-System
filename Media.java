package application;


public abstract class Media implements Comparable<Media>{
	protected String title;
	protected int NUMBER_OF_COPIES_AVAILABLE;
	protected int code;

	public Media(String title, int NUMBER_OF_COPIES_AVAILABLE,int code) {
		this.title = title;
		this.NUMBER_OF_COPIES_AVAILABLE = NUMBER_OF_COPIES_AVAILABLE;
		this.code=code;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNUMBER_OF_COPIES_AVAILABLE() {
		return NUMBER_OF_COPIES_AVAILABLE;
	}

	public void setNUMBER_OF_COPIES_AVAILABLE(int nUMBER_OF_COPIES_AVAILABLE) {
		NUMBER_OF_COPIES_AVAILABLE = nUMBER_OF_COPIES_AVAILABLE;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@Override
	public int compareTo(Media o) {
		return this.title.compareTo(o.title);
	}

	public abstract String getType();
	
	
	public boolean equals(Media o) {
		return this.title.equals(o.title);
		
	}

}
