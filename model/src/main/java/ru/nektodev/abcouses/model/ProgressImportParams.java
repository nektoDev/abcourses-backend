package ru.nektodev.abcouses.model;

import com.google.common.base.Objects;

import java.io.Serializable;

/**
 * @author nektodev
 * @date 26/09/2016
 */
public class ProgressImportParams implements Serializable {
    private String progressPath;
    private ProgressType type;
    private Integer dateColumn;
    private Integer vocabularyColumn;
    private Integer pronunciationColumn;
    private Integer testColumn;

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("progressPath", progressPath)
                .add("type", type)
                .add("dateColumn", dateColumn)
                .add("vocabularyColumn", vocabularyColumn)
                .add("pronunciationColumn", pronunciationColumn)
                .add("testColumn", testColumn)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProgressImportParams that = (ProgressImportParams) o;
        return Objects.equal(progressPath, that.progressPath) &&
                type == that.type &&
                Objects.equal(dateColumn, that.dateColumn) &&
                Objects.equal(vocabularyColumn, that.vocabularyColumn) &&
                Objects.equal(pronunciationColumn, that.pronunciationColumn) &&
                Objects.equal(testColumn, that.testColumn);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(progressPath, type, dateColumn, vocabularyColumn, pronunciationColumn, testColumn);
    }

    public void setVocabularyColumn(Integer vocabularyColumn) {
        this.vocabularyColumn = vocabularyColumn;
    }

    public void setPronunciationColumn(Integer pronunciationColumn) {
        this.pronunciationColumn = pronunciationColumn;
    }

    public void setTestColumn(Integer testColumn) {
        this.testColumn = testColumn;
    }

    public String getProgressPath() {

        return progressPath;
    }

    public void setProgressPath(String progressPath) {
        this.progressPath = progressPath;
    }

    public Integer getDateColumn() {
        return dateColumn;
    }

    public void setDateColumn(Integer dateColumn) {
        this.dateColumn = dateColumn;
    }

    public Integer getVocabularyColumn() {
        return vocabularyColumn;
    }

    public Integer getPronunciationColumn() {
        return pronunciationColumn;
    }

    public Integer getTestColumn() {
        return testColumn;
    }

    public ProgressType getType() {
        return type;
    }

    public void setType(ProgressType type) {
        this.type = type;
    }
}
