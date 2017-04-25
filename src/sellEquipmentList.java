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


public class sellEquipmentList {
	
	private BufferedReader textReader;
	private Map<Integer, sellEquipment> sellEquipObjs = new HashMap<Integer, sellEquipment>();
	private Map<Integer, List<String>> sellEquipRecords = new HashMap<Integer,List<String>>();
	
	public sellEquipmentList(){
		try{
			readFile();
			for(int key : sellEquipRecords.keySet()){
				sellEquipObjs.put(key, new sellEquipment(key, sellEquipRecords.get(key)));
			}
			
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	public sellEquipment findEquipment(int EquipmentID){
		if(sellEquipObjs.get(EquipmentID) != null ){
			return sellEquipObjs.get(EquipmentID);
		}else{
			throw new NullPointerException();
		}
	}
	
	public void setStock(int equipmentID, int amount){
			sellEquipObjs.get(equipmentID).setStock(amount);
			sellEquipRecords.get(equipmentID).set(1, Integer.toString(amount));
			try{
				storeData();
			}catch(IOException e){
				throw new NullPointerException();
			}
	}
	
	
	private void readFile() throws IOException{
		String line;
		
		textReader = new BufferedReader(new FileReader("./data/sellEquipment.txt"));
		
		while((line = textReader.readLine()) != null){
			List<String> recordDetails = new ArrayList<String>();
			String[] record = line.split(" ");
			int key = Integer.parseInt(record[0]);
			
			for(int i=1;i<record.length;i++){
				recordDetails.add(record[i]);
			}

			sellEquipRecords.put(key,recordDetails);
		}
	}
	
	private void storeData() throws IOException{
		
		StringBuffer recordText = new StringBuffer();
		for (int key : sellEquipRecords.keySet()) {
			List<String> record = sellEquipRecords.get(key);
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
