package com.mthree.StudentRegistrationWebService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.mthree.StudentRegistrationWebService.student;
import com.mthree.StudentRegistrationWebService.dao.IDAO;



@Service
public class studentService implements ISERVICE {
	@Autowired
	@Qualifier(value = "studentjparepos")
	private IDAO dao;
	
	
	public studentService() {
	}
	
	@Override
	public List<student> findAll() {
		return dao.findAll();
	}

	@Override
	public student save(student student) {
		dao.save(student);
		return student;
	}

}
