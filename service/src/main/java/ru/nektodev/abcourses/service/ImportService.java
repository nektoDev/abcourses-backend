package ru.nektodev.abcourses.service;

import com.yandex.disk.rest.exceptions.ServerException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nektodev.abcourses.importer.YandexDownloader;
import ru.nektodev.abcouses.model.Student;
import ru.nektodev.abcouses.model.exception.NoSuchStudentException;

import java.io.File;
import java.io.IOException;

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
    private YandexDownloader downloader;

    public void doImport() {
        studentService.list().forEach(s -> doImport(s.getId()));
    }

    public void doImport(String studentId) {
        Student student = studentService.get(studentId);
        if (student == null) {
            throw new NoSuchStudentException("No student with id = " + studentId + " was found.");
        }

        try {
            File file = downloader.downloadFile(student.getImportParams().getPublicKey(), student.getImportParams().getHomeworkPath());
            File file2 = downloader.downloadFile(student.getImportParams().getPublicKey(), student.getImportParams().getAbsolutePronunciationPath());
            File file3 = downloader.downloadFile(student.getImportParams().getPublicKey(), student.getImportParams().getAbsoluteVocabularyPath());
        } catch (IOException | ServerException e) {
            LOG.error(e);
            e.printStackTrace();
        }
    }
}
