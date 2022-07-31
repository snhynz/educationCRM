package com.example.educationCRM.model.entity;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public class Person extends BaseEntity{
    private String name;
    private String surname;
    private Date createdDate;
    private Date birthDate;
}
