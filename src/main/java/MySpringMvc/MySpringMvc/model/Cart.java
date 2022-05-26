package MySpringMvc.MySpringMvc.model;

public class Cart {
	
	private int itemid;
	private String itemname;
	private int price;
	private int qty;
	private int itemvalue;
	private double gst;
	private double gstamount;
	public Cart()
	{
		
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getItemvalue() {
		return itemvalue;
	}
	public void setItemvalue(int itemvalue) {
		this.itemvalue = itemvalue;
	}
	public double getGst() {
		return gst;
	}
	public void setGst(double gst) {
		this.gst = gst;
	}
	public double getGstamount() {
		return gstamount;
	}
	public void setGstamount(double gstamount) {
		this.gstamount = gstamount;
	}
}
