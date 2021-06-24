package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Employee;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository mR;

	@Override
	public void insert(Employee mc) {
		mR.save(mc);/* Spring Data */

	}

	@Override
	public List<Employee> list() {
		// TODO Auto-generated method stub
		return mR.findAll();
	}

	

}
