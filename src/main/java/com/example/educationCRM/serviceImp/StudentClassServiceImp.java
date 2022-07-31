package com.example.educationCRM.serviceImp;

import com.example.educationCRM.model.entity.StudentClass;
import com.example.educationCRM.repository.StudentClassRepository;
import com.example.educationCRM.service.StudentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentClassServiceImp implements StudentClassService {
    @Autowired
    private StudentClassRepository studentClassRepository;

    @Override
    @Transactional
    public void addStudentClass(String number) {
        StudentClass studentClass = new StudentClass(number);
        this.studentClassRepository.save(studentClass);
    }
}
