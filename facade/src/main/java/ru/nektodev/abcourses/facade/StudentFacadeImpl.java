package ru.nektodev.abcourses.facade;

import com.google.gson.internal.LinkedHashTreeMap;
import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nektodev.abcourses.api.StudentFacade;
import ru.nektodev.abcourses.api.model.ProgressChartResponse;
import ru.nektodev.abcourses.api.model.ProgressChartValue;
import ru.nektodev.abcourses.service.ProgressService;
import ru.nektodev.abcourses.service.StudentService;
import ru.nektodev.abcouses.model.ProgressData;
import ru.nektodev.abcouses.model.Student;
import ru.nektodev.abcouses.model.StudentProgress;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author nektodev
 * @date 21/09/2016
 */
@AutoJsonRpcServiceImpl
@Service
public class StudentFacadeImpl implements StudentFacade {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ProgressService progressService;

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

    @Override
    public StudentProgress getProgress(String student) {
        return progressService.get(student);
    }

    @Override
    public ProgressChartResponse getProgressChart(String student) {
        StudentProgress studentProgress = progressService.get(student);

        Map<Date, ProgressChartValue> progressDateValuesMap = new LinkedHashTreeMap<>();

        for (ProgressData progressData : studentProgress.getPronunciation()) {
            ProgressChartValue chartValue = progressDateValuesMap.getOrDefault(progressData.getDate(), new ProgressChartValue());
            chartValue.setPronunciation(progressData.getValue());
            progressDateValuesMap.putIfAbsent(progressData.getDate(), chartValue);
        }

        for (ProgressData progressData : studentProgress.getVocabulary()) {
            ProgressChartValue chartValue = progressDateValuesMap.getOrDefault(progressData.getDate(), new ProgressChartValue());
            chartValue.setVocabulary(progressData.getValue());
            progressDateValuesMap.putIfAbsent(progressData.getDate(), chartValue);
        }

        for (ProgressData progressData : studentProgress.getTest()) {
            ProgressChartValue chartValue = progressDateValuesMap.getOrDefault(progressData.getDate(), new ProgressChartValue());
            chartValue.setTest(progressData.getValue());
            progressDateValuesMap.putIfAbsent(progressData.getDate(), chartValue);
        }

        ProgressChartResponse response = new ProgressChartResponse();
        response.setProgressDateValuesMap(progressDateValuesMap);

        return response;
    }
}
