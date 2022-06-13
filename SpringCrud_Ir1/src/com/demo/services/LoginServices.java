package com.demo.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.demo.dao.BaseDAO;
import com.demo.dao.UserDAO;
import com.demo.model.Student;
import com.demo.rm.UserRowMapper;
@Service
public class LoginServices extends BaseDAO {
	
	@Autowired
    UserDAO userDAO;
    Student student = null;

	public Student Autheticate(String mail, String password) {
		String sql = "SELECT * FROM STUDENT WHERE mail=:mail and password=:password";
		Map m = new HashMap();
		m.put("mail", mail);
		m.put("password", password);
		System.out.println("Running Succcessfully");
		try {
			student = getNamedParameterJdbcTemplate().queryForObject(sql, m,
					new UserRowMapper());
			return student;
		} catch (EmptyResultDataAccessException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
