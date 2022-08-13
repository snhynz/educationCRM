package com.example.educationCRM.repository;

import com.example.educationCRM.model.dto.StudentDTO;
import com.example.educationCRM.model.dto.StudentInformationDTO;
import com.example.educationCRM.model.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {

    @Query(value = "select st.name, st.surname from student as st " +
            " inner join school s on s.id = st.school_id " +
            " where s.name=:schoolName",nativeQuery = true)
    List<StudentInformationDTO> getStudentBySchool_Name(String schoolName);

    List<StudentInformationDTO> findStudentBySchool_Name(String schoolName);
}
