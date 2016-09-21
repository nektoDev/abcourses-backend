package ru.nektodev.abcourses;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.nektodev.abcouses.model.Homework;

/**
 * @author nektodev
 * @date 21/09/2016
 */
public interface HomeworkRepository extends MongoRepository<Homework, String> {
}