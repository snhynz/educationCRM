package com.example.educationCRM.service;

import com.example.educationCRM.model.dto.StudentClassDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentClassService {
    public void addStudentClass(String name);

    public void updateStudentClass(StudentClassDTO studentClassDTO);

    public void deleteStudentClass(Long id);

    public List<StudentClassDTO> findAll();
}
