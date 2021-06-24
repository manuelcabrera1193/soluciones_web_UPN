package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.example.demo.entities.Department;
import com.example.demo.service.IDepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private IDepartmentService sService;
	

	@GetMapping("/new")
	public String newSpecialty(Model model) {
		model.addAttribute("department", new Department());
		return "department/department";
	}
	
	@GetMapping("/edit")
	public String editSpecialty(Model model) {
		model.addAttribute("department", new Department());
		return "department/department";
	}

	@PostMapping("/save")
	public String saveSpecialty(@Validated @ModelAttribute(value = "department") Department department,
			BindingResult result, Model model, SessionStatus status) throws Exception {

		if (result.hasErrors()) {
			
			return "department/department";
		} else {
			sService.insert(department);
			model.addAttribute("mensaje", "Se realizó bien!!");
			status.setComplete();
			return "redirect:/department/list";
		}

	}

	@GetMapping("/list")
	public String listSpecialty(Model model) {
		try {
			model.addAttribute("listaDepartamento", sService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "department/listDepartment";
	}
	
	@RequestMapping("/delete-department/{id}")
    public String deleteContact(@PathVariable int id) {
        sService.deleteById(id);
        return "redirect:/department/list";
    }
	
	@PostMapping("/update-department/{id}")
    public String updateContact(@PathVariable int id, @ModelAttribute("contact") Contact contact) {
		sService.update(id, contact);
        return "redirect:/read-contact";
    }

}
