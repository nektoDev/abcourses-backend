package ru.nektodev.abcourses.api.model;

import com.google.common.base.Objects;

/**
 * @author nektodev
 * @date 03/10/2016
 */
public class ProgressChartValue {
    private Integer vocabulary;
    private Integer pronunciation;
    private Integer test;
    private Integer grammar;

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("vocabulary", vocabulary)
                .add("pronunciation", pronunciation)
                .add("test", test)
                .add("grammar", grammar)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProgressChartValue that = (ProgressChartValue) o;
        return Objects.equal(vocabulary, that.vocabulary) &&
                Objects.equal(pronunciation, that.pronunciation) &&
                Objects.equal(grammar, that.grammar) &&
                Objects.equal(test, that.test);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(vocabulary, pronunciation, test, grammar);
    }

    public Integer getVocabulary() {
        return vocabulary;
    }

    public void setVocabulary(Integer vocabulary) {
        this.vocabulary = vocabulary;
    }

    public Integer getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(Integer pronunciation) {
        this.pronunciation = pronunciation;
    }

    public Integer getTest() {
        return test;
    }

    public void setTest(Integer test) {
        this.test = test;
    }

    public Integer getGrammar() {
        return grammar;
    }

    public void setGrammar(Integer grammar) {
        this.grammar = grammar;
    }
}
