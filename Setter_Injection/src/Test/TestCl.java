package Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import business.Student;

public class TestCl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ap = new ClassPathXmlApplicationContext("resources/spring.xml");
		//Student t = (Student) ap.getBean("t");
		//System.out.println(t.getName()+","+t.getEmail()+","+t.getAge());
		}

}
