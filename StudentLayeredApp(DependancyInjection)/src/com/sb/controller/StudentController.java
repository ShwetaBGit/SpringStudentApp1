package com.sb.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sb.dto.StudentDTO;
import com.sb.service.StudentService;
import com.sb.vo.StudentVO;

@Component("studController")
public class StudentController {

	@Autowired
	private StudentService service;

	public String process(StudentVO vo) throws SQLException {

		StudentDTO dto = new StudentDTO();

		dto.setSno(Integer.parseInt(vo.getSno()));
		dto.setSname(vo.getSname());
		dto.setM1(Integer.parseInt(vo.getM1()));
		dto.setM2(Integer.parseInt(vo.getM2()));
		dto.setM3(Integer.parseInt(vo.getM3()));

		String result = service.generateResult(dto);

		return result;

	}

}
