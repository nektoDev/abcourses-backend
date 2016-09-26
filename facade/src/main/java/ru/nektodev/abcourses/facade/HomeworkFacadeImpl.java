package ru.nektodev.abcourses.facade;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nektodev.abcourses.api.HomeworkFacade;
import ru.nektodev.abcourses.api.model.HomeworkResponse;
import ru.nektodev.abcourses.service.HomeworkService;
import ru.nektodev.abcouses.model.Homework;

import java.util.Date;
import java.util.List;

/**
 * @author nektodev
 * @date 26/09/2016
 */
@Service
@AutoJsonRpcServiceImpl
public class HomeworkFacadeImpl implements HomeworkFacade {

    @Autowired
    private HomeworkService homeworkService;

    @Override
    public Homework get(String id) {
        return homeworkService.get(id);
    }

    @Override
    public List<Homework> list() {
        return homeworkService.list();
    }

    public List<Homework> merge(List<Homework> homeworks) {
        return homeworkService.merge(homeworks);
    }

    @Override
    public List<Homework> save(List<Homework> homeworks) {
        return homeworkService.save(homeworks);
    }

    @Override
    public void delete(List<String> homeworks) {
        homeworkService.delete(homeworks);
    }

    @Override
    public Homework getStudentHomework(String studentId) {
        return homeworkService.getStudentHomework(studentId, null);
    }

    @Override
    public Homework getStudentHomework(String studentId, Long date) {
        return homeworkService.getStudentHomework(studentId, new Date(date));
    }

    @Override
    public HomeworkResponse getVocabulary(String studentId) {
        Homework studentHomework = homeworkService.getStudentHomework(studentId, null);
        return new HomeworkResponse(studentHomework.getDate(), studentHomework.getVocabulary());
    }

    @Override
    public HomeworkResponse getVocabulary(String studentId, Long date) {
        Homework studentHomework = homeworkService.getStudentHomework(studentId, new Date(date));
        return new HomeworkResponse(studentHomework.getDate(), studentHomework.getVocabulary());
    }

    @Override
    public HomeworkResponse getPronunciation(String studentId) {
        Homework studentHomework = homeworkService.getStudentHomework(studentId, null);
        return new HomeworkResponse(studentHomework.getDate(), studentHomework.getPronunciation());
    }

    @Override
    public HomeworkResponse getPronunciation(String studentId, Long date) {
        Homework studentHomework = homeworkService.getStudentHomework(studentId, new Date(date));
        return new HomeworkResponse(studentHomework.getDate(), studentHomework.getPronunciation());
    }
}
