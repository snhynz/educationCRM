package com.example.educationCRM.controller;

import com.example.educationCRM.model.dto.LessonDTO;
import com.example.educationCRM.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("lesson")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public  void addLesson (@RequestBody LessonDTO lessonDTO){
        this.lessonService.addLesson(lessonDTO.getName());
    }

}
