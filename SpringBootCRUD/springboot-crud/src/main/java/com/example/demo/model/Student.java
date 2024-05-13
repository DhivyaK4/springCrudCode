package com.example.demo.model;

import java.sql.Date;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="student_name")
	private String name;
	
	@Column(name="student_dob")
	private Date dob;
	
	@Column(name="student_doj")
	private Date doj;
	
	@Column(name="student_class")
	private String sClass;
	
	
	
	public Student() {
		super();
	}
	
	public Student(int id, String name, Date dob, Date doj, String sClass) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.doj = doj;
		this.sClass = sClass;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public String getsClass() {
		return sClass;
	}
	public void setsClass(String sClass) {
		this.sClass = sClass;
	}
	
	
	

}
