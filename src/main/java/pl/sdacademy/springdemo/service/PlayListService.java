package pl.sdacademy.springdemo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import pl.sdacademy.springdemo.db.PlayListEntity;
import pl.sdacademy.springdemo.model.PlayList;
import pl.sdacademy.springdemo.repository.PlayListRepository;

@Service
@Validated
public class PlayListService {

	private final PlayListRepository repository;

	public PlayListService(PlayListRepository repository) {
		this.repository = repository;
	}

	@Transactional
	public PlayList add(@Valid @NotNull PlayList playList) {
		// tutaj zwykle wykorzystywana dedykowana klasa
		PlayListEntity entity = new PlayListEntity();
		entity.setName(playList.getName());

		entity = repository.save(entity);

		// podobnie w tym miejscu
		PlayList result = new PlayList();
		result.setId(entity.getId());
		result.setName(entity.getName());
		return result;
	}
}
