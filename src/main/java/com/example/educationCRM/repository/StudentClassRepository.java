package com.example.educationCRM.repository;

import com.example.educationCRM.model.entity.StudentClass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentClassRepository extends CrudRepository<StudentClass,Long> {
}
