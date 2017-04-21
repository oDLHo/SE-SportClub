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

public class reserveEquipment extends sportEquipment{
	
//	private static Map<Integer,List<String>> reserveEquipmentRecords = new HashMap<Integer,List<String>>();
	private String status;
	
	public reserveEquipment(int equipmentID, List<String> records){
		super(equipmentID, records.get(0));
		this.status = records.get(1);
	}
	
//	public reserveEquipment() {
//		super(reserveEquipmentRecords);
//		try {
//			readFile();
//		} catch (IOException e) {
//			System.out.println(e.getMessage());
//		}
//	}
	
	public String getStatus(){
		return this.status;
	}
	
	public void setStatus(String status){
//		reserveEquipmentRecords.get(equipmentID).set(1, status);
//		try {
//			storeData();
//		} catch (IOException e) {
//			System.out.println("Write file fails : "+e.getMessage());
//		}
		this.status = status;
	}
	
//	private void readFile() throws IOException{
//		String line;
//		
//		BufferedReader textReader = new BufferedReader(new FileReader("./data/reserveEquipment.txt"));
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
//			reserveEquipmentRecords.put(key,recordDetails);
//		}
//
//	}
//	
//	private void storeData() throws IOException{
//		
//		StringBuffer recordText = new StringBuffer();
//		for (int key : reserveEquipmentRecords.keySet()) {
//			List<String> record = reserveEquipmentRecords.get(key);
//			recordText.append(key);
//			for(int i=0;i<record.size();i++){
//				recordText.append(" "+record.get(i));
//			}
//			recordText.append("\n");
//		}
//		
//		BufferedWriter textWriter = new BufferedWriter(new FileWriter(new File("./data/reserveEquipment.txt")));
//		textWriter.write(recordText.toString());
//		textWriter.close();
//	}
}
