package MySpringMvc.MySpringMvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import MySpringMvc.MySpringMvc.DAO.StudentDAO;
import MySpringMvc.MySpringMvc.entity.Student;
//add annotation @service
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
//inject the Dao
	@Autowired
	private StudentDAO stddao;
	@Override
	@Transactional
	public int addStduent(Student student) {
		// TODO Auto-generated method stub
		
		return stddao.addStduent(student);
	}

	@Override
	public int updateStudent(Student student) {
		// TODO Auto-generated method stub
		return stddao.updateStudent(student);
	}

	@Override
	public int deleteStudent(Student student) {
		// TODO Auto-generated method stub
		return stddao.deleteStudent(student);
	}

	@Override
	public int deleteStudent(int id) {
		// TODO Auto-generated method stub
		return stddao.deleteStudent(id);
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return stddao.getAllStudents();
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return stddao.getStudentById(id);
	}

}
