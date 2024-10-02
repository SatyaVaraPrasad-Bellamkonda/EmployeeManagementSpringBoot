package com.employee.EmployeeSpringBoot.service;

import java.util.List;

import com.employee.EmployeeSpringBoot.gettingData.EmployeeDataView;

public interface EmployeeDaoInterface {
//	void insertData(int id, String name, String mobileNum, String mail, String batch, String place, String mentor,
//			String username, String password, String role);

	List<EmployeeDataView> retrieve();

	List<EmployeeDataView> retrieveAll();

	List<EmployeeDataView> retrieve(int id);
	List<EmployeeDataView> retrieve(String id);

	boolean delete(int id);


	List<EmployeeDataView> getUpdateData(int id);

	boolean validateUser(String username, String password);

	boolean employeeLoginValidate(String username, String password);

	void employeeSignUpRequest(String name, String mail, String mobile,String Username,String password);

	List<EmployeeDataView> employeeRequests();

	void approve(int id);

	void insertData(EmployeeDataView employeeData);

	void update(EmployeeDataView employeeDataView);

	void changePassword(String username,String newPassword);

	String getPassword(String username);

}
