package com.example.educationCRM.service;

import com.example.educationCRM.model.dto.TeacherDTO;
import com.example.educationCRM.model.dto.TeacherStudentDTO;

import java.util.List;

public interface TeacherService {

    public void saveTeacher(TeacherDTO teacherDTO);
    public void updateTeacher(TeacherDTO teacherDTO);
    public void deleteTeacher(Long id);
    public List<TeacherDTO> findAll();

    void addStudents(TeacherStudentDTO teacherStudentDTO);
}
