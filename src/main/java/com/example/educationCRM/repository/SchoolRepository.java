package com.example.educationCRM.repository;

import com.example.educationCRM.model.entity.School;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends CrudRepository<School,Long> {
}
