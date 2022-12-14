package com.example.educationCRM.serviceImp;

import com.example.educationCRM.model.dto.StudentDTO;
import com.example.educationCRM.model.dto.StudentInformationDTO;
import com.example.educationCRM.model.entity.School;
import com.example.educationCRM.model.entity.Student;
import com.example.educationCRM.model.entity.StudentClass;
import com.example.educationCRM.repository.SchoolRepository;
import com.example.educationCRM.repository.StudentClassRepository;
import com.example.educationCRM.repository.StudentRepository;
import com.example.educationCRM.service.StudentService;
import com.example.educationCRM.helpers.ModelMapperHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private StudentClassRepository studentClassRepository;

    @Autowired
    private ModelMapperHelpers modelMapperHelpers;

    /*private final SimpleDateFormat formatter =
            new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);*/

    @Override
    @Transactional
    public void saveStudent(StudentDTO studentDTO)   {
        Student student = new Student();
           student.setBirthDate(studentDTO.getBirthDate());
            student.setNumber(studentDTO.getNumber());
            student.setName(studentDTO.getName());
            student.setSurname(studentDTO.getSurname());
            student.setCreatedDate(studentDTO.getCreatedDate());
            StudentClass studentClass = this.studentClassRepository
                    .findById(studentDTO.getStudentClassId())
                    .orElse(null);
            School school = this.schoolRepository
                    .findById(studentDTO.getSchoolId())
                    .orElse(null);
            student.setSchool(school);
            student.setStudentClass(studentClass);
            this.studentRepository.save(student);
        }

    @Override
    @Transactional
    public void updateStudent(StudentDTO studentDTO){
       Optional<Student> studentOptional =
               this.studentRepository.findById(studentDTO.getId());
       if (studentOptional.isPresent()){
           Student student = studentOptional.get();
           student.setName(studentDTO.getName());
           student.setSurname(studentDTO.getSurname());
           student.setNumber(studentDTO.getNumber());
           student.setBirthDate(studentDTO.getBirthDate());StudentClass studentClass = this.studentClassRepository
                   .findById(studentDTO.getStudentClassId())
                   .orElse(null);
           School school = this.schoolRepository
                   .findById(studentDTO.getSchoolId())
                   .orElse(null);
           student.setSchool(school);
           student.setStudentClass(studentClass);
           this.studentRepository.save(student);
       }
    }

    @Override
    @Transactional
    public void deleteStudent(Long id) {
        this.studentRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudentDTO> getStudentList() {
        return this.modelMapperHelpers
                .mapAll((List<Student>)studentRepository.findAll(),StudentDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudentInformationDTO> getStudentBySchoolName(String schoolName) {
        return this.studentRepository.findStudentBySchool_Name(schoolName);
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudentInformationDTO> getStudentBySchoolNameWithSQL(String schoolName) {
        return this.studentRepository.getStudentBySchool_Name(schoolName);
    }
    @Transactional
    @Override
    public Student findById(Long id) {
        return ;
    }



}
