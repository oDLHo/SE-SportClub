import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.BreakIterator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class payment {

	private Date date = new Date();
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	private static Map<Integer,List<String>> paymentRecords = new HashMap<Integer,List<String>>();
	private BufferedReader textReader;
//	private List<String> recordDetails;
	
	public payment(){
	    try {
			readFile();
		} catch (IOException e) {
			System.out.println("Read file fails : "+e.getMessage());
		}
	}
	
	public void createPaymentRecord(int paymentID, int customerNumber, int equipmentNumber, int totalPrice){
		List<String> newRecord = new ArrayList<String>();
		newRecord.add(Integer.toString(customerNumber));
		newRecord.add(Integer.toString(equipmentNumber));
		newRecord.add(Integer.toString(totalPrice));
		newRecord.add("false");
		newRecord.add(dateFormat.format(date));
		paymentRecords.put(paymentID, newRecord);
		System.out.print(paymentRecords.get(999));
	}
	
	public void paidPayment(int paymentID){
		System.out.println(paymentRecords.get(paymentID));
		paymentRecords.get(paymentID).set(3, "true");
		paymentRecords.get(paymentID).set(4, dateFormat.format(date));
		
		try {
			storeData();
		} catch (IOException e) {
			System.out.println("Write file fails : "+e.getMessage());
		}
	}
	
	public int getTotalPrice(int paymentID){
		return Integer.parseInt(paymentRecords.get(paymentID).get(2));
	}
	
	public String getDate(int paymentID){
		return paymentRecords.get(paymentID).get(4);
	}
	
	public boolean getPaidStatus(int paymentID){
		if(paymentRecords.get(paymentID).get(3) == "true"){
			return true;
		} else{
			return false;
		}
	}
	
	public int getEquipmentNumber(int paymentID){
		return Integer.parseInt(paymentRecords.get(paymentID).get(2));
	}
	
	public int getCustomerNumber(int paymentID){
		return Integer.parseInt(paymentRecords.get(paymentID).get(2));
	}
	
	public int getPaymentNumber(int paymentID){
		return Integer.parseInt(paymentRecords.get(paymentID).get(2));
	}
	
	private void readFile() throws IOException{
		String line;
		
		textReader = new BufferedReader(new FileReader("./data/payment.txt"));
		
		while((line = textReader.readLine()) != null){
			List<String> recordDetails = new ArrayList<String>();
			String[] record = line.split(" ");
			int key = Integer.parseInt(record[0]);
			
			for(int i=1;i<record.length;i++){
				recordDetails.add(record[i]);
			}

			paymentRecords.put(key,recordDetails);
		}

	}
	
	private void storeData() throws IOException{
		
		StringBuffer recordText = new StringBuffer();
		for (int key : paymentRecords.keySet()) {
			List<String> record = paymentRecords.get(key);
			recordText.append(key);
			for(int i=0;i<record.size();i++){
				recordText.append(" "+record.get(i));
			}
			recordText.append("\n");
		}
		
		BufferedWriter textWriter = new BufferedWriter(new FileWriter(new File("./data/payment.txt")));
		textWriter.write(recordText.toString());
		textWriter.close();
	}
	
}
