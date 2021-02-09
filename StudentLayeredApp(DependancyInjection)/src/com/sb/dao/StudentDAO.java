package com.sb.dao;

import java.sql.SQLException;

import com.sb.bo.StudentBO;

public interface StudentDAO {

	
	//if child implemented class throws checked exception then its 
	//parents class or interfaces should throws that check exception
 	
	public int insert(StudentBO bo) throws SQLException;
}
