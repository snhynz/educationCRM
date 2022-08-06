package com.example.educationCRM.serviceImp;

import com.example.educationCRM.model.dto.LessonDTO;
import com.example.educationCRM.model.entity.Lesson;
import com.example.educationCRM.repository.LessonRepository;
import com.example.educationCRM.service.LessonService;
import com.example.educationCRM.helpers.ModelMapperHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LessonServiceImp implements LessonService {
   @Autowired
   private LessonRepository lessonRepository;

   @Autowired
   private ModelMapperHelpers modelMapperHelpers;

    @Override
    @Transactional
    public void addLesson(String name) {
        Lesson lesson = new Lesson(name);
                this.lessonRepository.save(lesson);
    }

    @Override
    @Transactional
    public void updateLesson(LessonDTO lessonDTO) {
       Optional<Lesson> lessonOptional=
               this.lessonRepository.findById(lessonDTO.getId());

       if (lessonOptional.isPresent()){
           Lesson lesson = lessonOptional.get();
           lesson.setName(lessonDTO.getName());
           lesson.setId(lessonDTO.getId());
           this.lessonRepository.save(lesson);
       }

    }

    @Override
    @Transactional
    public void deleteLesson(Long id) {
        this.lessonRepository.deleteById(id);
    }

    @Override
    public List<LessonDTO> findAll() {
        return this.modelMapperHelpers.mapAll(
                (List<Lesson>)this.lessonRepository.findAll()
                ,LessonDTO.class);
    }


}
