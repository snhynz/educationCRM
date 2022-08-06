package com.example.educationCRM.model.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "Lesson")
public class Lesson extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "lesson")
    private List<Teacher> teachers;
    @ManyToMany(mappedBy = "lessons")
    private List<Student> students;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Lesson(String name) {
        this.name = name;
    }
    public Lesson() {}

}
