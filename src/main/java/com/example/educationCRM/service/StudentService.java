package com.example.educationCRM.service;

import com.example.educationCRM.model.dto.StudentDTO;



import java.util.List;

public interface StudentService {

    void saveStudent(StudentDTO studentDTO);

    void updateStudent(StudentDTO studentDTO);

    void deleteStudent(Long id);

    List<StudentDTO> getStudentList();

}
