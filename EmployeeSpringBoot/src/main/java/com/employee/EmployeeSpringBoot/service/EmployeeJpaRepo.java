package com.employee.EmployeeSpringBoot.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employee.EmployeeSpringBoot.gettingData.EmployeeDataView;

@Repository
public interface EmployeeJpaRepo extends JpaRepository<EmployeeDataView, Integer> {
	List<EmployeeDataView> findByLockedFalse();

	boolean existsById(int id);

	List<EmployeeDataView> findByLockedTrue();

	List<EmployeeDataView> findById(int id);
	
	List<EmployeeDataView> findByNameLike(String id);
//	@Query("SELECT u.password FROM dataentry u WHERE u.username = :username")
//    String findPasswordByUsername(String username);
	

	EmployeeDataView findByUsername(String username);
	 
}
