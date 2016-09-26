package ru.nektodev.abcourses.api;

import com.googlecode.jsonrpc4j.JsonRpcService;
import ru.nektodev.abcourses.api.model.HomeworkResponse;
import ru.nektodev.abcouses.model.Homework;

import java.util.List;

/**
 * @author nektodev
 * @date 26/09/2016
 */
@JsonRpcService("/homework")
public interface HomeworkFacade extends BaseFacade<Homework> {
    @Override
    Homework get(String id);

    @Override
    List<Homework> list();

    @Override
    List<Homework> merge(List<Homework> homeworks);

    @Override
    List<Homework> save(List<Homework> homeworks);

    @Override
    void delete(List<String> homeworks);

    Homework getStudentHomework(String studentId);

    Homework getStudentHomework(String studentId, Long date);

    HomeworkResponse getVocabulary(String studentId);

    HomeworkResponse getVocabulary(String studentId, Long date);

    HomeworkResponse getPronunciation(String studentId);

    HomeworkResponse getPronunciation(String studentId, Long date);
}
