package ru.nektodev.abcouses.model;

import com.google.common.base.Objects;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author nektodev
 * @date 21/09/2016
 */
public class Homework implements Serializable{
    @Id
    private String id;
    private String studentId;
    private Date date;
    private String fileHash;
    private List<HomeworkWord> vocabulary;
    private List<HomeworkWord> pronunciation;

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("studentId", studentId)
                .add("date", date)
                .add("fileHash", fileHash)
                .add("vocabulary", vocabulary)
                .add("pronunciation", pronunciation)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Homework homework = (Homework) o;
        return Objects.equal(id, homework.id) &&
                Objects.equal(studentId, homework.studentId) &&
                Objects.equal(date, homework.date) &&
                Objects.equal(fileHash, homework.fileHash) &&
                Objects.equal(vocabulary, homework.vocabulary) &&
                Objects.equal(pronunciation, homework.pronunciation);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, studentId, date, fileHash, vocabulary, pronunciation);
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFileHash() {
        return fileHash;
    }

    public void setFileHash(String fileHash) {
        this.fileHash = fileHash;
    }

    public List<HomeworkWord> getVocabulary() {
        return vocabulary;
    }

    public void setVocabulary(List<HomeworkWord> vocabulary) {
        this.vocabulary = vocabulary;
    }

    public List<HomeworkWord> getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(List<HomeworkWord> pronunciation) {
        this.pronunciation = pronunciation;
    }
}
