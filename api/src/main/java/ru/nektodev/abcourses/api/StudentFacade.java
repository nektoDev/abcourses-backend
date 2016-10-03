package ru.nektodev.abcourses.api;

import com.googlecode.jsonrpc4j.JsonRpcService;
import ru.nektodev.abcourses.api.model.ProgressChartResponse;
import ru.nektodev.abcouses.model.Student;
import ru.nektodev.abcouses.model.StudentProgress;

import java.util.List;

/**
 * @author nektodev
 * @date 21/09/2016
 */
@JsonRpcService("/student")
public interface StudentFacade extends BaseFacade<Student> {

    @Override
    Student get(String id);

    @Override
    List<Student> list();

    @Override
    List<Student> merge(List<Student> students);

    @Override
    List<Student> save(List<Student> students);

    @Override
    void delete(List<String> students);

    StudentProgress getProgress(String student);

    ProgressChartResponse getProgressChart(String student);
}
