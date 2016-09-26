package ru.nektodev.abcourses.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nektodev.abcourses.repository.StudentRepository;
import ru.nektodev.abcouses.model.Student;

import java.util.List;

/**
 * @author nektodev
 * @date 21/09/2016
 */
@Service
public class StudentService {

    private static final Logger LOG = Logger.getLogger(StudentService.class);

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> save(List<Student> students) {
        LOG.debug("Save students: " + students);
        return studentRepository.save(students);
    }

    public List<Student> merge(List<Student> students) {
        //TODO implement data merge
        return studentRepository.save(students);
    }


    public Student get(String id) {
        return studentRepository.findOne(id);
    }

    public List<Student> list() {
        return studentRepository.findAll();
    }

    public Student save(Student student) {
        LOG.debug("Save student: " + student);
        return studentRepository.save(student);
    }
}