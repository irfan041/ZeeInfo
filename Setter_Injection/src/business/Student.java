package business;

public class Student {
	private String name;
	private int age;
	private String email;
	
	Student(){
		System.out.println("Student Default Consructor");
	}
	
	public String getName() {
		return name;
	}


	public int getAge() {
		return age;
	}


	public String getEmail() {
		return email;
	}


	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setEmail(String email) {
		this.email = email;
	}
public void printData(){
	System.out.println("name =  "+name);
	System.out.println("age =  "+age);
	System.out.println("Eamil =  "+email);
}
}
