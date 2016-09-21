package ru.nektodev.abcourses;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.nektodev.abcouses.model.Student;

/**
 * @author nektodev
 * @date 21/09/2016
 */

public interface StudentRepository extends MongoRepository<Student, String> {

}
