package com.employee.EmployeeSpringBoot.service;

import java.util.List;

import com.employee.EmployeeSpringBoot.gettingData.EmployeeDataView;

public interface EmployeeServiceInterface {

	boolean insertData(int id, String name, String mobileNum, String mail, String batch, String place, String mentor,
			String username, String password, String role);

	List<EmployeeDataView> retrieve();

	List<EmployeeDataView> retrieveAll();

	List<EmployeeDataView> retrieve(String id);
	List<EmployeeDataView> retrieve(int id);

	boolean delete(int id);
	
	

	List<EmployeeDataView> getUpdateData(int id);

	boolean validateUser(String username, String password);

	boolean employeeLoginValidate(String username, String password);

	void employeeSignUpRequest(String name, String mail, String mobile,String username,String password);

	List<EmployeeDataView> employeeRequests();

	boolean approve(int id);

	boolean insertData(EmployeeDataView employeeData);

	void update(EmployeeDataView employeeDataView);
	
	boolean changePassword(String username,String password,String newPassword);
}
