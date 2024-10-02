package com.employee.EmployeeSpringBoot.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.employee.EmployeeSpringBoot.service.EmployeeServiceImpl;

@Controller
public class EmployeeLoginController {
	@Autowired
	@Lazy
	private EmployeeServiceImpl employeeService;
	
	
	@RequestMapping("/employeeLogin")
	public String employeeLogin() {
		return "employeeSignUp";
	}
	
	
	@PostMapping("/employeeSignUpValidate")
	public void employeeSignUpValidate(@RequestParam("name") String name, @RequestParam("mail") String mail,
			@RequestParam("mobile") String mobile, @RequestParam("username") String username,
			@RequestParam("password") String password) {

		employeeService.employeeSignUpRequest(name, mail, mobile, username, password);

	}
	
	@RequestMapping("/accessDenied")
	public String accessDenied(Principal p,Model m) {
		m.addAttribute("name",p.getName());
		return "accessDenied";
	}
	@RequestMapping("/changePassword")
	public String changePassword(Principal principal,Model model) {
		String username=principal.getName();
		model.addAttribute("username",username);
		return "changePassword";
	}
	@PostMapping("/changePasswordProcess")
	public String changePasswordProcess(@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("confirmPassword") String newPassword ) {
		if(employeeService.changePassword(username,password,newPassword)) {
			return "index";
		}
		return "displayEmployeeDb";
	}
	
	
}
