package ru.nektodev.abcourses.service;

import com.yandex.disk.rest.exceptions.ServerException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nektodev.abcourses.importer.HomeworkParser;
import ru.nektodev.abcourses.importer.ProgressParserFactory;
import ru.nektodev.abcourses.importer.YandexDownloader;
import ru.nektodev.abcourses.utils.FileUtils;
import ru.nektodev.abcouses.model.*;
import ru.nektodev.abcouses.model.exception.NoSuchStudentException;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author nektodev
 * @date 22/09/2016
 */
@Service
public class ImportService {

    private static final Logger LOG = Logger.getLogger(ImportService.class);

    @Autowired
    private StudentService studentService;

    @Autowired
    private WordService wordService;

    @Autowired
    private HomeworkService homeworkService;

    @Autowired
    private ProgressService progressService;

    @Autowired
    private YandexDownloader downloader;

    private final ProgressParserFactory parserFactory;

    public ImportService() {
        parserFactory = new ProgressParserFactory();
    }

    public void doImport() {
        studentService.list().forEach(s -> doImport(s.getId()));
    }

    public void doImport(String studentId) {
        Student student = getStudent(studentId);

        try {
            File zipHomeworkDirectory = downloader.downloadFile(student.getImportParams().getPublicKey(), student.getImportParams().getHomeworkPath());
            File pronunciationFile = downloader.downloadFile(student.getImportParams().getPublicKey(), student.getImportParams().getAbsolutePronunciationPath());
            File vocabularyFile = downloader.downloadFile(student.getImportParams().getPublicKey(), student.getImportParams().getAbsoluteVocabularyPath());

            String hash = FileUtils.calculateFileHash(pronunciationFile) + FileUtils.calculateFileHash(vocabularyFile);

            if (homeworkService.isHomeworkExist(hash, student.getId())) {
                LOG.debug(String.format("%s's homework %s has already been imported.", student.getId(), hash));
                return;
            }

            Homework homework = new Homework();
            homework.setDate(new Date());
            homework.setFileHash(hash);
            homework.setStudentId(student.getId());

            homework.setPronunciation(importPronunciation(student, pronunciationFile));
            homework.setVocabulary(importVocabulary(student, vocabularyFile));

            homeworkService.save(homework);
        } catch (IOException | ServerException | NoSuchAlgorithmException e) {
            LOG.error(e);
            e.printStackTrace();
        }
    }

    public void doImportProgress() {
        studentService.list().forEach(s -> doImportProgress(s.getId()));
    }

    public void doImportProgress(String studentId) {
        Student student = getStudent(studentId);
        try {
            ProgressImportParams progressImportParams = student.getImportParams().getProgressImportParams();
            File progressFile = downloader.downloadFile(student.getImportParams().getPublicKey(),
                    progressImportParams.getProgressPath());

            ParsedProgressData parsedProgressData = this.parserFactory.getParser(progressImportParams).doParse(progressFile);
            StudentProgress studentProgress = new StudentProgress(student.getId(), parsedProgressData, new Date());

            progressService.save(studentProgress);
        } catch (IOException | ServerException e) {
            LOG.error("Cannot import progress for student: " + student.getId(), e);
            e.printStackTrace();
        }
    }

    private Student getStudent(String studentId) {
        Student student = studentService.get(studentId);
        if (student == null) {
            throw new NoSuchStudentException("No student with id = " + studentId + " was found.");
        }
        return student;
    }

    private List<HomeworkWord> importPronunciation(Student student, File pronunciationFile) throws IOException {
        Map<String, String> questionAnswerMap = HomeworkParser.doParse(pronunciationFile);
        List<HomeworkWord> pronunciation = new ArrayList<>();

        questionAnswerMap.forEach((question, answer) -> {
            Word word = wordService.getOrCreateWord(question, student.getId(), new Date());
            word.getPronunciations().put(student.getDialect(), answer);

            pronunciation.add(createHomeworkWord(pronunciation.size(), question, answer, word.getId()));
            student.getWords().add(word.getId());

            wordService.save(word);
        });
        studentService.save(student);
        return pronunciation;
    }

    private List<HomeworkWord> importVocabulary(Student student, File vocabularyFile) throws IOException {
        Map<String, String> questionAnswerMap = HomeworkParser.doParse(vocabularyFile);
        List<HomeworkWord> vocabulary = new ArrayList<>();

        questionAnswerMap.forEach((question, answer) -> {
            Word word = wordService.getOrCreateWord(answer, student.getId(), new Date());
            word.getTranslations().add(question);

            vocabulary.add(createHomeworkWord(vocabulary.size(), question, answer, word.getId()));
            student.getWords().add(word.getId());

            wordService.save(word);
        });
        studentService.save(student);
        return vocabulary;
    }

    private HomeworkWord createHomeworkWord(Integer id, String question, String answer, String wordId) {
        HomeworkWord word = new HomeworkWord();

        word.setId(id);
        word.setAnswer(answer);
        word.setQuestion(question);
        word.setWordId(wordId);
        return word;
    }
}
