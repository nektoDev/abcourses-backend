package ru.nektodev.abcourses.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import ru.nektodev.abcouses.model.Homework;

import java.util.Date;
import java.util.List;

/**
 * @author nektodev
 * @date 21/09/2016
 */
public interface HomeworkRepository extends MongoRepository<Homework, String> {

    public Homework findByFileHashAndStudentId(String fileHash, String studentId);

    Homework findByStudentId(String studentId, Sort sort);
    Homework findByStudentIdAndDate(String studentId, Date date);

    List<Homework> findAllByStudentId(String studentId);
}
