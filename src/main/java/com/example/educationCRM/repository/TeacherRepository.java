package com.example.educationCRM.repository;

import com.example.educationCRM.model.entity.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository
        extends CrudRepository<Teacher,Long> {
}
