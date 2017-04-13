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
	
	private static Map<Integer,List<String>> reserveEquipmentRecords = new HashMap<Integer,List<String>>();
	
	public reserveEquipment() {
		super(reserveEquipmentRecords);
		try {
			readFile();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String getEquipmentName(int equipmentID){
		return reserveEquipmentRecords.get(equipmentID).get(0);
	}

	public boolean getStatus(int equipmentID){
		boolean reserve;
		if(reserveEquipmentRecords.get(equipmentID).get(1).equals("reserved")){
			reserve = true;
		} else{
			reserve = false;
		}
		return reserve;
	}
	
	public void setStatus(int equipmentID,String status){
		reserveEquipmentRecords.get(equipmentID).set(1,status);
		try {
			storeData();
		} catch (IOException e) {
			System.out.println("Write file fails : "+e.getMessage());
		}
	}
	
	private void readFile() throws IOException{
		String line;
		
		BufferedReader textReader = new BufferedReader(new FileReader("./data/reserveEquipment.txt"));
		
		while((line = textReader.readLine()) != null){
			List<String> recordDetails = new ArrayList<String>();
			String[] record = line.split(" ");
			int key = Integer.parseInt(record[0]);
			
			for(int i=1;i<record.length;i++){
				recordDetails.add(record[i]);
			}

			reserveEquipmentRecords.put(key,recordDetails);
			System.out.println("hello");
		}

	}
	
	private void storeData() throws IOException{
		
		StringBuffer recordText = new StringBuffer();
		for (int key : reserveEquipmentRecords.keySet()) {
			List<String> record = reserveEquipmentRecords.get(key);
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
