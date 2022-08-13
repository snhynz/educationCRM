package com.example.educationCRM.serviceImp;

import com.example.educationCRM.helpers.ModelMapperHelpers;
import com.example.educationCRM.model.dto.TeacherDTO;
import com.example.educationCRM.model.dto.TeacherStudentDTO;
import com.example.educationCRM.model.entity.Lesson;
import com.example.educationCRM.model.entity.School;
import com.example.educationCRM.model.entity.Student;
import com.example.educationCRM.model.entity.Teacher;
import com.example.educationCRM.repository.LessonRepository;
import com.example.educationCRM.repository.SchoolRepository;

import com.example.educationCRM.repository.StudentRepository;
import com.example.educationCRM.repository.TeacherRepository;

import com.example.educationCRM.service.StudentService;
import com.example.educationCRM.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImp implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ModelMapperHelpers modelMapperHelpers;

    @Autowired
    private StudentService studentService;
    @Autowired
    private LessonRepository lessonRepository;
    @Autowired
    private SchoolRepository schoolRepository;
    @Override
    @Transactional
    public void saveTeacher(TeacherDTO teacherDTO) {
        Teacher teacher = this.modelMapperHelpers
                .convertToModel(teacherDTO,Teacher.class);
        School school = this.schoolRepository
                .findById(teacherDTO.getSchool_id())
                .orElse(null);
        Lesson lesson =  this.lessonRepository
                .findById(teacherDTO.getLesson_id())
                .orElse(null);
        teacher.setLesson(lesson);
        teacher.setSchool(school);
        this.teacherRepository.save(teacher);

    }

    @Override
    @Transactional
    public void updateTeacher(TeacherDTO teacherDTO) {
        Optional<Teacher> teacherOptional
                =this.teacherRepository.findById(teacherDTO.getId());
        if (teacherOptional.isPresent()){
            Teacher teacher = teacherOptional.get();
            //teacher = modelMapperHelpers.convertToModel(teacherDTO,Teacher.class);
            teacher.setBirthDate(teacherDTO.getBirthDate());
            teacher.setCreatedDate(teacher.getCreatedDate());
            teacher.setName(teacherDTO.getName());
            teacher.setSurname(teacherDTO.getSurname());
            School school = this.schoolRepository
                    .findById(teacherDTO.getSchool_id())
                    .orElse(null);
            Lesson lesson =  this.lessonRepository
                    .findById(teacherDTO.getLesson_id())
                    .orElse(null);
            teacher.setLesson(lesson);
            teacher.setSchool(school);
            this.teacherRepository.save(teacher);
        }
    }

    @Override
    @Transactional
    public void deleteTeacher(Long id) {
        this.teacherRepository.deleteById(id);

    }

    @Override
    @Transactional(readOnly = true)
    public List<TeacherDTO> findAll() {
        return this.modelMapperHelpers.mapAll(
                (List<Teacher>)this.teacherRepository.findAll()
                ,TeacherDTO.class);
    }

    @Override
    @Transactional
    public void addStudents(TeacherStudentDTO teacherStudentDTO) {
        Teacher teacher = this.teacherRepository
                .findById(teacherStudentDTO.getTeacherId()).get();

        for (Long id: teacherStudentDTO.getStudentIds()){
            Student s = studentService.findById(id);
            teacher.getStudents().add(s);
        }
        this.teacherRepository.save(teacher);
    }
}
