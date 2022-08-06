package com.example.educationCRM.service;

import com.example.educationCRM.model.dto.LessonDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LessonService {

    public void addLesson(String name);

    public void updateLesson(LessonDTO lessonDTO);

    public void deleteLesson(Long id);

    public List<LessonDTO> findAll();
}
