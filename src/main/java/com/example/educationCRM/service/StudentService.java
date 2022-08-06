package com.example.educationCRM.service;

import com.example.educationCRM.model.dto.StudentDTO;


import java.text.ParseException;
import java.util.List;

public interface StudentService {

    void saveStudent(StudentDTO studentDTO) throws ParseException;

    void updateStudent(StudentDTO studentDTO) throws ParseException ;

    void deleteStudent(Long id);

    List<StudentDTO> getStudentList();

}
