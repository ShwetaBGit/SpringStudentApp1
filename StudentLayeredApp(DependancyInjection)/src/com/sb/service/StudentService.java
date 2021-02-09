package com.sb.service;

import java.sql.SQLException;

import com.sb.dto.StudentDTO;

public interface StudentService {
	
	
	public String generateResult(StudentDTO dto)throws SQLException;

}
