package com.example.educationCRM.model.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "School")
public class School extends BaseEntity {
    private String name;
    @OneToMany(mappedBy= "school")
    private List<Student> students;
    @OneToMany(mappedBy = "school")
    private List<Teacher> teachers;

    public School(String name) {
        this.name = name;
    }

    public School() {

    }

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
}
