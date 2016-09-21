package ru.nektodev.abcouses.model;

import com.google.common.base.Objects;

import java.io.Serializable;

/**
 * @author nektodev
 * @date 21/09/2016
 */
public class ImportParams implements Serializable {
    private String publicKey;
    private String vocabularyPath;
    private String pronunciationPath;
    private String progressPath;

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("publicKey", publicKey)
                .add("vocabularyPath", vocabularyPath)
                .add("pronunciationPath", pronunciationPath)
                .add("progressPath", progressPath)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImportParams that = (ImportParams) o;
        return Objects.equal(publicKey, that.publicKey) &&
                Objects.equal(vocabularyPath, that.vocabularyPath) &&
                Objects.equal(pronunciationPath, that.pronunciationPath) &&
                Objects.equal(progressPath, that.progressPath);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(publicKey, vocabularyPath, pronunciationPath, progressPath);
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

    public String getProgressPath() {
        return progressPath;
    }

    public void setProgressPath(String progressPath) {
        this.progressPath = progressPath;
    }
}
