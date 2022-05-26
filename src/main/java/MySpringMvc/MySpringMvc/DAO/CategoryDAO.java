package MySpringMvc.MySpringMvc.DAO;

import java.util.List;

import MySpringMvc.MySpringMvc.entity.Category;
import MySpringMvc.MySpringMvc.entity.Student;

public interface CategoryDAO {
	//declare the method that we want for the student
		public int add(Category category);
		public int update(Category category);
		public int delete(Category category);
		public int delete(int id);
		//create some method to get the student
		public List<Category> getAll();
		public Category getById(int id);
		public List<Category> searchCategory(String catname);
		public List<Category> search(String catname);
		
}
