import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class customerList {

	private BufferedReader textReader;
	private Map<Integer, customer> customerObjs = new HashMap<Integer, customer>();
	private Map<Integer, List<String>> customerRecords = new HashMap<Integer,List<String>>();
	
	public customerList(){
		try{
			readFile();
			for(int key : customerRecords.keySet()){
				customerObjs.put(key, new customer(key, customerRecords.get(key)));
			}
			
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	public customer findCustomer(int customerNum){
		if(customerObjs.get(customerNum) != null ){
			return customerObjs.get(customerNum);
		}else{
			return null;
		}
	}
	
	private void readFile() throws IOException{
		String line;
		
		textReader = new BufferedReader(new FileReader("./data/customer.txt"));
		
		while((line = textReader.readLine()) != null){
			List<String> recordDetails = new ArrayList<String>();
			String[] record = line.split(" ");
			int key = Integer.parseInt(record[0]);
			
			for(int i=1;i<record.length;i++){
				recordDetails.add(record[i]);
			}

			customerRecords.put(key,recordDetails);
		}
	}
}
