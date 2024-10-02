package com.employee.EmployeeSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.employee.EmployeeSpringBoot.gettingData.EmployeeDataUserDetails;
import com.employee.EmployeeSpringBoot.gettingData.EmployeeDataView;

@Service
public class EmployeeServiceImpl implements EmployeeServiceInterface{

	@Autowired
	private EmployeeDaoImpl employeeDaoImpl;
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
	private EmployeeDataView employee;

	@Autowired
	private EmployeeJpaRepo employeeRepo;
//	@Autowired
//	private JdbcUserDetailsManager jdbcUserDetailsManager;
	private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public boolean insertData(int id, String name, String mobileNum, String mail, String batch, String place,
			String mentor, String username, String password, String role) {
//		try {
////			String encodePass = passwordEncoder.encode(password);
//			employeeDaoImpl.insertData(id, name, mobileNum, mail, batch, place, mentor, username, password, role);
//		return true;
//	} catch (DuplicateKeyException cause) {
//		EmployeeDataView employee = new EmployeeDataView();
//		String causeMessage = cause != null ? cause.getMessage() : "No specific cause found.";
//		System.out.println(causeMessage);
//		throw new DuplicateKeyException(
//				"Duplicate entry detected for username: " + employee.getUsername() + ". Cause: " + causeMessage);
//
//		return false;
//	}
		return false;
	}

	@Override
	public List<EmployeeDataView> retrieve() {
		List<EmployeeDataView> retrieve = employeeDaoImpl.retrieve();
		return retrieve;
	}

	@Override
	public List<EmployeeDataView> retrieveAll() {
		List<EmployeeDataView> retrieveAll = employeeDaoImpl.retrieveAll();
		return retrieveAll;
	}

	@Override
	public List<EmployeeDataView> retrieve(int id) {

		List<EmployeeDataView> retrieveById = employeeDaoImpl.retrieve(id);
		return retrieveById;

	}

	@Override
	public List<EmployeeDataView> retrieve(String id) {
		try {
			Integer.parseInt(id);
			List<EmployeeDataView> retrieveById = employeeDaoImpl.retrieve(Integer.parseInt(id));
			return retrieveById;

		} catch (NumberFormatException e) {
			List<EmployeeDataView> retrieveById = employeeDaoImpl.retrieve(id);
			return retrieveById;
		}

	}

	@Override
	public boolean delete(int id) {
		boolean delete = employeeDaoImpl.delete(id);
		return delete;
	}

	@Override
	public void update(EmployeeDataView employeeDataView) {
		employeeDaoImpl.update(employeeDataView);
	}

	@Override
	public List<EmployeeDataView> getUpdateData(int id) {
		List<EmployeeDataView> updateData = employeeDaoImpl.getUpdateData(id);
		return updateData;
	}

	@Override
	public boolean validateUser(String username, String password) {
		boolean validateUser = employeeDaoImpl.validateUser(username, password);
		return validateUser;
	}

	@Override
	public boolean employeeLoginValidate(String username, String password) {
		boolean employeeLoginValidate = employeeDaoImpl.employeeLoginValidate(username, password);
		return employeeLoginValidate;
	}

	@Override
	public void employeeSignUpRequest(String name, String mail, String mobile, String username, String password) {
//		String encodePass = passwordEncoder.encode(password);
//		UserDetails user = User.withUsername(username).password(encodePass).roles("user").build();
//		jdbcUserDetailsManager.createUser(user);
		String encoded = passwordEncoder.encode(password);
		employeeDaoImpl.employeeSignUpRequest(name, mail, mobile, username, encoded);
	}

	@Override
	public List<EmployeeDataView> employeeRequests() {
		List<EmployeeDataView> employeeRequests = employeeDaoImpl.employeeRequests();
		return employeeRequests;
	}

	@Override
	public boolean approve(int id) {
		List<EmployeeDataView> list=employeeRepo.findById(id);
		for (EmployeeDataView employeeData : list) {
	        String mentor = employeeData.getMentor(); // Assuming there's a getMentor() method
	        if (mentor != null && !mentor.isEmpty()) {
	        	employeeDaoImpl.approve(id);
	        	return true;
	        } else {
	        	return false;
	        }
	    }
		return false;
	}

	@Override
	public boolean insertData(EmployeeDataView employeeData) {
		String pass = employeeData.getPassword();
		String encoded = passwordEncoder.encode(pass);
		employeeData.setPassword(encoded);
		try {
			employeeDaoImpl.insertData(employeeData);
			return true;
		} catch (Exception cause) {
			return false;
		}
	}



	@Override
	public boolean changePassword(String username, String password, String newPassword) {
		try {
			String hashPassword = employeeDaoImpl.getPassword(username);
			String newEncoded = passwordEncoder.encode(newPassword);
			if (passwordEncoder.matches(password, hashPassword)) {
				employeeDaoImpl.changePassword(username, newEncoded);
				return true;
			}
			return false;
		} catch (DataAccessException e) {
			return false;
		}
	}

}
