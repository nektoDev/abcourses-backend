package ru.nektodev.abcouses.model;

import com.google.common.base.Objects;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * @author nektodev
 * @date 28/09/2016
 */
public class UsefulLink implements Serializable {
    @Id
    private String name;
    private String url;
    private boolean checked;

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("name", name)
                .add("url", url)
                .add("checked", checked)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsefulLink that = (UsefulLink) o;
        return checked == that.checked &&
                Objects.equal(name, that.name) &&
                Objects.equal(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, url, checked);
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
