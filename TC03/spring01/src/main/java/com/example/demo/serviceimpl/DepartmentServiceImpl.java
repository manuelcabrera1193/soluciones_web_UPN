package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Department;
import com.example.demo.repositories.DepartmentRepository;
import com.example.demo.service.IDepartmentService;

@Service
public class DepartmentServiceImpl implements IDepartmentService {
	@Autowired
	private DepartmentRepository sR;

	@Override
	public void insert(Department s) {
		sR.save(s);
	}

	@Override
	public List<Department> list() {
		// TODO Auto-generated method stub
		return sR.findAll();
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		sR.deleteById(id);
	}

}
