package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.example.demo.entities.Employee;
import com.example.demo.service.IDepartmentService;
import com.example.demo.service.IEmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired//Inyección de dependencias
	private IEmployeeService mService;
	
	@Autowired
	private IDepartmentService sService;/*Instancia para acceder al sService*/

	@GetMapping("/new")
	public String newMedic(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("listaDepartamento", mService.list());/* Donde usa el mService, llenar la lista de Departamentos*/
		return "employee/employee";

	}

	@PostMapping("/save")
	public String saveMedic(@Validated @ModelAttribute(value = "employee") Employee employee, BindingResult result,
			Model model, SessionStatus status) throws Exception {
		if (result.hasErrors()) {
			model.addAttribute("listaDepartamento", sService.list());
			return "employee/employee";
		} else {

			mService.insert(employee);
			model.addAttribute("mensaje", "Se realizó bien!!");
			status.setComplete();
			return "redirect:/employee/list";
		}

	}

	/* listar */
	@GetMapping("/list")
	public String listMedic(Model model) {
		try {
			model.addAttribute("listaEmpleado", mService.list());
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		return "employee/listEmployee";
	}

}
