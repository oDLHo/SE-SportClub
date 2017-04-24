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

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class reserveEquipmentCoordinator {
	
	private reserveEquipment reserveEquip;
	private Scanner scanners = new Scanner(System.in);
	private String reserveItem;
	private static Map<Integer,List<String>> reserveEquipmentRecords = new HashMap<Integer,List<String>>();;
	
	private boolean reserved(int equipmentID){
		if(isAvailable(equipmentID)){
			reserveEquip.setStatus("reserved");
			reserveEquipmentRecords.get(equipmentID).set(1,"reserved");
			try {
				storeData();
			} catch (IOException e) {
				System.out.println("Write file fails : "+e.getMessage());
			}
			return true;
		}else{
			return false;
		}
	}
	
	private boolean isAvailable(int equipmentID){
		System.out.println(reserveEquip.getEquipmentID());
		System.out.println(reserveEquip.getName());
		System.out.println(reserveEquip.getStatus());
		return reserveEquip.getStatus();
	}
	
	public void coordinate(JFrame frame, int reserveItem){
		
		try{
			readFile();
		} catch(IOException e){
			System.out.println(e.getMessage());
		}
				reserveEquip = new reserveEquipment(reserveItem,reserveEquipmentRecords.get(reserveItem));
	
				if(reserved(reserveItem)){
					JOptionPane.showMessageDialog(frame, "Reserve Successful", "Reserve Equipment", JOptionPane.INFORMATION_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(frame, "Item is not available", "Reserve Equipment", JOptionPane.ERROR_MESSAGE);
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
