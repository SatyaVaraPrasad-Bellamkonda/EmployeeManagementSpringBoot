package com.employee.EmployeeSpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.employee.EmployeeSpringBoot.gettingData.EmployeeDataUserDetails;
import com.employee.EmployeeSpringBoot.gettingData.EmployeeDataView;

@Service
public class EmployeeSecurityServiceImpl implements UserDetailsService {

	@Autowired
	private EmployeeJpaRepo employeRepo;
//	@Autowired
//	private EmployeeDataView employee;

	
	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		String sql = "Select * from dataentry where username=?";
//		EmployeeDataView employee = jdbcTemplate.queryForObject(sql,
//				new BeanPropertyRowMapper<>(EmployeeDataView.class), username);
//		if (employee == null) {
//			throw new RuntimeException("User Not Found Prasad");
//		}
//		UserDetails userDetails = User.withUsername(employee.getUsername()).password(employee.getPassword())
//				.accountLocked(employee.isLocked()).roles(employee.getRole()).build();
//
//		return userDetails;
//	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		EmployeeDataView employeeData = employeRepo.findByUsername(username);

		if (employeeData == null) {
			System.out.println("Entered to Overrided Method");
			throw new UsernameNotFoundException("User Not Found");
		}

		return new EmployeeDataUserDetails(employeeData);
	}

}
