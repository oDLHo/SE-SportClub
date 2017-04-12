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
	
	public customerCard(){
		try {
			readFile();
		} catch (IOException e) {
			System.out.println("Read file fails : "+e.getMessage());
		}
	}
	
	public int getCustomer(int cardID){
		return Integer.parseInt(cardRecords.get(cardID).get(0));
	}
	
	public int getExpireDate(int cardID){
		return Integer.parseInt(cardRecords.get(cardID).get(1));
	}
	
	public void setExpireDate(int cardID,String newDate){
		cardRecords.get(cardID).set(1, newDate);
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
			System.out.println(cardRecords.toString());
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
