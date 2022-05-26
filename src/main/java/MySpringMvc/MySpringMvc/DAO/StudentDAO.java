package MySpringMvc.MySpringMvc.DAO;

import java.util.List;

import MySpringMvc.MySpringMvc.entity.Student;


public interface StudentDAO {
	//declare the method that we want for the student
	public int addStduent(Student student);
	public int updateStudent(Student student);
	public int deleteStudent(Student student);
	public int deleteStudent(int id);
	//create some method to get the student
	public List<Student> getAllStudents();
	public Student getStudentById(int id);
	
	
};

