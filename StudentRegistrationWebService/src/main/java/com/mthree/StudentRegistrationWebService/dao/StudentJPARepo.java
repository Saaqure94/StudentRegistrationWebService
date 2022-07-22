package com.mthree.StudentRegistrationWebService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mthree.StudentRegistrationWebService.student;

@Repository(value="studentjparepos")
public interface StudentJPARepo extends IDAO, JpaRepository<student, Integer> {

}