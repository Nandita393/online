package MySpringMvc.MySpringMvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import MySpringMvc.MySpringMvc.DAO.StduentDAOImpl;
import MySpringMvc.MySpringMvc.DAO.StudentDAO;
import MySpringMvc.MySpringMvc.entity.Student;
import MySpringMvc.MySpringMvc.service.StudentService;
@Controller
//requestmapping for the controller
@RequestMapping("/student")
public class StudentController {
//inject the StudentService
	@Autowired
	private StudentService studentservice;
	
@RequestMapping("showform")
public String showForm(Model model)
{
	//create the object of the student class
	Student student=new Student();
	//create add the student to the model 
	model.addAttribute("student",student);
	return "student-form";
}

@RequestMapping(value="studentform",method=RequestMethod.POST)
public String studentForm(@ModelAttribute("student") Student theStudent)
{
	//we check the value of the student id
	//if it is null or 0 we will add the record else
	//update the record
	//call the service method to add the student and pass the student object
	//print the value of the id
	System.out.println("Id"+theStudent.getId());
	if(theStudent.getId()>0)
	{
		studentservice.updateStudent(theStudent);
	}
	else
	{
	studentservice.addStduent(theStudent);
	}

	/*
	System.out.println("First Name : "+theStudent.getFirstName());
	System.out.println("Last Name : "+theStudent.getLastName());
	System.out.println("Country : "+theStudent.getCountry());
	System.out.println("Gender: "+theStudent.getGender());
	String[] s=theStudent.getFavlang();
	for (String s1 : s) {
		System.out.println("Fav: "+s1);
	}

	System.out.println("Fav: "+s);
	*/
	return "confirmation";
}
//create a controller return the list of Students
//requestmapping
@RequestMapping("list")
public String list(Model model)
{
	//get the list of the students from the service
	List<Student> students=	studentservice.getAllStudents();
	//we add the studentlist to the model
	model.addAttribute("students",students);
	//retunr the view
	return "studentslist";
}
//requestmapping for student edit
@RequestMapping("editstudent/{id}")
//{id} we can get this by using @pathvariable to get the value from the url
public String editStudent(@PathVariable int id,Model model)
{
	//we get the student information from the service for the id
	Student student=studentservice.getStudentById(id);
	//add the student object to the model
	model.addAttribute("student", student);
	//retunr the view
	return "student-form";
}
@RequestMapping("deletestudent/{id}")
//{id} we can get this by using @pathvariable to get the value from the url
public String deleteStudent(@PathVariable int id,Model model)
{
	System.out.println(id);
	//we get the student information from the service for the id
	//studentservice.deleteStudent(id);
	//add the student object to the model
	//model.addAttribute("student", student);
	//return the view
	return "home";
}
}
