package ru.nektodev.abcourses.api.model;

import com.google.common.base.Objects;

import java.util.List;

/**
 * @author nektodev
 * @date 09/10/2016
 */
public class StudentListResponse {

    private List<StudentListResponseItem> students;

    public StudentListResponse(List<StudentListResponseItem> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("students", students)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentListResponse that = (StudentListResponse) o;
        return Objects.equal(students, that.students);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(students);
    }

    public List<StudentListResponseItem> getStudents() {
        return students;
    }

    public void setStudents(List<StudentListResponseItem> students) {
        this.students = students;
    }
}
