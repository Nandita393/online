package MySpringMvc.MySpringMvc.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import MySpringMvc.MySpringMvc.entity.Student;
@Repository
public class StduentDAOImpl implements StudentDAO{
  @Autowired //injecting Session Factory
  private SessionFactory sessionFactory;
	@Override
	public int addStduent(Student student) {
		// TODO Auto-generated method stub
		//create the session object using the Session factory
	Session session=sessionFactory.getCurrentSession();
	
	// save/upate the customer ... finally LOL
	//save or update
	//if the primarykey id is null -- save as new new record
	//if the primarykey id is not null -- update the record
	session.save(student);
	//close the session
	//session.close();
		return  student.getId();
	}

	@Override
	public int updateStudent(Student student) {
		// TODO Auto-generated method stub
		
		//create the object of the Session using the SessionFactory
		Session session=sessionFactory.getCurrentSession();
		//We will call the method saveorupdate to update the record
		session.saveOrUpdate(student);
		//close the session
		//session.close();
		return student.getId();
	}

	@Override
	public int deleteStudent(Student student) {
		// TODO Auto-generated method stub
		//create the object of the Session using the SessionFactory
		Session session=sessionFactory.getCurrentSession();
		//search the student eixts the id exists or not
	Student std=	session.get(Student.class, student.getId());
	//check the std is null or null if null means no record
	if(std==null)
	{
		return -1;//no record found; 
	}
	//if found then delete the record
	session.delete(student);
	//close the session
	//session.close();
		return 1;//record is updated successfully
	}

	@Override
	public int deleteStudent(int id) {
		// TODO Auto-generated method stub
		//create the object of the Session using the SessionFactory
		Session session=sessionFactory.getCurrentSession();
				//search the student eixts the id exists or not
		Student std=	session.get(Student.class, id);
			//check the std is null or null if null means no record
			if(std==null)
			{
				return -1;//no record found; 
			}
			//if found then delete the record
			session.delete(std);
			//close the session
			//session.close();
				return 1;//record is updated successfully
	}

	@Override
	public List<Student> getAllStudents() {
		// get the current hibernate session
					Session currentSession = sessionFactory.getCurrentSession();
				//createCriteria the object provided by the  HiberNate
					//we pass the class and we get the list of the object
					//select * from student
		List<Student> students=currentSession.createCriteria(Student.class).list();
		return students;
	}

	@Override
	public Student getStudentById(int id) {
	//get the current session object using the session factory object
		Session session=sessionFactory.getCurrentSession();
		//using the session object get method passing the class we get the object
		//second parameter is the primary key
		Student student=	session.get(Student.class,id);
		return  student;
	}

}
