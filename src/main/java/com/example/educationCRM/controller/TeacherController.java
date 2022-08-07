package com.example.educationCRM.controller;

import com.example.educationCRM.model.dto.TeacherDTO;
import com.example.educationCRM.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping
    public void saveTeacher(@RequestBody TeacherDTO teacherDTO){
        this.teacherService.saveTeacher(teacherDTO);
    }

    @PutMapping
    public void updateTeacher(@RequestBody TeacherDTO teacherDTO){
        this.teacherService.updateTeacher(teacherDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable(name="id") Long teacherId){
        this.teacherService.deleteTeacher(teacherId);
    }

    public List<TeacherDTO> findAll(){
        return this.teacherService.findAll();
    }
}
