package application;

import java.util.ArrayList;

public class Album extends Media {
	private String artist;
	private String songs;

	public Album(String title, int NUMBER_OF_COPIES_AVAILABLE, String artist, String songs,int code) {
		super(title, NUMBER_OF_COPIES_AVAILABLE,code);
		this.artist = artist;
		this.songs = songs;
	}

	public String getArtist() {
		return artist;
	}

	public String getSongs() {
		return songs;
	}

	@Override
	public String toString() {
		return "||artist=" + artist + "||songs=" + songs;
	}

	@Override
	public String getType() {
		return "Album";
	}



}
