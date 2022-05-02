package pl.sdacademy.springdemo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.validation.ConstraintViolationException;

import pl.sdacademy.springdemo.repository.PlayListRepository;

@SpringBootTest
class PlayListServiceIntegrationTest {

	@MockBean
	private PlayListRepository repository;

	@Autowired
	private PlayListService sut;

	@Test
	void shouldMarkAsInvalidNullPlayList() {

		try {
			sut.add(null);
			fail("should be exceptio");
		} catch (ConstraintViolationException e) {
			assertThat(e.getMessage()).contains("nie może mieć wartości null");
		}
	}
}
