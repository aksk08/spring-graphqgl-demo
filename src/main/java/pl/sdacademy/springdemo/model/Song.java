package pl.sdacademy.springdemo.model;

public class Song {

	private String title;
	private Artist artist;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	@Override
	public String toString() {
		return "Song{" +
				"title='" + title + '\'' +
				", artist=" + artist +
				'}';
	}
}
