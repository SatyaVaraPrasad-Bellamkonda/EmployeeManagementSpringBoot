package com.employee.EmployeeSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.employee.EmployeeSpringBoot.gettingData.EmployeeDataView;

import jakarta.persistence.EntityExistsException;

@Repository
public class EmployeeDaoImpl implements EmployeeDaoInterface {
	@Autowired
	private JdbcTemplate template;
	@Autowired 
	private EmployeeJpaRepo EmployeeRepo;
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//	private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public boolean validateUser(String username, String password) {
		String checkQuery = "SELECT count(*) FROM userValidation WHERE username = ? AND password = ?";

		int count = template.queryForObject(checkQuery, new Object[] { username, password }, Integer.class);
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean employeeLoginValidate(String username, String password) {
		String checkQuery = "SELECT count(*) FROM dataentry WHERE username = ? AND password = ? AND locked=true";
		int count = template.queryForObject(checkQuery, new Object[] { username, password }, Integer.class);
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void employeeSignUpRequest(String name, String mail, String mobile,String username,String password) {
		String dataPush = "insert into dataentry (name,mail_id,mobilenum,username,password) values(?,?,?,?,?)";
		Object[] insertValues = { name, mail, mobile ,username,password};
		template.update(dataPush, insertValues);

	}

	@Override
	public List<EmployeeDataView> employeeRequests() {
		List<EmployeeDataView> listOfEmployees = EmployeeRepo.findByLockedTrue();
		return listOfEmployees;
	}

	@Override
	public void insertData(EmployeeDataView employeeData) {

		if(EmployeeRepo.existsById(employeeData.getId())) {
			  throw new EntityExistsException("Employee with ID " + employeeData.getId() + " already exists.");
		}
		employeeData.setLocked(true);
	     EmployeeRepo.save(employeeData);
	}


	@Override
	public List<EmployeeDataView> retrieveAll() {
		List<EmployeeDataView> listOfEmployees = EmployeeRepo.findAll();
		return listOfEmployees;
	}

	@Override
	public List<EmployeeDataView> retrieve() {
		return EmployeeRepo.findByLockedFalse();
	}

	@Override
	public List<EmployeeDataView> retrieve(String id) {
		
		String newId="%"+id+"%";
		return EmployeeRepo.findByNameLike(newId);
	}
	@Override
	public List<EmployeeDataView> retrieve(int id) {
		return EmployeeRepo.findById(id);
	}
	@Override
	public boolean delete(int id) {


		if (EmployeeRepo.existsById(id)) {
			EmployeeRepo.deleteById(id);
			return true;
		}
		return false;

	}

	@Override
	public List<EmployeeDataView> getUpdateData(int id) {
		return EmployeeRepo.findById(id);
	}

	@Override
	public void update(EmployeeDataView employee) {
		String updateQuery = "UPDATE dataentry	SET name=?,mobilenum=?,mail_id=?,batch=?,place=?,mentor=?,username=?,role=?,locked=? WHERE id = ?";
		Object[] args = { employee.getName(), employee.getMobilenum(), employee.getMail_id(), employee.getBatch(),
				employee.getPlace(), employee.getMentor(), employee.getUsername(), employee.getRole(),
				employee.isLocked(), employee.getId() };
		template.update(updateQuery, args);

	}

	@Override
	public void approve(int id) {
		String updateQuery = "UPDATE dataentry	SET locked=false WHERE id = ?";
		Object[] args = { id };
		template.update(updateQuery, args);
	}
	@Override
	public void changePassword(String username, String newPassword) {
		
		String sql="Update dataentry set password=? where username=?";
		Object[] args= {newPassword,username};
		template.update(sql,args);
	}
	
	@Override
	public String getPassword(String username) {
		String sql= "Select password from dataentry where username=?";
		String hash = template.queryForObject(sql, new Object[]{username}, String.class);
		return hash;
		
//		return EmployeeRepo.findPasswordByUsername(username);
//		 List<String> results = template.queryForList(sql, new Object[]{username}, String.class);
//		    return results.isEmpty() ? null : results.get(0);
	}

	

}
