package com.example.educationCRM.repository;

import com.example.educationCRM.model.entity.Lesson;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends CrudRepository<Lesson,Long> {
}
