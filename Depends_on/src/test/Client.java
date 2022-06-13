package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import business.Address;
import business.Car;
import business.Employee;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ap = new ClassPathXmlApplicationContext("resources/spring.xml");
		/*
		 * Car t = (Car) ap.getBean("c"); t.printData();
		 */
		  Employee e=(Employee)ap.getBean(Employee.class);
		  e.setId(101);
		  e.setName("Amit");
		  e.setEmail("Amit@gmail.com");
		 // Address a=e.getAddress();
		  System.out.println(e.getId()+","+e.getName()+","+e.getEmail());
		  //System.out.println(a.getId()+","+a.getCity()+","+a.getStreet()+","+a.getCountry());

	}

}
