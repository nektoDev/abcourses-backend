package ru.nektodev.abcourses.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.nektodev.abcourses.repository.HomeworkRepository;
import ru.nektodev.abcouses.model.Homework;
import ru.nektodev.abcouses.model.HomeworkWord;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;
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

    @Autowired
    private WordService wordService;

    public List<Homework> save(List<Homework> homeworks) {
        homeworks.forEach(h -> h.setDate(truncateDate(h.getDate())));
        LOG.debug("Save Homeworks: " + homeworks);
        return homeworkRepository.save(homeworks);
    }

    public Homework save(Homework homework) {
        LOG.debug("Save Homework: " + homework);
        homework.setDate(truncateDate(homework.getDate()));
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

    public void delete(List<String> homeworks) {
        homeworks.forEach(h -> homeworkRepository.delete(h));
    }

    public Homework getStudentHomework(String studentId, Date date) {
        if (date == null) {
            return homeworkRepository.findByStudentId(studentId, new Sort(Sort.Direction.DESC, "date"));
        }
        return homeworkRepository.findByStudentIdAndDate(studentId, truncateDate(date));
    }

    public List<HomeworkWord> enrichHomeworkWords(List<HomeworkWord> words) {
        words.forEach((w) -> w.setWordData(wordService.get(w.getWordId())));
        return words;
    }


    private Date truncateDate(Date date) {
        return Date.from(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().atStartOfDay().toInstant(ZoneOffset.UTC));
    }
}
