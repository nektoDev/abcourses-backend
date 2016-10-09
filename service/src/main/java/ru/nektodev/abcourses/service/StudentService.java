package ru.nektodev.abcourses.service;

import com.google.common.collect.Sets;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nektodev.abcourses.repository.StudentRepository;
import ru.nektodev.abcouses.model.*;
import ru.nektodev.abcouses.model.exception.NoSuchStudentException;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author nektodev
 * @date 21/09/2016
 */
@Service
public class StudentService {

    private static final Logger LOG = Logger.getLogger(StudentService.class);

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private HomeworkService homeworkService;
    @Autowired
    private ProgressService progressService;
    @Autowired
    private WordService wordService;

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

    public void delete(List<String> students) {
        students.forEach(s -> studentRepository.delete(s));
    }


    public StudentStatistics getStudentStatistics(String studentId) {
        StudentStatistics result = new StudentStatistics();

        Student student = studentRepository.findOne(studentId);
        if (student == null) throw new NoSuchStudentException("No student with id=" + studentId);

        result.setStudent(student.getId());

        result.setWordsCount(student.getWords().size());
        result.setUniqueWordsCount(getUniqueWordsCount(student.getWords()));
        List<Homework> homeworks = homeworkService.listStudentHomeworks(student.getId());
        result.setHomeworksCount(homeworks.size());
        result.setAvgPronunciationWordsCount(homeworks.stream()
                .map(Homework::getPronunciation)
                .map(List::size)
                .collect(Collectors.averagingDouble(Double::new))
                .toString());
        result.setAvgVocabularyWordsCount(homeworks.stream()
                .map(Homework::getVocabulary)
                .map(List::size)
                .collect(Collectors.averagingDouble(Double::new))
                .toString());

        result.setMostFrequentWords(wordService.getWordsByStudent(student.getId()).stream()
                .sorted((o1, o2) -> o2.getCountUses().get(student.getId()).compareTo(o1.getCountUses().get(student.getId())))
                .limit(10)
                .collect(Collectors.toList()));

        StudentProgress progress = progressService.get(student.getId());
        Set<Date> vocabularyTop = progress.getVocabulary().stream()
                .filter(progressData -> progressData.getValue() == 100)
                .map(ProgressData::getDate)
                .collect(Collectors.toSet());
        Set<Date> pronunciationTop = progress.getPronunciation().stream()
                .filter(progressData -> progressData.getValue() == 100)
                .map(ProgressData::getDate)
                .collect(Collectors.toSet());

        result.setTestCount(progress.getTest().size());
        result.setTopScoreCount(Sets.intersection(vocabularyTop, pronunciationTop).size());
        result.setTopVocabularyCount(vocabularyTop.size());
        result.setTopPronunciationCount(pronunciationTop.size());

        result.setAvgVocabularyScore(progress.getVocabulary().stream()
                .map(ProgressData::getValue)
                .collect(Collectors.averagingDouble(Double::new))
                .toString());
        result.setAvgPronunciationScore(progress.getPronunciation().stream()
                .map(ProgressData::getValue)
                .collect(Collectors.averagingDouble(Double::new))
                .toString());
        result.setAvgTestScore(progress.getTest().stream()
                .map(ProgressData::getValue)
                .collect(Collectors.averagingDouble(Double::new))
                .toString());

        return result;
    }

    private Integer getUniqueWordsCount(Collection<String> words) {
        Set<String> uniqueWords = new HashSet<>();
        for (String word : words) {
            word = word.replaceAll(" |,|\\.|;", "");
            if (word.contains(" ")) {
                Collections.addAll(uniqueWords, word.split(" "));
            }
        }

        return uniqueWords.size();
    }
}