package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Department;

public interface IDepartmentService {

	public void insert(Department s);

	List<Department> list();

	public void deleteById(int id);
}
