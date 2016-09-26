package ru.nektodev.abcourses.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.nektodev.abcouses.model.Word;

/**
 * @author nektodev
 * @date 21/09/2016
 */
public interface WordRepository extends MongoRepository<Word, String> {
}
