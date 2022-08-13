package com.example.educationCRM.serviceImp;

import com.example.educationCRM.helpers.ModelMapperHelpers;
import com.example.educationCRM.model.dto.GradeDTO;
import com.example.educationCRM.model.entity.Grade;
import com.example.educationCRM.model.entity.Student;
import com.example.educationCRM.model.entity.Teacher;
import com.example.educationCRM.repository.GradeRepository;
import com.example.educationCRM.repository.StudentRepository;
import com.example.educationCRM.repository.TeacherRepository;
import com.example.educationCRM.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GradeServiceImp implements GradeService {
    @Autowired
    private GradeRepository gradeRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private ModelMapperHelpers modelMapperHelpers;

    @Override
    @Transactional
    public void updateGrade(GradeDTO gradeDTO) {
        Optional<Grade> gradeOptional =
                this.gradeRepository.findById(gradeDTO.getId());
        if(gradeOptional.isPresent()){
            Grade grade = gradeOptional.get();
            grade.setGrade(gradeDTO.getGrade());
            Student student =
                    this.studentRepository
                            .findById(gradeDTO.getStudent_id())
                            .orElse(null);
            grade.setStudent(student);
            Teacher teacher =
                    this.teacherRepository
                            .findById(gradeDTO.getTeacher_id())
                            .orElse(null);
            grade.setTeacher(teacher);
            this.gradeRepository.save(grade);
        }
    }

    @Override
    @Transactional
    public void saveGrade(GradeDTO gradeDTO) {
        Grade grade = new Grade();
        grade.setGrade(gradeDTO.getGrade());
        Student student =
                this.studentRepository
                        .findById(gradeDTO.getStudent_id())
                        .orElse(null);
        grade.setStudent(student);
        Teacher teacher =
                this.teacherRepository
                        .findById(gradeDTO.getTeacher_id())
                        .orElse(null);
        grade.setTeacher(teacher);
        this.gradeRepository.save(grade);
    }

    @Override
    @Transactional
    public void deleteGrate(Long id) {
        this.gradeRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<GradeDTO> findAll() {
        return this.modelMapperHelpers.mapAll(
                (List<Grade>)this.gradeRepository.findAll()
                ,GradeDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Object> getGradesByLessonName(String lessonName) {
        return this.gradeRepository.getGradesByLessonName(lessonName);
    }
}
