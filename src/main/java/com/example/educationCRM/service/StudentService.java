package com.example.educationCRM.service;

import com.example.educationCRM.model.dto.StudentDTO;
import com.example.educationCRM.model.dto.StudentInformationDTO;
import com.example.educationCRM.model.entity.Student;


import java.util.List;

public interface StudentService {

    void saveStudent(StudentDTO studentDTO);

    void updateStudent(StudentDTO studentDTO);

    void deleteStudent(Long id);

    List<StudentDTO> getStudentList();

    List<StudentInformationDTO>getStudentBySchoolName(String schoolName);

    List<StudentInformationDTO>getStudentBySchoolNameWithSQL(String schoolName);

    Student findById(Long id);
}
