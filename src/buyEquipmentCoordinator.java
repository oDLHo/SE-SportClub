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
import java.util.Scanner;

public class buyEquipmentCoordinator {
	int totalPrice;
	private String item;
	private int orderID;
	private Scanner scaners = new Scanner(System.in);
	private List<Integer> items = new ArrayList<Integer>();
	private sellEquipment equipments;
	private equipmentOrder orders = new equipmentOrder();
	private catalogService catalog = new catalogService();
	private static Map<Integer,List<String>> sellEquipmentRecords = new HashMap<Integer,List<String>>();
	
	private void showCatalog(){
		catalog.showCatalog("sellEquipment");
	}
	
	private void adjustStock(int equipmentID){
		equipments = new sellEquipment(equipmentID, sellEquipmentRecords.get(equipmentID));
		int amount = equipments.getStock();
		if(amount > 0){
			equipments.setStock(amount-1);
			sellEquipmentRecords.get(equipmentID).set(1, Integer.toString(amount-1));
		} else{
			System.out.println("Stock equipment is not enough");
		}
	}
	
	private int createOrder(List<Integer> items, int customerNum){
		this.items = items;
		int totalPrice = calculateTotalPrice();
		try{
			storeData();
		} catch(IOException e){
			System.out.println(e.getMessage());
		}
		
		return orders.createOrder(customerNum, totalPrice);
	}
	
	private int calculateTotalPrice(){
		int totalPrice = 0;
		int equipmentID;
		for(int i=0;i<items.size();i++){
			equipmentID = items.get(i);
			equipments = new sellEquipment(equipmentID,sellEquipmentRecords.get(equipmentID));
			totalPrice += equipments.getPrice();
		}
		return totalPrice;
	}
	
	public void coordinate(int cusID){
		
		try{
			readFile();
		} catch(IOException e){
			System.out.println(e.getMessage());
		}
		
		
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
	
	private void readFile() throws IOException{
		
		String line;
		BufferedReader textReader = new BufferedReader(new FileReader("./data/sellEquipment.txt"));
		
		while((line = textReader.readLine()) != null){
			List<String> recordDetails = new ArrayList<String>();
			String[] record = line.split(" ");
			int key = Integer.parseInt(record[0]);
			
			for(int i=1;i<record.length;i++){
				recordDetails.add(record[i]);
			}

			sellEquipmentRecords.put(key,recordDetails);
		}
		textReader.close();
	}
	
	private void storeData() throws IOException{
		
		StringBuffer recordText = new StringBuffer();
		for (int key : sellEquipmentRecords.keySet()) {
			List<String> record = sellEquipmentRecords.get(key);
			recordText.append(key);
			for(int i=0;i<record.size();i++){
				recordText.append(" "+record.get(i));
			}
			recordText.append("\n");
		}
		
		BufferedWriter textWriter = new BufferedWriter(new FileWriter(new File("./data/sellEquipment.txt")));
		textWriter.write(recordText.toString());
		textWriter.close();
	}
}
