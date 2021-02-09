package com.sb.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.sb.bo.StudentBO;
import com.sb.dao.StudentDAO;
import com.sb.dto.StudentDTO;



@Service("studService")
@Scope("singleton")
public class StudentServiceImpl implements StudentService {
  
	public StudentServiceImpl() {
	
	System.out.println("StudentServiceImpl::0 param constructor");
	}
	
	@Autowired
   private StudentDAO dao;
@Override
	public String generateResult(StudentDTO dto) throws SQLException {

		int m1, m2, m3, total = 0;
		float avg = 0.0f;
		String result = null;
		StudentBO bo=null;

		m1 = dto.getM1();
		m2 = dto.getM2();
		m3 = dto.getM3();

		total = m1 + m2 + m3;

		avg = (float) total / 3.0f;

		if (m1>=35 && m2>=35 && m3>=35) {
			
		result = "pass";
	 }
		else {
			result ="fail\n";
	
	}//else
		
		bo = new StudentBO();
		
		
		bo.setSno(dto.getSno());
		bo.setSname(dto.getSname());
		bo.setTotal(total);
		bo.setAvg(avg);
		bo.setResult(result);
		
	int count =	dao.insert(bo);
	
	if(count ==0 ) {
	return "result: " +bo.getResult() + " " + bo.getSname() + " registration failed " ;
	}	
	else {
		
		return "result: " +  bo.getResult() + " " +bo.getSname() + " Registration Succedded "; 
			
		//result: pass name Registration Succedded
	}
	}//method
}//class
	
	
