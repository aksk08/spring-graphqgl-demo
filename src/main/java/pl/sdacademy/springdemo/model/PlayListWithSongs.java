package pl.sdacademy.springdemo.model;

import java.util.List;

public class PlayListWithSongs extends PlayList {

	private List<Song> songs;

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	@Override
	public String toString() {
		return "PlayListWithSongs{" +
				"songs=" + songs + '\'' +
				", name=" + name + '\'' +
				", id=" + id +
				'}';
	}
}
