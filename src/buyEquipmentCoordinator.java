import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class buyEquipmentCoordinator {
	int totalPrice;
	private String item;
	private int orderID;
	private Scanner scaners = new Scanner(System.in);
	private List<Integer> items = new ArrayList<Integer>();
	private sellEquipment equipments = new sellEquipment();
	private equipmentOrder orders = new equipmentOrder();
	private catalogService catalog = new catalogService();
	
	private void showCatalog(){
		catalog.showCatalog("sellEquipment");
	}
	
	private void adjustStock(int equipmentID){
		int amount = equipments.getStock(equipmentID);
		if(amount > 0){
			equipments.setStock(equipmentID, amount-1);
		} else{
			System.out.println("Stock equipment is not enough");
		}
	}
	
	private int createOrder(List<Integer> items, int customerNum){
		this.items = items;
		int totalPrice = calculateTotalPrice();
		return orders.createOrder(customerNum, totalPrice);
	}
	
	private int calculateTotalPrice(){
		int totalPrice = 0,equipmentID;
		for(int i=0;i<items.size();i++){
			equipmentID = items.get(i);
			totalPrice += equipments.getPrice(equipmentID);
		}
		return totalPrice;
	}
	
	public void coordinate(int cusID){
		
		showCatalog();
		
		while(true){
			System.out.println("Which item you want : (q to quit)");
			item = scaners.next();
			
			if(item.equals("q") || item.equals("Q")){ break; }
			else{
				items.add(Integer.parseInt(item));
				adjustStock(Integer.parseInt(item));
			}
		}
		
		orderID = createOrder(items, cusID);
		System.out.println("Your order number "+orderID+" is created");
	}
}
