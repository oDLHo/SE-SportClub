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
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class buyEquipmentCoordinator {
	
	int totalPrice;
	private int orderID;
	private Random rand = new Random();
	private List<Integer> itemRecords = new ArrayList<Integer>();
	private sellEquipment equipments;
	private static Map<Integer,List<String>> sellEquipmentRecords = new HashMap<Integer,List<String>>();
	public static Map<Integer,List<String>> orderRecords = new HashMap<Integer,List<String>>();
	
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
		
		int orderID;
		List<String> newRecord = new ArrayList<String>();
		while(true){
			int randKey = rand.nextInt(300);
			if(!orderRecords.containsKey(randKey)){
				orderID = randKey;
				break;
			}
		}
		
		this.itemRecords = items;
		int totalPrice = calculateTotalPrice();
		newRecord.add(Integer.toString(customerNum));
		newRecord.add(Integer.toString(totalPrice));
		orderRecords.put(orderID, newRecord);
		
		try{
			storeOrdersData();
		} catch(IOException e){
			System.out.println(e.getMessage());
		}
		return orderID;
	}
	
	private int calculateTotalPrice(){
		int totalPrice = 0;
		int equipmentID;
		for(int i=0;i<itemRecords.size();i++){
			equipmentID = itemRecords.get(i);
			equipments = new sellEquipment(equipmentID,sellEquipmentRecords.get(equipmentID));
			totalPrice += equipments.getPrice();
		}
		return totalPrice;
	}
	
	public void coordinate(int cusID, List<Integer> items,JFrame frame){
		
		try{
			readOrdersFile();
			readEquipmentFile();
		} catch(IOException e){
			System.out.println(e.getMessage());
		}
		
//				for loop adjust item in list then update quantity on txt
		for(int item : items){
			this.itemRecords.add(item);
			adjustStock(item);
		}
		try{
			storeEquipmentData();
		} catch(IOException e){
			System.out.println(e.getMessage());
		}
		
		orderID = createOrder(items, cusID);
		JOptionPane.showMessageDialog(frame,"Your Order "+ orderID+"has create.","Create Order.",JOptionPane.ERROR_MESSAGE);

	}
	
	private void readOrdersFile() throws IOException{
		String line;
		
		BufferedReader textReader = new BufferedReader(new FileReader("./data/equipmentOrder.txt"));
		
		while((line = textReader.readLine()) != null){
			List<String> recordDetails = new ArrayList<String>();
			String[] record = line.split(" ");
			int key = Integer.parseInt(record[0]);
			
			for(int i=1;i<record.length;i++){
				recordDetails.add(record[i]);
			}

			orderRecords.put(key,recordDetails);
		}

	}
	
	private void storeOrdersData() throws IOException{
		
		StringBuffer recordText = new StringBuffer();
		for (int key : orderRecords.keySet()) {
			List<String> record = orderRecords.get(key);
			recordText.append(key);
			for(int i=0;i<record.size();i++){
				recordText.append(" "+record.get(i));
			}
			recordText.append("\n");
		}
		
		BufferedWriter textWriter = new BufferedWriter(new FileWriter(new File("./data/equipmentOrder.txt")));
		textWriter.write(recordText.toString());
		textWriter.close();
	}
	
	private void readEquipmentFile() throws IOException{
		
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
	
	private void storeEquipmentData() throws IOException{
		
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
