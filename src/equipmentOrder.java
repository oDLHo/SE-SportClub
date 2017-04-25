import java.util.List;

public class equipmentOrder {
	
	private int orderNum;
	private int customerNum;
	private float totalPrice;
	
	public equipmentOrder(int orderNum, List<String> records){
	   this.orderNum = orderNum;
	   this.customerNum = Integer.parseInt(records.get(0));
	   this.totalPrice = Float.parseFloat(records.get(1));
	}
	
	public int getOrderNumber(){
		return this.orderNum;
	}
	
	public int getCustomerNumber(){
		return this.customerNum;
	}
	
	public float getTotalPrice(){
		return this.totalPrice;
	}

}
