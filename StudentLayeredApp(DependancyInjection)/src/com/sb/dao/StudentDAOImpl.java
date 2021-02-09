package com.sb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sb.bo.StudentBO;

@Repository("studDAO")
public class StudentDAOImpl implements StudentDAO {

	private static final String INSERT_STUD = "INSERT INTO STUDENT VALUES(?,?,?,?,?)";

	@Autowired
	private DataSource source;

	Connection con = null;
	PreparedStatement ps = null;

	@Override
	public int insert(StudentBO bo) throws SQLException {

		con = source.getConnection();

		// create ps obj
		ps = con.prepareStatement(INSERT_STUD);

		// set query param values

		ps.setInt(1, bo.getSno());
		ps.setString(2, bo.getSname());
		ps.setInt(3, bo.getTotal());
		ps.setFloat(4, bo.getAvg());
		ps.setString(5, bo.getResult());

		int result = ps.executeUpdate();

		return result;
	}

}
