package ru.nektodev.abcourses.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.nektodev.abcouses.model.UsefulLink;

/**
 * @author nektodev
 * @date 28/09/2016
 */
public interface UsefulLinksRepository extends MongoRepository<UsefulLink, String> {

}
