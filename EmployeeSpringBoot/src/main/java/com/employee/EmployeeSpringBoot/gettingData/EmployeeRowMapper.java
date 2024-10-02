package com.employee.EmployeeSpringBoot.gettingData;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper<EmployeeDataView> {

	@Override
	public EmployeeDataView mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmployeeDataView st = new EmployeeDataView();
		st.setId(rs.getInt("id"));
		st.setName(rs.getString("name"));
		st.setMobilenum(rs.getString("mobilenum"));
		st.setMail_id(rs.getString("mail_id"));
		st.setBatch(rs.getString("batch"));
		st.setPlace(rs.getString("place"));
		st.setMentor(rs.getString("mentor"));
		st.setLocked(rs.getBoolean("locked"));
		st.setUsername(rs.getString("username"));
		st.setPassword(rs.getString("password"));
		st.setRole(rs.getString("role"));
		return st;
	}

}
