package pl.sdacademy.springdemo.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PlayListWithSongsTest {

	private static ObjectMapper mapper = new ObjectMapper();

	private PlayListWithSongs sut = new PlayListWithSongs();

	@Test
	void shouldCreateCompleteJson() throws JsonProcessingException {
		fillPlayList();

		String json = mapper.writeValueAsString(sut);

		assertNotNull(json);

		System.out.println(json);

	}

	@Test
	void shouldCreateObjectBasedOnJson() throws JsonProcessingException {

		sut = mapper.readValue(getJsonText(), PlayListWithSongs.class);

		assertNotNull(sut);

		System.out.println(sut);
	}

	private String getJsonText() {

		return "{\n"
				+ "  \"id\": 1,\n"
				+ "  \"name\": \"Moja playlista\",\n"
				+ "  \"songs\": [\n"
				+ "    {\n"
				+ "      \"title\": \"Mój ból jest większy niż twój\",\n"
				+ "      \"artist\": {\n"
				+ "        \"firstName\": \"Kazik\",\n"
				+ "        \"lastName\": \"Staszewski\"\n"
				+ "      }\n"
				+ "    },\n"
				+ "    {\n"
				+ "      \"title\": \"Wyjechali na wakacje\",\n"
				+ "      \"artist\": {\n"
				+ "        \"firstName\": \"Kult\",\n"
				+ "        \"lastName\": null\n"
				+ "      }\n"
				+ "    }\n"
				+ "  ]\n"
				+ "}\n";
	}

	private void fillPlayList() {
		Artist artist = new Artist();
		artist.setFirstName("Kazik");
		artist.setLastName("Staszewski");

		Song song = new Song();
		song.setArtist(artist);
		song.setTitle("Mój ból jest większy niż twój");

		List<Song> songList = new ArrayList<>();
		songList.add(song);

		artist = new Artist();
		artist.setFirstName("Kult");
		song = new Song();
		song.setArtist(artist);
		song.setTitle("Wyjechali na wakacje");
		songList.add(song);

		sut.setId(1);
		sut.setName("Moja playlista");
		sut.setSongs(songList);
	}
}
