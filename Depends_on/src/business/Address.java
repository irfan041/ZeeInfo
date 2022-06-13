package business;

import org.springframework.stereotype.Component;

@Component
public class Address {
  private Integer id;
  private String street;
  private String city;
  private String country;
public Address() {
	System.out.println("Address Constructor");
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
  
}
