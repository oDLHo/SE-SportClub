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

public class customerCard {
	
	private static Map<Integer,List<String>> cardRecords = new HashMap<Integer,List<String>>();
	private int customerNumber;
	private int cardNumber;
	private String expireDate;
	public customerCard(int cardID){
		try {
			readFile();
		} catch (IOException e) {
			System.out.println("Read file fails : "+e.getMessage());
		}
		if(cardRecords.get(cardID) != null){
			this.customerNumber = Integer.parseInt(cardRecords.get(cardID).get(0));
			this.expireDate = cardRecords.get(cardID).get(1);
			this.cardNumber = cardID;
		}
		else{
			 throw new NullPointerException("Card null woi");
		}
	}
	
	public int getCardNumber(){
		return this.cardNumber;
	}
	
	public int getCustomer(){
		return this.customerNumber;
	}
	
	public String getExpireDate(){
		return this.expireDate;
	}
	
	public void setExpireDate(String newDate) throws IOException{
		this.expireDate = newDate;
		cardRecords.get(this.cardNumber).set(1, newDate);
		try{
			storeData();
		}catch(IOException e){
			throw e;
		}
	}
	
	public Map<Integer,List<String>> getAllCard(){
		return cardRecords;
	}
	
	private void readFile() throws IOException{
		String line;
		
		BufferedReader textReader = new BufferedReader(new FileReader("./data/customerCard.txt"));
		
		while((line = textReader.readLine()) != null){
			List<String> recordDetails = new ArrayList<String>();
			String[] record = line.split(" ");
			int key = Integer.parseInt(record[0]);
			
			for(int i=1;i<record.length;i++){
				recordDetails.add(record[i]);
			}

			cardRecords.put(key,recordDetails);
		}

	}
	
private void storeData() throws IOException{
		
		StringBuffer recordText = new StringBuffer();
		for (int key : cardRecords.keySet()) {
			List<String> record = cardRecords.get(key);
			recordText.append(key);
			for(int i=0;i<record.size();i++){
				recordText.append(" "+record.get(i));
			}
			recordText.append("\n");
		}
		
		BufferedWriter textWriter = new BufferedWriter(new FileWriter(new File("./data/customerCard.txt")));
		textWriter.write(recordText.toString());
		textWriter.close();
	}
}
