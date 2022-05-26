package MySpringMvc.MySpringMvc.DAO;

import java.util.List;

import MySpringMvc.MySpringMvc.entity.Category;
import MySpringMvc.MySpringMvc.entity.Item;

public interface ItemDAO {
	public int add(Item item);
	public int update(Item item);
	public int delete(Item item);
	public int delete(int id);
	//create some method to get the student
	public List<Item> getAll();
	public Item getById(int id);
}
