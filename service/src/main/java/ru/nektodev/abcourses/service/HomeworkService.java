package ru.nektodev.abcourses.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nektodev.abcourses.HomeworkRepository;
import ru.nektodev.abcouses.model.Homework;

import java.util.List;

/**
 * @author nektodev
 * @date 22/09/2016
 */
@Service
public class HomeworkService {

    private static final Logger LOG = Logger.getLogger(HomeworkService.class);

    @Autowired
    private HomeworkRepository homeworkRepository;

    public List<Homework> save(List<Homework> homeworks) {
        LOG.debug("Save Homeworks: " + homeworks);
        return homeworkRepository.save(homeworks);
    }

    public Homework save(Homework homework) {
        LOG.debug("Save Homework: " + homework);
        return homeworkRepository.save(homework);
    }

    public List<Homework> merge(List<Homework> homeworks) {
        //TODO implement data merge
        return homeworkRepository.save(homeworks);
    }


    public Homework get(String id) {
        return homeworkRepository.findOne(id);
    }

    public Homework getByHashAndStudent(String hash, String studentId) {
        return homeworkRepository.findByFileHashAndStudentId(hash, studentId);
    }

    public boolean isHomeworkExist(String hash, String studentId) {
        return homeworkRepository.findByFileHashAndStudentId(hash, studentId) != null;
    }

    public List<Homework> list() {
        return homeworkRepository.findAll();
    }

}
