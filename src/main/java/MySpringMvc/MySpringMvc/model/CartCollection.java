package MySpringMvc.MySpringMvc.model;

import java.util.ArrayList;
import java.util.List;

import MySpringMvc.MySpringMvc.entity.Item;

public class CartCollection {

	private List<Cart> carts=new ArrayList<Cart>();
	public void addToCart(Cart cart)
	{
		carts.add(cart);
	}
	public void updateCart(int id,int qty)
	{
		for (Cart cart : carts) {
			if(cart.getItemid()==id)
			{
				cart.setQty(qty);
				break;
			}
			
		}
		//items.add(item);
	}
	
	public void deleteCart(int id)
	{
		for (Cart cart : carts) {
			if(cart.getItemid()==id)
			{
				carts.remove(cart);
				break;
			}
			
		}
		//items.add(item);
	}
	
	public double getTotal()
	{
		double tot=0;
		for (Cart cart : carts) {
			
				tot=tot+cart.getPrice()*cart.getQty();
		}
		return tot;
	}
	//get all products added to the cart
	public List<Cart> getAllCartItem()
	{
		return carts;
	}
}
