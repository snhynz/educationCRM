package com.example.educationCRM.model.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "studentLevel")
public class StudentClass extends BaseEntity {

    private String name;
    @OneToMany(mappedBy = "studentClass")
    private List<Student> students;

    @ManyToMany
    private List<Teacher> teachers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public StudentClass(String name) {
        this.name = name;
    }
    public StudentClass() {}
}
