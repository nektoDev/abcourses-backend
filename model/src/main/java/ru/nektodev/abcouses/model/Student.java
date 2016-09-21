package ru.nektodev.abcouses.model;

import com.google.common.base.Objects;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Set;

/**
 * @author nektodev
 * @date 21/09/2016
 */
public class Student implements Serializable{

    @Id
    private String id;
    private String name;
    private Dialect dialect;
    private Set<String> words;
    private ImportParams importParams;

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("dialect", dialect)
                .add("words", words)
                .add("importParams", importParams)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equal(id, student.id) &&
                Objects.equal(name, student.name) &&
                dialect == student.dialect &&
                Objects.equal(words, student.words) &&
                Objects.equal(importParams, student.importParams);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, dialect, words, importParams);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dialect getDialect() {
        return dialect;
    }

    public void setDialect(Dialect dialect) {
        this.dialect = dialect;
    }

    public Set<String> getWords() {
        return words;
    }

    public void setWords(Set<String> words) {
        this.words = words;
    }

    public ImportParams getImportParams() {
        return importParams;
    }

    public void setImportParams(ImportParams importParams) {
        this.importParams = importParams;
    }
}
