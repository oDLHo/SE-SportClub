import java.util.List;

public class sellEquipment extends sportEquipment{

	private int stock;
	private int price;
	
	public sellEquipment(int equipmentID, List<String> records){
		super(equipmentID, records.get(0));
		this.stock = Integer.parseInt(records.get(1));
		this.price = Integer.parseInt(records.get(2));
	}
	
	public int getStock(){
		return this.stock;
	}
	
	public int getPrice(){
		return this.price;
	}
	
	public void setStock(int amount){
		this.stock = amount;
	}
	
	public void setPrice(int price){
		this.price = price;
	}

}
