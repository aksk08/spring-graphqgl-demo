package pl.sdacademy.springdemo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pl.sdacademy.springdemo.model.PlayList;

@RestController
@RequestMapping("/api")
public class PlayListController {

	private static final Logger LOG = LoggerFactory.getLogger(PlayListController.class);

	@GetMapping("/test")
	public String test() {
		return "OK";
	}

	// można zaremować i też będzie działać :)
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/addlist")
	public String addList(@RequestBody PlayList playList) {
		LOG.info("Name: {}", playList.getName());
		return playList.getName();
	}
}
