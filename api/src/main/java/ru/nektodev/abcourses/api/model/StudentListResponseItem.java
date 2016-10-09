package ru.nektodev.abcourses.api.model;

import com.google.common.base.Objects;
import ru.nektodev.abcouses.model.Student;

/**
 * @author nektodev
 * @date 09/10/2016
 */
public class StudentListResponseItem {
    private String id;
    private String name;

    public StudentListResponseItem(Student student) {
        this.id = student.getId();
        this.name = student.getName();
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentListResponseItem that = (StudentListResponseItem) o;
        return Objects.equal(id, that.id) &&
                Objects.equal(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name);
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
}
