package ru.nektodev.abcourses.api.model;

import com.google.common.base.Objects;
import ru.nektodev.abcouses.model.HomeworkWord;

import java.util.Date;
import java.util.List;

/**
 * @author nektodev
 * @date 26/09/2016
 */
public class HomeworkResponse {
    private Date date;
    private List<HomeworkWord> words;

    public HomeworkResponse() {
    }

    public HomeworkResponse(Date date, List<HomeworkWord> words) {
        this.date = date;
        this.words = words;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("date", date)
                .add("words", words)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeworkResponse that = (HomeworkResponse) o;
        return Objects.equal(date, that.date) &&
                Objects.equal(words, that.words);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(date, words);
    }

    public Date getDate() {

        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<HomeworkWord> getWords() {
        return words;
    }

    public void setWords(List<HomeworkWord> words) {
        this.words = words;
    }
}
