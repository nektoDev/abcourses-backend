package ru.nektodev.abcouses.model;

import com.google.common.base.Objects;

import java.io.Serializable;

/**
 * @author nektodev
 * @date 21/09/2016
 */
public class ImportParams implements Serializable {
    private String publicKey;
    private String homeworkPath;
    private String vocabularyPath;
    private String pronunciationPath;
    private ProgressImportParams progressImportParams;

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("publicKey", publicKey)
                .add("homeworkPath", homeworkPath)
                .add("vocabularyPath", vocabularyPath)
                .add("pronunciationPath", pronunciationPath)
                .add("progressImportParams", progressImportParams)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImportParams that = (ImportParams) o;
        return Objects.equal(publicKey, that.publicKey) &&
                Objects.equal(homeworkPath, that.homeworkPath) &&
                Objects.equal(vocabularyPath, that.vocabularyPath) &&
                Objects.equal(pronunciationPath, that.pronunciationPath) &&
                Objects.equal(progressImportParams, that.progressImportParams);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(publicKey, homeworkPath, vocabularyPath, pronunciationPath, progressImportParams);
    }

    public String getPublicKey() {

        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getVocabularyPath() {
        return vocabularyPath;
    }

    public void setVocabularyPath(String vocabularyPath) {
        this.vocabularyPath = vocabularyPath;
    }

    public String getPronunciationPath() {
        return pronunciationPath;
    }

    public void setPronunciationPath(String pronunciationPath) {
        this.pronunciationPath = pronunciationPath;
    }

    public ProgressImportParams getProgressImportParams() {
        return progressImportParams;
    }

    public void setProgressImportParams(ProgressImportParams progressImportParams) {
        this.progressImportParams = progressImportParams;
    }

    public String getHomeworkPath() {
        return homeworkPath;
    }

    public void setHomeworkPath(String homeworkPath) {
        this.homeworkPath = homeworkPath;
    }

    public String getAbsoluteVocabularyPath() {
        return homeworkPath+vocabularyPath;
    }

    public String getAbsolutePronunciationPath() {
        return homeworkPath+pronunciationPath;
    }
}
