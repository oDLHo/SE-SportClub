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

	private static Map<Integer,List<String>> sellEquipmentRecords = new HashMap<Integer,List<String>>();
	
	public sellEquipment() {
		super(sellEquipmentRecords);
		try {
			readFile();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String getEquipmentName(int equipmentID){
		return sellEquipmentRecords.get(equipmentID).get(0);
	}
	
	public boolean isOutofStock(int equipmentID){
		boolean outofstock;
		int amountofStock = Integer.parseInt(sellEquipmentRecords.get(equipmentID).get(1));
		if(amountofStock > 0){
			outofstock = false;
		} else{
			outofstock = true;
		}
		return outofstock;
	}
	
	public String getPrice(int equipmentID){
		return sellEquipmentRecords.get(equipmentID).get(2);
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
			System.out.println(sellEquipmentRecords.toString());
		}

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
