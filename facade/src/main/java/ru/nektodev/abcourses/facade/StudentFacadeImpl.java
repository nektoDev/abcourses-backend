package ru.nektodev.abcourses.facade;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nektodev.abcourses.api.StudentFacade;
import ru.nektodev.abcourses.service.StudentService;
import ru.nektodev.abcouses.model.Student;

import java.util.List;

/**
 * @author nektodev
 * @date 21/09/2016
 */
@AutoJsonRpcServiceImpl
@Service
public class StudentFacadeImpl implements StudentFacade {

    @Autowired
    private StudentService studentService;

    @Override
    public Student get(String id) {
        return studentService.get(id);
    }

    @Override
    public List<Student> list() {
        return studentService.list();
    }

    @Override
    public List<Student> merge(List<Student> students) {
        return studentService.merge(students);
    }

    @Override
    public List<Student> save(List<Student> students) {
        return studentService.save(students);
    }

    @Override
    public void delete(List<String> students) {
        studentService.delete(students);
    }
}
