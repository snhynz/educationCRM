package com.example.educationCRM.serviceImp;

import com.example.educationCRM.model.entity.Lesson;
import com.example.educationCRM.repository.LessonRepository;
import com.example.educationCRM.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LessonServiceImp implements LessonService {
   @Autowired
   private LessonRepository lessonRepository;

    @Override
    @Transactional
    public void addLesson(String name) {
        Lesson lesson = new Lesson(name);
                this.lessonRepository.save(lesson);
    }
}
