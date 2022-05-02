package pl.sdacademy.springdemo.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PlayList {
	protected long id;
	@NotNull(message = "Name must be set")
	@NotEmpty(message = "Name cannot be empty")
	protected String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
