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
    private List<ProgressData> grammar;

    public ParsedProgressData() {
        this.vocabulary = new ArrayList<>();
        this.pronunciation = new ArrayList<>();
        this.test = new ArrayList<>();
        this.grammar = new ArrayList<>();
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

    public void addGrammarIfNotNull(ProgressData pd) {
        if (pd != null) {
            this.grammar.add(pd);
        }
    }

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
        ParsedProgressData that = (ParsedProgressData) o;
        return Objects.equal(vocabulary, that.vocabulary) &&
                Objects.equal(pronunciation, that.pronunciation) &&
                Objects.equal(grammar, that.grammar) &&
                Objects.equal(test, that.test);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(vocabulary, pronunciation, test, grammar);
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

    public List<ProgressData> getGrammar() {
        return grammar;
    }

    public void setGrammar(List<ProgressData> grammar) {
        this.grammar = grammar;
    }
}
