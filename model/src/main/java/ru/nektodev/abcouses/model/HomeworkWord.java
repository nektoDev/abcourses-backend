package ru.nektodev.abcouses.model;

import com.google.common.base.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;

/**
 * @author nektodev
 * @date 21/09/2016
 */
public class HomeworkWord implements Serializable {
    @Id
    private Integer id;
    private String question;
    private String answer;
    private String wordId;
    @Transient
    private Word wordData;

    public HomeworkWord() {
    }

    public HomeworkWord(Integer id, String question, String answer, String wordId) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.wordId = wordId;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("question", question)
                .add("answer", answer)
                .add("wordId", wordId)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeworkWord that = (HomeworkWord) o;
        return Objects.equal(id, that.id) &&
                Objects.equal(question, that.question) &&
                Objects.equal(answer, that.answer) &&
                Objects.equal(wordId, that.wordId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, question, answer, wordId);
    }

    public String getQuestion() {

        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getWordId() {
        return wordId;
    }

    public void setWordId(String wordId) {
        this.wordId = wordId;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Word getWordData() {
        return wordData;
    }

    public void setWordData(Word wordData) {
        this.wordData = wordData;
    }
}
