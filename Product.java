package oops.com;
import java.util.Scanner;
import java.util.ArrayList;
public class Product{
	private ArrayList <Stock> AvailableItem = new ArrayList <Stock>();
	private ArrayList <Cart> CartItem = new ArrayList <Cart>();
	private static int oderId=0;
	private int OderId=oderId;
	public Product() {
		for(int i=0;i<=4;i++) {
			Scanner S = new Scanner(System.in);
			System.out.print("Enter Item Name : ");
			String Name = S.nextLine();
			System.out.print("Enter it's price(in rupees) : ");
			float p = S.nextFloat();
			System.out.print("Enter Quantity Present (kg/L/number of units) : ");
			int q = S.nextInt();
			AvailableItem.add(new Stock(Name,p,q));
			if(i==4) {
				S.close();
				OderId++;
			}
		}
	}
	public ArrayList<Stock> getAvailableItems(){
		return AvailableItem;
	}
	public ArrayList<Cart> getCartItems(){
		return CartItem;
	}
	public String updateQuantity(String Name, int newquantity) {
		for(Stock k: AvailableItem) {
			if(k.getItemName().equals(Name)&&k.getQuantityAvailable()>=newquantity) {
				for(Cart l :CartItem) {
					if(l.getItemInCart().equals(Name)) {
						l.setQuantity(newquantity);
						return "Quantity for "+Name+" is set to "+newquantity;
					}
				}
			}
		}
		return "Invaild, Check item's name again it can't be in cart or the Quantity not available";
	}
	public String addItem(String Name,int quantity){
		for(Stock item: AvailableItem ) {
			if(item.getItemName().equals(Name)) {
				if(item.getQuantityAvailable()>=quantity){
				  CartItem.add(new Cart(Name,item.getPrice(),quantity));
				  return "Added Sucessfully";
				}
				else {
					return "Quantity Available for "+item.getItemName()+" is "+item.getQuantityAvailable()+" Only";
				}
			}
		}
		return "Item "+Name+" not found in Store";
	}
	public String removeItem(String ItemName) {
		for(Cart x: CartItem) {
			if(x.getItemInCart().equals(ItemName)) {
				CartItem.remove(x);
				return "Item "+x.getItemInCart()+" sucessfully removed";
			}
		}
		return "Item "+ItemName+" not found";
	}
	public float netPrice() {
		float price=0.0f;
		for(Cart k: CartItem) {
			price +=k.getNetPrice();
		}
		return price;
	}
	public int oderCart() {
		for(Stock S: AvailableItem) {
			for(Cart C: CartItem) {
				if(S.getItemName().equals(C.getItemInCart())) {
					S.setQuantityAvailable(S.getQuantityAvailable()-C.getQuantity());
				}
			}
		}
		return OderId;
	}
}