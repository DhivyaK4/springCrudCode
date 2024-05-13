package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@RestController
@RequestMapping("/api/")
public class StudentController {
	
	
	
	@Autowired
	private StudentRepository studRepo;
	
	//ADD a STUDENT to the table.
	@PostMapping("/students/save")
	public Student createEmployee(@RequestBody Student s) {
		return studRepo.save(s);
	}
	
	
	//GET details of STUDENT(s) by ID

	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getEmployeeById(@PathVariable(value = "id") Integer studentId)
			throws ResourceNotFoundException {
		Student s = studRepo.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + studentId));
		
		return ResponseEntity.ok().body(s);
	}
	
	//UPDATE details for the STUDENT(s)
	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateEmployee(@PathVariable(value = "id") Integer studentId,
			 @RequestBody Student sDetails) throws ResourceNotFoundException {
		Student s = studRepo.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + studentId));
		
		s.setName(sDetails.getName());
		s.setDob(sDetails.getDob());
		s.setDoj(sDetails.getDoj());
		s.setsClass(sDetails.getsClass());
		
		final Student updatedStud = studRepo.save(s);
		return ResponseEntity.ok(updatedStud);
	}
	
	
}
