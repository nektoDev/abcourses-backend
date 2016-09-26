package ru.nektodev.abcourses.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.nektodev.abcouses.model.StudentProgress;

/**
 * @author nektodev
 * @date 26/09/2016
 */
public interface ProgressRepository extends MongoRepository<StudentProgress, String> {
}
