package pl.sdacademy.springdemo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Configuration
@ConfigurationProperties(prefix = "playlist")
@Validated
public class PlayListProperty {

	@NotNull(message = "Uzupełnić nameTemplate")
	private String nameTemplate;

	public String getNameTemplate() {
		return nameTemplate;
	}

	public void setNameTemplate(String nameTemplate) {
		this.nameTemplate = nameTemplate;
	}
}
