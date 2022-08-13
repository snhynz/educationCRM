package com.example.educationCRM.service;

import com.example.educationCRM.model.dto.GradeDTO;
import com.example.educationCRM.repository.GradeRepository;

import java.util.List;

public interface GradeService {

    public void updateGrade(GradeDTO gradeDTO);
    public void saveGrade(GradeDTO gradeDTO);
    public void deleteGrate(Long id);
    public List<GradeDTO> findAll();
    public List<Object>
    getGradesByLessonName(String lessonName);
}
