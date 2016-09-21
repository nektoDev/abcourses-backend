package ru.nektodev.abcourses;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author nektodev
 * @date 21/09/2016
 */
public interface WordRepository extends MongoRepository<WordRepository, String> {
}
