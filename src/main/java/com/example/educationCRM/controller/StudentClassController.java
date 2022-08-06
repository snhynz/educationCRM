package com.example.educationCRM.controller;

import com.example.educationCRM.model.dto.StudentClassDTO;
import com.example.educationCRM.service.StudentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("studentClass")
public class StudentClassController {

    @Autowired
    private StudentClassService studentClassService;

    @PostMapping
    public void addStudentClass
            (@RequestBody StudentClassDTO studentClassDTO){
        this.studentClassService.addStudentClass(studentClassDTO.getName());

    }
    @PutMapping
    public ResponseEntity updateStudentClass
            (@RequestBody StudentClassDTO studentClassDTO){
        this.studentClassService.updateStudentClass(studentClassDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity deleteSchoolClass(@RequestParam Long id){
        this.studentClassService.deleteStudentClass(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<StudentClassDTO>> findAll(){
        return new ResponseEntity<>(this.studentClassService
                .findAll(),HttpStatus.OK);
    }


}
