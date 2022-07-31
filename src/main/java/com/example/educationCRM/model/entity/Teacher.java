package com.example.educationCRM.model.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Teacher")
public class Teacher extends Person{

    @ManyToMany
    private List<Student> students;
    @ManyToOne
    private School school;
    @ManyToOne
    private Lesson lesson;

    @ManyToMany
    private List<StudentClass> studentClasses;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
}
