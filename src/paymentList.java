import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class paymentList {
	
	private BufferedReader textReader;
	private Map<Integer, payment> paymentObjs = new HashMap<Integer, payment>();
	private Map<Integer, List<String>> paymentRecords = new HashMap<Integer,List<String>>();
	private Random rand = new Random();
	private Date date = new Date();
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	
	public paymentList(){
		try{
			readFile();
			for(int key : paymentRecords.keySet()){
				paymentObjs.put(key, new payment(key, paymentRecords.get(key)));
			}
			
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	public payment findPayment(int paymentID){
		if(paymentObjs.get(paymentID) != null ){
			return paymentObjs.get(paymentID);
		}else{
			throw new NullPointerException();
		}
	}
	
	
	public int createPayment(int customerNumber, int orderNumber, float totalPrice){
		int newPaymentID = 0;
		List<String> newRecord = new ArrayList<String>();
		while(true){
			int randKey = rand .nextInt(300);
			if(!paymentRecords.containsKey(randKey)){
				newPaymentID = randKey;
				break;
			}
		}

		newRecord.add(Integer.toString(customerNumber));
		newRecord.add(Integer.toString(orderNumber));
		newRecord.add(Float.toString(totalPrice));
		newRecord.add("false");
		newRecord.add(dateFormat.format(date));
		this.paymentRecords.put(newPaymentID, newRecord);
		this.paymentObjs.put(newPaymentID, new payment(newPaymentID, newRecord));
		
		try{
			storeData();
		}catch(IOException e){
			
		}
		
		return newPaymentID;
	}
	
	public void setPaymentStatus(int paymentNum, boolean status){
		
		this.paymentObjs.get(paymentNum).setStatus(status);
		this.paymentRecords.get(paymentNum).set(3,Boolean.toString(status));
		
		try{
			storeData();
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
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
