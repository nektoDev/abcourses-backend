package ru.nektodev.abcouses.model;

import com.google.common.base.Objects;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author nektodev
 * @date 21/09/2016
 */
public class Word implements Serializable {

    @Id
    private String id;
    private Map<Dialect, String> pronunciations;
    private Set<String> translations;
    private Map<String, Integer> countUses;     //student->count uses
    private Map<String, Date> firstAppeared;    //student->first appeared date
    private Map<String, Date> lastUsed;         //student->last used date

    public Word() {
    }

    public Word(String student) {
        this.firstAppeared = new HashMap<>();
        Date date = new Date();
        this.firstAppeared.put(student, date);

        this.lastUsed = new HashMap<>();
        this.lastUsed.put(student, date);

        this.countUses = new HashMap<>();
        this.countUses.put(student, 1);
    }

    public Word(String student, String id) {
        this(student);
        this.id = id;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id='" + id + '\'' +
                ", pronunciations=" + pronunciations +
                ", translations=" + translations +
                ", countUses=" + countUses +
                ", firstAppeared=" + firstAppeared +
                ", lastUsed=" + lastUsed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Objects.equal(id, word.id) &&
                Objects.equal(pronunciations, word.pronunciations) &&
                Objects.equal(translations, word.translations) &&
                Objects.equal(countUses, word.countUses) &&
                Objects.equal(firstAppeared, word.firstAppeared) &&
                Objects.equal(lastUsed, word.lastUsed);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, pronunciations, translations, countUses, firstAppeared, lastUsed);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<Dialect, String> getPronunciations() {
        return pronunciations;
    }

    public void setPronunciations(Map<Dialect, String> pronunciations) {
        this.pronunciations = pronunciations;
    }

    public Set<String> getTranslations() {
        return translations;
    }

    public void setTranslations(Set<String> translations) {
        this.translations = translations;
    }

    public Map<String, Integer> getCountUses() {
        return countUses;
    }

    public void setCountUses(Map<String, Integer> countUses) {
        this.countUses = countUses;
    }

    public Map<String, Date> getFirstAppeared() {
        return firstAppeared;
    }

    public void setFirstAppeared(Map<String, Date> firstAppeared) {
        this.firstAppeared = firstAppeared;
    }

    public Map<String, Date> getLastUsed() {
        return lastUsed;
    }

    public void setLastUsed(Map<String, Date> lastUsed) {
        this.lastUsed = lastUsed;
    }
}
