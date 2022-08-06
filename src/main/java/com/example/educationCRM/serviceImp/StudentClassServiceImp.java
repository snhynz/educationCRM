package com.example.educationCRM.serviceImp;

import com.example.educationCRM.model.dto.StudentClassDTO;
import com.example.educationCRM.model.entity.StudentClass;
import com.example.educationCRM.repository.StudentClassRepository;
import com.example.educationCRM.service.StudentClassService;
import com.example.educationCRM.helpers.ModelMapperHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentClassServiceImp implements StudentClassService {
    @Autowired
    private StudentClassRepository studentClassRepository;

    @Autowired
    private ModelMapperHelpers modelMapperHelpers;

    @Override
    @Transactional
    public void addStudentClass(String name) {
        StudentClass studentClass = new StudentClass(name);
        this.studentClassRepository.save(studentClass);
    }

    @Override
    @Transactional
    public void updateStudentClass(StudentClassDTO studentClassDTO) {
        Optional<StudentClass> studentClassOptional =
                this.studentClassRepository.findById(studentClassDTO.getId());
        if (studentClassOptional.isPresent()){
            StudentClass studentClass = studentClassOptional.get();
            studentClass.setName(studentClassDTO.getName());
            this.studentClassRepository.save(studentClass);
        }
    }

    @Override
    @Transactional
    public void deleteStudentClass(Long id) {
        this.studentClassRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudentClassDTO> findAll() {
        return this.modelMapperHelpers.mapAll
                ((List<StudentClass>)this.studentClassRepository.findAll()
                ,StudentClassDTO.class);
    }
}
