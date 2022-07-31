package com.example.educationCRM.serviceImp;

import com.example.educationCRM.model.entity.School;
import com.example.educationCRM.repository.SchoolRepository;
import com.example.educationCRM.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class SchoolServiceImp implements SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;


    @Override
    @Transactional
    public void addSchool(String name) {
        School school = new School(name);
        schoolRepository.save(school);
    }
}
