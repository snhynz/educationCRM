package com.example.educationCRM.service;

import com.example.educationCRM.model.dto.SchoolDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SchoolService {

   public void addSchool(String name);
   public void updateSchool(SchoolDTO schoolDTO);
   public void deleteSchool(Long id);

   public List<SchoolDTO> findAll();
}
