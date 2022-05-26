package MySpringMvc.MySpringMvc.entity;

import java.util.LinkedHashMap;

import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Student")
public class Student {
	//we create id will be generated automatically
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int Id;
	@Column(name="firstname")	
	private String firstName;
	@Column(name="lastname")	
	private String lastName;
	@Column(name="country")	
	private String country;
	@Column(name="gender")	
	private String gender;
	@Column(name="lang")	
	private String[] favlang;
	private LinkedHashMap<String,String> countryoptions;
//constructor
public Student()
{
	//create the list of the country
	//create the object of the countryoption
	countryoptions=new LinkedHashMap<String,String> ();
	countryoptions.put("Ind", "India");
	countryoptions.put("US", "USA");
	countryoptions.put("BR", "Brazil");
}
//create the getter and the setter
public int getId() {
	return Id;
}

public void setId(int id) {
	this.Id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public LinkedHashMap<String, String> getCountryoptions() {
	return countryoptions;
}
public void setCountryoptions(LinkedHashMap<String, String> countryoptions) {
	this.countryoptions = countryoptions;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String[] getFavlang() {
	return favlang;
}
public void setFavlang(String[] favlang) {
	this.favlang = favlang;
}
}
