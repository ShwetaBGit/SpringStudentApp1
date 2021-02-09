package com.sb.test;

import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

import com.sb.controller.StudentController;
import com.sb.vo.StudentVO;

public class ClientTest {

	public static void main(String[] args) throws SQLException {
		Scanner sc = null;
		StudentVO vo = null;

		vo = new StudentVO();

		sc = new Scanner(System.in);

		System.out.println("enter roll number");
		String no = sc.next();

		System.out.println("enter name");
		String name = sc.next();

		System.out.println("enter  marks1");
		String m1 = sc.next();

		System.out.println("enter marks2");
		String m2 = sc.next();

		System.out.println("enter marks3");
		String m3 = sc.next();

		vo.setSno(no);
		vo.setSname(name);
		vo.setM1(m1);
		vo.setM2(m2);
		vo.setM3(m3);

		
		//using Bean Factory container
		// BeanFactory factory = new XmlBeanFactory(new
		// FileSytemResource("src/com/sb/cfgs/applicationContext.xml"));

		// StudentController studController = factory.getBean("controller",
		// StudentController.class);

		//using applicationContext
		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/com/sb/cfgs/applicationContext.xml");

		StudentController controller = ctx.getBean("studController", StudentController.class);

		String result = controller.process(vo);

		System.out.println(result);

	}

}
