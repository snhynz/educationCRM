package com.example.educationCRM.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Student")
public class Student extends Person{


    private String number;
    @ManyToMany
    private List<Lesson> lessons;
    @ManyToMany(mappedBy = "students")
    private List<Teacher> teachers;
    @ManyToOne
    private School school;
    @ManyToOne
    private StudentClass studentClass;



    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessonList(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeacherList(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public StudentClass getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(StudentClass studentClass) {
        this.studentClass = studentClass;
    }
}
