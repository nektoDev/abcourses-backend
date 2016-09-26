package ru.nektodev.abcouses.model;

import com.google.common.base.Objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nektodev
 * @date 26/09/2016
 */
public class ParsedProgressData implements Serializable {

    private List<ProgressData> vocabulary;
    private List<ProgressData> pronunciation;
    private List<ProgressData> test;

    public ParsedProgressData() {
        this.vocabulary = new ArrayList<>();
        this.pronunciation = new ArrayList<>();
        this.test = new ArrayList<>();
    }

    public void addVocabularyIfNotNull(ProgressData pd) {
        if (pd != null) {
            this.vocabulary.add(pd);
        }
    }

    public void addPronunciationIfNotNull(ProgressData pd) {
        if (pd != null) {
            this.pronunciation.add(pd);
        }
    }

    public void addTestIfNotNull(ProgressData pd) {
        if (pd != null) {
            this.test.add(pd);
        }
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("vocabulary", vocabulary)
                .add("pronunciation", pronunciation)
                .add("test", test)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParsedProgressData that = (ParsedProgressData) o;
        return Objects.equal(vocabulary, that.vocabulary) &&
                Objects.equal(pronunciation, that.pronunciation) &&
                Objects.equal(test, that.test);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(vocabulary, pronunciation, test);
    }

    public List<ProgressData> getVocabulary() {

        return vocabulary;
    }

    public void setVocabulary(List<ProgressData> vocabulary) {
        this.vocabulary = vocabulary;
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
}
