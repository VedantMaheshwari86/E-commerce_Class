package oops.com;
public class Stock {
	private static int id;
	private String ItemName;
	private float price;
	private int i=0;
	private int quantity;
	public Stock(String ItemName,float price,int quantity) {
		this.ItemName=ItemName;
		this.price = price;
		this.quantity = quantity;
		i=id++;
	}
	public String getItemName() {
		return ItemName;
	}
	public int getId() {
		return i;
	}
	public int getQuantityAvailable() {
		return quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setQuantityAvailable(int quantity) {
		this.quantity=quantity;
	}
}