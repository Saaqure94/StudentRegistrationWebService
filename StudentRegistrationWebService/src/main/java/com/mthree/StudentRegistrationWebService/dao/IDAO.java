package com.mthree.StudentRegistrationWebService.dao;


import java.util.List;

import com.mthree.StudentRegistrationWebService.student;


public interface IDAO {
	public List<student> findAll();
	public student save(student student);
;
	
	
}