package com.employee.EmployeeSpringBoot.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.employee.EmployeeSpringBoot.gettingData.EmployeeDataView;
import com.employee.EmployeeSpringBoot.service.EmployeeServiceImpl;

@Controller
public class EmployeeController {
	@Autowired
	@Lazy
	private EmployeeServiceImpl employeeService;

	@RequestMapping("/")
	public String home(Principal principal,Model model){
		String username = principal.getName();
	     model.addAttribute("name", username);
		return "welcomeHome";
	}
	
	@RequestMapping("/index")
	public String index() {
		 
		return "redirect:/";
	}
	
	@RequestMapping("/userProfile")
	public String userProfile(Principal principal,Model model){
		String username = principal.getName();
	     model.addAttribute("username", username);
	     return "userProfile";
		
	}

	@RequestMapping("/insertEmployeeDetails")
	public String insertEmployeeDetails() {
		return "employee-addDetails";
	}

	@PostMapping("/dataInsertedSuccessfully")
	public ModelAndView dataInsertion(@ModelAttribute EmployeeDataView employeeData) {
		if (employeeService.insertData(employeeData) == false) {
			ModelAndView val = new ModelAndView("errorNotFound");
			val.addObject("message", "ID already exists. Please enter a unique ID.");
			val.addObject("page", "index");
			return val;

		}
		ModelAndView mv = new ModelAndView("employeeInsertionSuccess");
		mv.addObject("data", employeeData);
		return mv;
	}


	@GetMapping("/completeEmployeeData")
	public ModelAndView completeEmplyeeData() {
		ModelAndView del = new ModelAndView();
		List<EmployeeDataView> list = employeeService.retrieveAll();
		del.setViewName("displayEmployeeDb");
		del.addObject("title", "Employee List");
		del.addObject("message", "Complete List of Employees");
		del.addObject("values", list);

		return del;
	}

	@GetMapping("/activeEmployeeData")
	public ModelAndView activeEmployeeData() {
		ModelAndView del = new ModelAndView();

		List<EmployeeDataView> list = employeeService.retrieve();
		del.setViewName("displayEmployeeDb");
		del.addObject("title", "Active Employees Data");
		del.addObject("message", "List Of Active Employees");
		del.addObject("values", list);

		return del;

	}

	@RequestMapping("/employeeDeleteById")
	public ModelAndView deleteEmployee() {
		ModelAndView del = new ModelAndView();
		del.setViewName("deleteEmployeeData");
		del.addObject("message", "delete");
		return del;
	}

	@PostMapping("/deleteEmployeeStatus")
	public ModelAndView deleteStatus(@RequestParam("id") int id) {
		ModelAndView del = new ModelAndView();
		List<EmployeeDataView> list = employeeService.retrieve(id);

		if (employeeService.delete(id)) {
			del.setViewName("deleteSuccess");
			del.addObject("values", list);
			return del;
		} else {
			del.setViewName("errorNotFound");
			del.addObject("message", "The Given ID not present in the DataBase");
			del.addObject("page", "index");
			return del;
		}
	}

	@RequestMapping("/employeeUpdateById")
	public ModelAndView updateEmployee() {
		ModelAndView up = new ModelAndView();
		up.setViewName("deleteEmployeeData");
		up.addObject("message", "update");
		return up;
	}

	@PostMapping("/updateEmployeeStatus")
	public ModelAndView updateStatus(@RequestParam("id") int id) {
		if (employeeService.retrieve(id).isEmpty()) {
			ModelAndView search = new ModelAndView();
			search.setViewName("employeeDetailById");
			search.addObject("message", "There is no data with the given ID");
			return search;
		} else {
			return new ModelAndView("editEmployeeData", "user", employeeService.getUpdateData(id));
		}
	}

	@PostMapping({ "/updateUser" })
	public ModelAndView updateDetailDb(@ModelAttribute EmployeeDataView employeeDataView) {
		employeeService.update(employeeDataView);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employeeInsertionSuccess");
		/* mv.addObject("message", "Updated"); */
		mv.addObject("data", employeeDataView);
	

		return mv;

	}

	@RequestMapping("/viewEmployeeRequests")
	public ModelAndView viewEmployeeRequests() {
		ModelAndView del = new ModelAndView();

		List<EmployeeDataView> list = employeeService.employeeRequests();
		del.setViewName("displayEmployeeRequest");

		del.addObject("values", list);

		return del;
	}

	@PostMapping("/approveEmployeeSignUp")
	public ModelAndView approveEmployeeSignUp(@RequestParam("id") int id) {
		if(employeeService.approve(id)) {
		return viewEmployeeRequests();
		}else {
			return updateStatus(id);
		}
	}

	@PostMapping("/searchEmployee")
	public ModelAndView searchEmployee(@RequestParam("id") String id) {
		
		
		ModelAndView search = new ModelAndView();
		
		List<EmployeeDataView> list = employeeService.retrieve(id);
		if (list==null) {
			search.setViewName("employeeDetailById");
			search.addObject("message", "There is no data with the given ID");
		}
		search.setViewName("employeeDetailById");
		search.addObject("values", list);
		return search;

	}
	
	

}
