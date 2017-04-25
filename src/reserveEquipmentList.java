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

public class reserveEquipmentList {

	private BufferedReader textReader;
	private Map<Integer, reserveEquipment> reserveEquipObjs = new HashMap<Integer, reserveEquipment>();
	private Map<Integer, List<String>> reserveEquipRecords = new HashMap<Integer,List<String>>();
	
	public reserveEquipmentList(){
		try{
			readFile();
			for(int key : reserveEquipRecords.keySet()){
				reserveEquipObjs.put(key, new reserveEquipment(key, reserveEquipRecords.get(key)));
			}
			
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	public reserveEquipment findEquipment(int EquipmentID){
		if(reserveEquipObjs.get(EquipmentID) != null ){
			return reserveEquipObjs.get(EquipmentID);
		}else{
			throw new NullPointerException();
		}
	}
	
	public void setStatus(int equipmentID, boolean status){
			reserveEquipObjs.get(equipmentID).setStatus(status);
			reserveEquipRecords.get(equipmentID).set(1,"reserved");
			try{
				storeData();
			}catch(IOException e){
				throw new NullPointerException();
			}
	}
	
	
	private void readFile() throws IOException{
		String line;
		
		textReader = new BufferedReader(new FileReader("./data/reserveEquipment.txt"));
		
		while((line = textReader.readLine()) != null){
			List<String> recordDetails = new ArrayList<String>();
			String[] record = line.split(" ");
			int key = Integer.parseInt(record[0]);
			
			for(int i=1;i<record.length;i++){
				recordDetails.add(record[i]);
			}

			reserveEquipRecords.put(key,recordDetails);
		}
	}
	
	private void storeData() throws IOException{
		
		StringBuffer recordText = new StringBuffer();
		for (int key : reserveEquipRecords.keySet()) {
			List<String> record = reserveEquipRecords.get(key);
			recordText.append(key);
			for(int i=0;i<record.size();i++){
				recordText.append(" "+record.get(i));
			}
			recordText.append("\n");
		}
		
		BufferedWriter textWriter = new BufferedWriter(new FileWriter(new File("./data/reserveEquipment.txt")));
		textWriter.write(recordText.toString());
		textWriter.close();
	}
	
}
