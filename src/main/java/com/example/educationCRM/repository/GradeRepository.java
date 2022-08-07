package com.example.educationCRM.repository;

import com.example.educationCRM.model.entity.Grade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends CrudRepository
<Grade,Long>{
}
