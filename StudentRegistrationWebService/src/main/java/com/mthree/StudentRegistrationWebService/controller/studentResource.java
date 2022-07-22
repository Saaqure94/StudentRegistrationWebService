package com.mthree.StudentRegistrationWebService.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mthree.StudentRegistrationWebService.student;
import com.mthree.StudentRegistrationWebService.service.ISERVICE;



@RestController
public class studentResource {
	@Autowired
	private ISERVICE service;
	
	@GetMapping(value = "/")
	public ModelAndView getTemplate() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		
		return modelAndView;
	}
	
	@GetMapping(path = "/students")
	public @ResponseBody List<student> retriveAllStudents() { 
		return service.findAll();
	}
	
	
	@PostMapping(path = "/students", consumes = "application/json")
	public student createStudent(@RequestBody @Valid student student, BindingResult result, Model model) { 
		if(result.hasErrors()) {
			return student;
		} else {
			return service.save(student);
		}
	}
}