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
	
//	public sellEquipment(int equipmentID) {
//		
//		super(equipmentID, "sss", 2);
//		
//		try {
//			readFile();
//		} catch (IOException e) {
//			System.out.println("Read file fails : "+e.getMessage());
//		}
//	    
//		if(sellEquipmentRecords.get(equipmentID) != null){
//			this.equipmentID = equipmentID;
//			this.Name = sellEquipmentRecords.get(equipmentID).get(0);
//			this.stock = Integer.parseInt(sellEquipmentRecords.get(equipmentID).get(1));
//			this.price = Integer.parseInt(sellEquipmentRecords.get(equipmentID).get(2));
//		}
//		else{
//			 throw new NullPointerException("NUll woi");
//		}
//		
//	}
	
	public int getStock(){
		return this.stock;
	}
	
	public int getPrice(){
		return this.price;
	}
	
	public void setStock(int amount){
//		sellEquipmentRecords.get(equipmentID).set(1,Integer.toString(amount));
//		try {
//			storeData();
//		} catch (IOException e) {
//			System.out.println("Write file fails : "+e.getMessage());
//		}
		this.stock = amount;
	}
	
	public void setPrice(int price){
//		sellEquipmentRecords.get(equipmentID).set(2,Integer.toString(price));
//		try {
//			storeData();
//		} catch (IOException e) {
//			System.out.println("Write file fails : "+e.getMessage());
//		}
		this.price = price;
	}
	
//	private void readFile() throws IOException{
//		
//		String line;
//		BufferedReader textReader = new BufferedReader(new FileReader("./data/sellEquipment.txt"));
//		
//		while((line = textReader.readLine()) != null){
//			List<String> recordDetails = new ArrayList<String>();
//			String[] record = line.split(" ");
//			int key = Integer.parseInt(record[0]);
//			
//			for(int i=1;i<record.length;i++){
//				recordDetails.add(record[i]);
//			}
//
//			sellEquipmentRecords.put(key,recordDetails);
//		}
//		textReader.close();
//	}
//	
//	private void storeData() throws IOException{
//		
//		StringBuffer recordText = new StringBuffer();
//		for (int key : sellEquipmentRecords.keySet()) {
//			List<String> record = sellEquipmentRecords.get(key);
//			recordText.append(key);
//			for(int i=0;i<record.size();i++){
//				recordText.append(" "+record.get(i));
//			}
//			recordText.append("\n");
//		}
//		
//		BufferedWriter textWriter = new BufferedWriter(new FileWriter(new File("./data/sellEquipment.txt")));
//		textWriter.write(recordText.toString());
//		textWriter.close();
//	}

}
