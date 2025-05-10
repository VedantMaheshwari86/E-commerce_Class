package oops.com;
public class Cart{
	private String purchaseItem;
	private float price;
	private int quantity;
	private static int size=0;
	private int netSize=size;
	public Cart(String purchaseItem,float price,int quanity) {
		this.purchaseItem=purchaseItem;
		this.price=price;
		this.quantity=quanity;
		netSize=size++;
	}
	public String getItemInCart() {
		return purchaseItem;
	}
	public float getNetPrice() {
		return price*quantity;
	}
	public int getQuantity() {
		return quantity;
	}
	public int getSizeOfCart() {
		return netSize;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}