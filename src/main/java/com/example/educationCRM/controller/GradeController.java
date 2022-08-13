package com.example.educationCRM.controller;

import com.example.educationCRM.model.dto.GradeDTO;
import com.example.educationCRM.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("grade")
public class GradeController {
    @Autowired
    private GradeService gradeService;

    @PostMapping
    public void save(@RequestBody GradeDTO gradeDTO){
        this.gradeService.saveGrade(gradeDTO);
    }


    @PutMapping
    public void update(@RequestBody GradeDTO gradeDTO){
        this.gradeService.updateGrade(gradeDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.gradeService.deleteGrate(id);
    }

    @GetMapping
    public List<GradeDTO> getGrades(){
        return this.gradeService.findAll();
    }

    @GetMapping("/getGradesByLessonName")
    public List<Object> getGradesByLessonName
            (@RequestParam String lessonName){
        return this.gradeService.getGradesByLessonName(lessonName);
    }
}
