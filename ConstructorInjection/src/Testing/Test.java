
package Testing;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import business.Student;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ap = new ClassPathXmlApplicationContext("resources/spring.xml");
		Student obj = (Student) ap.getBean("obj");
		System.out.println(obj.getAge() + "," + obj.getEmail() + "," + obj.getName());
	}

}
