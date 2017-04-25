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

public class orderList {
	
	private BufferedReader textReader;
	private Map<Integer, equipmentOrder> orderObjs = new HashMap<Integer, equipmentOrder>();
	private Map<Integer, List<String>> orderRecords = new HashMap<Integer,List<String>>();
	private Random rand = new Random();
	
	public orderList(){
		try{
			readFile();
			for(int key : orderRecords.keySet()){
				orderObjs.put(key, new equipmentOrder(key, orderRecords.get(key)));
			}
			
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	public equipmentOrder findOrder(int orderID){
		if(orderObjs.get(orderID) != null ){
			return orderObjs.get(orderID);
		}else{
			throw new NullPointerException();
		}
	}
	
	
	public int createOrder(int customerNum, float totalPrice){
		int orderID;
		List<String> newRecord = new ArrayList<String>();
		
		while(true){
			int randKey = rand.nextInt(300);
			if(!orderRecords.containsKey(randKey)){
				orderID = randKey;
				break;
			}
		}
		
		newRecord.add(Integer.toString(customerNum));
		newRecord.add(Float.toString(totalPrice));
		this.orderRecords.put(orderID, newRecord);
		this.orderObjs.put(orderID, new equipmentOrder(orderID, newRecord));
		
		try{
			storeData();
		}catch(IOException e){
			
		}
		
		return orderID;
	}
	
	private void readFile() throws IOException{
		String line;
		
		textReader = new BufferedReader(new FileReader("./data/equipmentOrder.txt"));
		
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
	
	private void storeData() throws IOException{
		
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

}
