import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
