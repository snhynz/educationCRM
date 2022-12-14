package com.example.educationCRM.controller;

import com.example.educationCRM.model.dto.StudentDTO;
import com.example.educationCRM.model.dto.StudentInformationDTO;
import com.example.educationCRM.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity saveStudent(
            @RequestBody StudentDTO studentDTO ){
        this.studentService.saveStudent(studentDTO);
        return new ResponseEntity<>("Başarılı Kayıt", HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateStudent (
            @RequestBody StudentDTO studentDTO ){
        this.studentService.updateStudent(studentDTO);
        return new ResponseEntity<>("Başarılı Kayıt", HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity delete (@PathVariable Long id){
        this.studentService.deleteStudent(id);
        return new ResponseEntity<>("Başarılı Silindi",HttpStatus.OK);
    }

    @GetMapping("/getStudentBySchoolName")
    public List<StudentInformationDTO> getStudentBySchoolName
            (@RequestParam String schoolName){
        return this.studentService.getStudentBySchoolName(schoolName);
    }

    @GetMapping("/getStudentBySchoolNameWithSQL")
    public List<StudentInformationDTO> getStudentBySchoolNameWithSQL
            (@RequestParam String schoolName){
        return this.studentService.getStudentBySchoolNameWithSQL(schoolName);
    }


}
