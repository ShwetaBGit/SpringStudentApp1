package com.sb.bo;

import lombok.Data;

@Data
public class StudentBO {
	
	//BO hold data that needed for persistance operation
	
	private int sno;
	private String sname;
	private int total;
	private float avg;
	private String result;

}
