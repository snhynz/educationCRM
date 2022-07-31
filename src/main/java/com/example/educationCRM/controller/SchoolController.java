package com.example.educationCRM.controller;

import com.example.educationCRM.model.dto.SchoolDTO;
import com.example.educationCRM.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("school")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @PostMapping
    public ResponseEntity addSchool(
            @RequestBody SchoolDTO schoolDTO){
        this.schoolService.addSchool(schoolDTO.getName());
        return new ResponseEntity<>("Başarılı işlem",
                HttpStatus.CREATED);
    }
}
