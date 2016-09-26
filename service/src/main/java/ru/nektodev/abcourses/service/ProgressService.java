package ru.nektodev.abcourses.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nektodev.abcourses.repository.ProgressRepository;
import ru.nektodev.abcouses.model.StudentProgress;

import java.util.List;

/**
 * @author nektodev
 * @date 26/09/2016
 */
@Service
public class ProgressService {

    private static final Logger LOG = Logger.getLogger(ProgressService.class);

    @Autowired
    private ProgressRepository progressRepository;

    public List<StudentProgress> save(List<StudentProgress> studentProgressList) {
        LOG.debug("Save StudentProgressList: " + studentProgressList);
        return progressRepository.save(studentProgressList);
    }


    public StudentProgress get(String id) {
        return progressRepository.findOne(id);
    }

    public List<StudentProgress> list() {
        return progressRepository.findAll();
    }

    public StudentProgress save(StudentProgress studentProgress) {
        LOG.debug("Save StudentProgress: " + studentProgress);
        return progressRepository.save(studentProgress);
    }
}
