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

public class customer {
	
	private static Map<Integer,List<String>> customerRecords = new HashMap<Integer,List<String>>();
	
	public customer(){
	    try {
			readFile();
		} catch (IOException e) {
			System.out.println("Read file fails : "+e.getMessage());
		}
	}
	
	public void createCustomer(int customerNumber, String firstName, String lastName, String gender){
		List<String> newRecord = new ArrayList<String>();
		newRecord.add(firstName);
		newRecord.add(lastName);
		newRecord.add(gender);
		customerRecords.put(customerNumber, newRecord);
		try {
			storeData();
		} catch (IOException e) {
			System.out.println("Write file fails : "+e.getMessage());
		}
	}

	public String getName(int customerID){
		String fullName = customerRecords.get(customerID).get(0)+customerRecords.get(customerID).get(1);
		return fullName;
	}
	
	public String getGender(int customerID){
		return customerRecords.get(customerID).get(2);
	}
	
	public Map<Integer,List<String>> getAllCustomer(){
		return customerRecords;
	}
	
	private void readFile() throws IOException{
		String line;
		
		BufferedReader textReader = new BufferedReader(new FileReader("./data/customer.txt"));
		
		while((line = textReader.readLine()) != null){
			List<String> recordDetails = new ArrayList<String>();
			String[] record = line.split(" ");
			int key = Integer.parseInt(record[0]);
			
			for(int i=1;i<record.length;i++){
				recordDetails.add(record[i]);
			}

			customerRecords.put(key,recordDetails);
			System.out.println(customerRecords.toString());
		}

	}
	
	private void storeData() throws IOException{
		
		StringBuffer recordText = new StringBuffer();
		for (int key : customerRecords.keySet()) {
			List<String> record = customerRecords.get(key);
			recordText.append(key);
			for(int i=0;i<record.size();i++){
				recordText.append(" "+record.get(i));
			}
			recordText.append("\n");
		}
		
		BufferedWriter textWriter = new BufferedWriter(new FileWriter(new File("./data/customer.txt")));
		textWriter.write(recordText.toString());
		textWriter.close();
	}
}
