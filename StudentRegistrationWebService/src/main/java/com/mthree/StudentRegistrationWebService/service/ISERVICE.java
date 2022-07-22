package com.mthree.StudentRegistrationWebService.service;

import java.util.List;

import com.mthree.StudentRegistrationWebService.student;

public interface ISERVICE {
	public List<student> findAll();
	public student save(student user);
}