package pl.sdacademy.springdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.sdacademy.springdemo.controllers.PlayListController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringDemoApplicationTests {

	@Autowired
	private PlayListController playListController;

	@Test
	void contextLoads() {
		assertThat(playListController).isNotNull();
	}

}
