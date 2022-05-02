package pl.sdacademy.springdemo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pl.sdacademy.springdemo.model.PlayList;
import pl.sdacademy.springdemo.service.PlayListService;

@RestController
@RequestMapping("/api/playlist")
public class PlayListController2 {

	private static final Logger LOG = LoggerFactory.getLogger(PlayListController2.class);

	private final PlayListService service;

	public PlayListController2(PlayListService service) {
		this.service = service;
	}

	@GetMapping("/{id}")
	public PlayList get(@PathVariable("id") long id) {
		LOG.info("Get - id: {}", id);
		PlayList playList = new PlayList();
		playList.setId(id);
		return playList;
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	@Secured("ROLE_PL")
	public PlayList addList(@RequestBody PlayList playList) {
		LOG.info("Add - Name: {}", playList.getName());
		return service.add(playList);
	}


	@ResponseBody
	@ResponseStatus(HttpStatus.ACCEPTED)
	@PutMapping()
	@Secured("ROLE_PL")
	public String updateList(@RequestBody PlayList playList) {
		LOG.info("Update - Name: {}", playList.getName());
		return playList.getName();
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	@Secured("ROLE_PL")
	public void delete(@PathVariable("id") long id) {
		LOG.info("Delete - Id: {}", id);
	}

}
