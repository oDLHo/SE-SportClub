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

public class reserveEquipmentCoordinator {
	
	private reserveEquipment reserveEquip;
	private Scanner scanners = new Scanner(System.in);
	private String reserveItem;
	private static Map<Integer,List<String>> reserveEquipmentRecords = new HashMap<Integer,List<String>>();;
	
	public void showCatalog(){
		catalogService catalog = new catalogService();
		catalog.showCatalog("reserveEquipment");
	}
	
	private void reserved(int equipmentID){
		if(isAvailable(equipmentID)){
			reserveEquip.setStatus("reserved");
			reserveEquipmentRecords.get(equipmentID).set(1,"reserved");
			try {
				storeData();
			} catch (IOException e) {
				System.out.println("Write file fails : "+e.getMessage());
			}
		}
	}
	
	private boolean isAvailable(int equipmentID){
		boolean reserve;
		if(reserveEquip.getStatus().equals("available")){
			reserve = true;
		} else{
			reserve = false;
		}
		return reserve;
	}
	
	public void coordinate(){
		
		try{
			readFile();
		} catch(IOException e){
			System.out.println(e.getMessage());
		}
		
		showCatalog();

		System.out.println("Which item you want to reserve : ");
		reserveItem = scanners.next();
			
		if(reserveItem.equals("q") || reserveItem.equals("Q")){ 
			System.out.println("Reserve process is terminated");
		}
		else{
			reserveEquip = new reserveEquipment(Integer.parseInt(reserveItem),reserveEquipmentRecords.get(Integer.parseInt(reserveItem)));
			reserved(Integer.parseInt(reserveItem));
			System.out.println("Reserved successful");
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
