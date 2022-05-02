package pl.sdacademy.springdemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.sdacademy.springdemo.db.PlayListEntity;

@Repository
public interface PlayListRepository extends CrudRepository<PlayListEntity, Long> {

}
