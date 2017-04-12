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

public class equipmentOrder {
	
	private static Map<Integer,List<String>> orderRecords = new HashMap<Integer,List<String>>();
	
	public equipmentOrder(){
	    try {
			readFile();
		} catch (IOException e) {
			System.out.println("Read file fails : "+e.getMessage());
		}
	}
	
	public int getTotalPrice(int orderNum){
		return Integer.parseInt(orderRecords.get(orderNum).get(1));
	}
	
	public int getCustomerNumber(int orderNum){
		return Integer.parseInt(orderRecords.get(orderNum).get(0));
	}
	
	private void readFile() throws IOException{
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
			System.out.println(orderRecords.toString());
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
