package com.example.educationCRM.repository;

import com.example.educationCRM.model.dto.StudentDTO;
import com.example.educationCRM.model.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {

}
