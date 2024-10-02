package com.employee.EmployeeSpringBoot.gettingData;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class EmployeeDataUserDetails implements UserDetails {

	private EmployeeDataView employee;
	private String username;
	private String password;
	private List<GrantedAuthority> authorities;
	private String role;
	private boolean locked;


	public EmployeeDataUserDetails(EmployeeDataView employee) {
		this.employee = employee;
		username = employee.getUsername();
		password = employee.getPassword();
		authorities = Arrays.stream(employee.getRole().split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
		role=employee.getRole();
		locked=employee.isLocked();

	}

	public EmployeeDataUserDetails() {
		super();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}
	 @Override
	  public boolean isAccountNonLocked() {
	        return !locked;
	  }
	
	

}
