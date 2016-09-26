package ru.nektodev.abcouses.model;

import com.google.common.base.Objects;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author nektodev
 * @date 26/09/2016
 */
public class StudentProgress implements Serializable {

    @Id
    private String studentId;
    private List<ProgressData> vocabulary;
    private List<ProgressData> pronunciation;
    private List<ProgressData> test;
    private Date updateDate;

    public StudentProgress(String studentId, List<ProgressData> vocabulary, List<ProgressData> pronunciation, List<ProgressData> test, Date updateDate) {
        this.studentId = studentId;
        this.vocabulary = vocabulary;
        this.pronunciation = pronunciation;
        this.test = test;
        this.updateDate = updateDate;
    }

    public StudentProgress(String studentId, ParsedProgressData parsedData, Date updateDate) {
        this.studentId = studentId;
        this.vocabulary = parsedData.getVocabulary();
        this.pronunciation = parsedData.getPronunciation();
        this.test = parsedData.getTest();
        this.updateDate = updateDate;
    }


    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("studentId", studentId)
                .add("vocabulary", vocabulary)
                .add("pronunciation", pronunciation)
                .add("test", test)
                .add("updateDate", updateDate)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentProgress that = (StudentProgress) o;
        return Objects.equal(studentId, that.studentId) &&
                Objects.equal(vocabulary, that.vocabulary) &&
                Objects.equal(pronunciation, that.pronunciation) &&
                Objects.equal(test, that.test) &&
                Objects.equal(updateDate, that.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(studentId, vocabulary, pronunciation, test, updateDate);
    }

    public List<ProgressData> getPronunciation() {

        return pronunciation;
    }

    public void setPronunciation(List<ProgressData> pronunciation) {
        this.pronunciation = pronunciation;
    }

    public List<ProgressData> getTest() {
        return test;
    }

    public void setTest(List<ProgressData> test) {
        this.test = test;
    }

    public String getStudentId() {

        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public List<ProgressData> getVocabulary() {
        return vocabulary;
    }

    public void setVocabulary(List<ProgressData> vocabulary) {
        this.vocabulary = vocabulary;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
