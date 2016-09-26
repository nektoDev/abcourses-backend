package ru.nektodev.abcouses.model;

import com.google.common.base.Objects;

import java.io.Serializable;
import java.util.Date;

/**
 * @author nektodev
 * @date 26/09/2016
 */
public class ProgressData implements Serializable{
    private Date date;
    private Integer value;

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("date", date)
                .add("value", value)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProgressData that = (ProgressData) o;
        return Objects.equal(date, that.date) &&
                Objects.equal(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(date, value);
    }

    public Date getDate() {

        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
