package com.example.educationCRM.controller;

import com.example.educationCRM.model.dto.StudentClassDTO;
import com.example.educationCRM.service.StudentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("studentClass")
public class StudentClassController {

    @Autowired
    private StudentClassService studentClassService;

    @PostMapping
    public void addStudentClass
            (@RequestBody StudentClassDTO studentClassDTO){
        this.studentClassService.addStudentClass(studentClassDTO.getNumber());

    }
}
