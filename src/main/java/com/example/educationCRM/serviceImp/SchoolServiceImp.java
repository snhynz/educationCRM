package com.example.educationCRM.serviceImp;

import com.example.educationCRM.model.dto.SchoolDTO;
import com.example.educationCRM.model.entity.School;
import com.example.educationCRM.repository.SchoolRepository;
import com.example.educationCRM.service.SchoolService;
import com.example.educationCRM.helpers.ModelMapperHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolServiceImp implements SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private ModelMapperHelpers modelMapperHelpers;

    @Override
    @Transactional
    public void addSchool(String name) {
        School school = new School(name);
        schoolRepository.save(school);
    }

    @Override
    @Transactional
    public void updateSchool(SchoolDTO schoolDTO) {
        Optional<School> schoolOptional
                = this.schoolRepository.findById(schoolDTO.getId());
        if (schoolOptional.isPresent()){
            School school = schoolOptional.get();
            school.setName(schoolDTO.getName());
            this.schoolRepository.save(school);
        }
    }

    @Override
    @Transactional
    public void deleteSchool(Long id) {
        this.schoolRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SchoolDTO> findAll() {
        return this.modelMapperHelpers
                .mapAll((List<School>)
                        this.schoolRepository.findAll(),SchoolDTO.class);
    }
}
