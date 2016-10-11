package ru.nektodev.abcouses.model;

import com.google.common.base.Objects;

import java.util.List;

/**
 * @author nektodev
 * @date 09/10/2016
 */
public class StudentStatistics {
    private String student;

    private Integer wordsCount;
    private Integer uniqueWordsCount;

    private Integer homeworksCount;
    private Integer testCount;

    private Integer topScoreCount;
    private Integer topVocabularyCount;
    private Integer topPronunciationCount;

    private String avgVocabularyWordsCount;
    private String avgPronunciationWordsCount;

    private String avgVocabularyScore;
    private String avgVocabularyScoreDif;
    private String avgPronunciationScore;
    private String avgPronunciationScoreDif;
    private String avgTestScore;
    private String avgTestScoreDif;

    private List<Word> mostFrequentWords;

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("student", student)
                .add("wordsCount", wordsCount)
                .add("uniqueWordsCount", uniqueWordsCount)
                .add("homeworksCount", homeworksCount)
                .add("testCount", testCount)
                .add("topScoreCount", topScoreCount)
                .add("topVocabularyCount", topVocabularyCount)
                .add("topPronunciationCount", topPronunciationCount)
                .add("avgVocabularyWordsCount", avgVocabularyWordsCount)
                .add("avgPronunciationWordsCount", avgPronunciationWordsCount)
                .add("avgVocabularyScore", avgVocabularyScore)
                .add("avgVocabularyScoreDif", avgVocabularyScoreDif)
                .add("avgPronunciationScore", avgPronunciationScore)
                .add("avgPronunciationScoreDif", avgPronunciationScoreDif)
                .add("avgTestScore", avgTestScore)
                .add("avgTestScoreDif", avgTestScoreDif)
                .add("mostFrequentWords", mostFrequentWords)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentStatistics that = (StudentStatistics) o;
        return Objects.equal(student, that.student) &&
                Objects.equal(wordsCount, that.wordsCount) &&
                Objects.equal(uniqueWordsCount, that.uniqueWordsCount) &&
                Objects.equal(homeworksCount, that.homeworksCount) &&
                Objects.equal(testCount, that.testCount) &&
                Objects.equal(topScoreCount, that.topScoreCount) &&
                Objects.equal(topVocabularyCount, that.topVocabularyCount) &&
                Objects.equal(topPronunciationCount, that.topPronunciationCount) &&
                Objects.equal(avgVocabularyWordsCount, that.avgVocabularyWordsCount) &&
                Objects.equal(avgPronunciationWordsCount, that.avgPronunciationWordsCount) &&
                Objects.equal(avgVocabularyScore, that.avgVocabularyScore) &&
                Objects.equal(avgVocabularyScoreDif, that.avgVocabularyScoreDif) &&
                Objects.equal(avgPronunciationScore, that.avgPronunciationScore) &&
                Objects.equal(avgPronunciationScoreDif, that.avgPronunciationScoreDif) &&
                Objects.equal(avgTestScore, that.avgTestScore) &&
                Objects.equal(avgTestScoreDif, that.avgTestScoreDif) &&
                Objects.equal(mostFrequentWords, that.mostFrequentWords);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(student, wordsCount, uniqueWordsCount, homeworksCount, testCount, topScoreCount, topVocabularyCount, topPronunciationCount, avgVocabularyWordsCount, avgPronunciationWordsCount, avgVocabularyScore, avgVocabularyScoreDif, avgPronunciationScore, avgPronunciationScoreDif, avgTestScore, avgTestScoreDif, mostFrequentWords);
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public Integer getWordsCount() {
        return wordsCount;
    }

    public void setWordsCount(Integer wordsCount) {
        this.wordsCount = wordsCount;
    }

    public Integer getUniqueWordsCount() {
        return uniqueWordsCount;
    }

    public void setUniqueWordsCount(Integer uniqueWordsCount) {
        this.uniqueWordsCount = uniqueWordsCount;
    }

    public Integer getHomeworksCount() {
        return homeworksCount;
    }

    public void setHomeworksCount(Integer homeworksCount) {
        this.homeworksCount = homeworksCount;
    }

    public Integer getTestCount() {
        return testCount;
    }

    public void setTestCount(Integer testCount) {
        this.testCount = testCount;
    }

    public Integer getTopScoreCount() {
        return topScoreCount;
    }

    public void setTopScoreCount(Integer topScoreCount) {
        this.topScoreCount = topScoreCount;
    }

    public String getAvgVocabularyWordsCount() {
        return avgVocabularyWordsCount;
    }

    public void setAvgVocabularyWordsCount(String avgVocabularyWordsCount) {
        this.avgVocabularyWordsCount = avgVocabularyWordsCount;
    }

    public String getAvgPronunciationWordsCount() {
        return avgPronunciationWordsCount;
    }

    public void setAvgPronunciationWordsCount(String avgPronunciationWordsCount) {
        this.avgPronunciationWordsCount = avgPronunciationWordsCount;
    }

    public String getAvgVocabularyScore() {
        return avgVocabularyScore;
    }

    public void setAvgVocabularyScore(String avgVocabularyScore) {
        this.avgVocabularyScore = avgVocabularyScore;
    }

    public String getAvgPronunciationScore() {
        return avgPronunciationScore;
    }

    public void setAvgPronunciationScore(String avgPronunciationScore) {
        this.avgPronunciationScore = avgPronunciationScore;
    }

    public String getAvgTestScore() {
        return avgTestScore;
    }

    public void setAvgTestScore(String avgTestScore) {
        this.avgTestScore = avgTestScore;
    }

    public List<Word> getMostFrequentWords() {
        return mostFrequentWords;
    }

    public void setMostFrequentWords(List<Word> mostFrequentWords) {
        this.mostFrequentWords = mostFrequentWords;
    }

    public Integer getTopVocabularyCount() {
        return topVocabularyCount;
    }

    public void setTopVocabularyCount(Integer topVocabularyCount) {
        this.topVocabularyCount = topVocabularyCount;
    }

    public Integer getTopPronunciationCount() {
        return topPronunciationCount;
    }

    public void setTopPronunciationCount(Integer topPronunciationCount) {
        this.topPronunciationCount = topPronunciationCount;
    }

    public String getAvgVocabularyScoreDif() {
        return avgVocabularyScoreDif;
    }

    public void setAvgVocabularyScoreDif(String avgVocabularyScoreDif) {
        this.avgVocabularyScoreDif = avgVocabularyScoreDif;
    }

    public String getAvgPronunciationScoreDif() {
        return avgPronunciationScoreDif;
    }

    public void setAvgPronunciationScoreDif(String avgPronunciationScoreDif) {
        this.avgPronunciationScoreDif = avgPronunciationScoreDif;
    }

    public String getAvgTestScoreDif() {
        return avgTestScoreDif;
    }

    public void setAvgTestScoreDif(String avgTestScoreDif) {
        this.avgTestScoreDif = avgTestScoreDif;
    }
}
