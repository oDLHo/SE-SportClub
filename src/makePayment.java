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

import javax.swing.JOptionPane;

public class makePayment {
	
	private Random rand = new Random();
	private Date date = new Date();
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	private equipmentOrder order;
	private Map<Integer,List<String>> paymentRecords = new HashMap<Integer,List<String>>();
	private Map<Integer,List<String>> orderRecords = new HashMap<Integer,List<String>>();
	private BufferedReader textReader;
	
	public makePayment(){
		try{
			readOrdersFile();
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	public void confirmPayment(payment paymentObj) {
			paidPayment(paymentObj);
	}
	
	private void paidPayment(payment paymentObj){
		paymentObj.setStatus(true);
		this.paymentRecords.get(paymentObj.getPaymentNumber()).set(3,"true");
		try{
			storeData();
		}catch(IOException e){
			
		}
	}
	
	public payment createPayment(int orderNum, Map<Integer,List<String>> Records){
		this.paymentRecords = Records;
		if(orderRecords.get(orderNum) != null ){
			order = new equipmentOrder(orderNum, orderRecords.get(orderNum));
			int customerID = order.getCustomerNumber();
			int totalPrice = order.getTotalPrice();
			return createPaymentRecord(customerID , orderNum, totalPrice);
		}else{
			System.out.println("no order");
			return null;
		}
		
	}
	
	private payment createPaymentRecord(int customerNumber, int orderNumber, int totalPrice){
		int newPaymentID = 0;
		List<String> newRecord = new ArrayList<String>();
		while(true){
			int randKey = rand.nextInt(300);
			if(!paymentRecords.containsKey(randKey)){
				newPaymentID = randKey;
				break;
			}
		}
		
		newRecord.add(Integer.toString(customerNumber));
		newRecord.add(Integer.toString(orderNumber));
		newRecord.add(Integer.toString(totalPrice));
		newRecord.add("false");
		newRecord.add(dateFormat.format(date));
		this.paymentRecords.put(newPaymentID, newRecord);
		
		try{
			storeData();
		}catch(IOException e){
			
		}
		return new payment(newPaymentID, newRecord);
	}
	
	private void readOrdersFile() throws IOException{
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
