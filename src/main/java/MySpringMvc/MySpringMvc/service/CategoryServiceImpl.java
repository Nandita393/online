package MySpringMvc.MySpringMvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import MySpringMvc.MySpringMvc.DAO.CategoryDAO;
import MySpringMvc.MySpringMvc.entity.Category;
//Add transaction and Service
@Service
@Transactional //will create the bean for the session.beginTranction ----- session.commit
public class CategoryServiceImpl implements CategoryService {
	//Inject CategoryDAO
	@Autowired
	CategoryDAO categorydao;
	@Override
	public int add(Category category) {
		
		return categorydao.add(category);
	}

	@Override
	public int update(Category category) {
		// TODO Auto-generated method stub
	return categorydao.update(category);
	}

	@Override
	public int delete(Category category) {
		// TODO Auto-generated method stub
	return categorydao.delete(category);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return categorydao.delete(id);
	}

	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return categorydao.getAll();
	}

	@Override
	public Category getById(int id) {
		// TODO Auto-generated method stub
	return categorydao.getById(id);
	}

	@Override
	public List<Category> searchCategory(String catname) {
		// TODO Auto-generated method stub
		return categorydao.searchCategory(catname);
	}

	@Override
	public List<Category> search(String catname) {
		// TODO Auto-generated method stub
		return categorydao.search(catname);
	}

}
