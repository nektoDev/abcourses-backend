package ru.nektodev.abcourses.api.model;

import com.google.common.base.Objects;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * @author nektodev
 * @date 03/10/2016
 */
public class ProgressChartResponse implements Serializable {
    private Map<Date, ProgressChartValue> progressDateValuesMap;

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("progressDateValuesMap", progressDateValuesMap)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProgressChartResponse that = (ProgressChartResponse) o;
        return Objects.equal(progressDateValuesMap, that.progressDateValuesMap);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(progressDateValuesMap);
    }

    public Map<Date, ProgressChartValue> getProgressDateValuesMap() {

        return progressDateValuesMap;
    }

    public void setProgressDateValuesMap(Map<Date, ProgressChartValue> progressDateValuesMap) {
        this.progressDateValuesMap = progressDateValuesMap;
    }
}
