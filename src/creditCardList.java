import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class creditCardList {

	private BufferedReader textReader;
	private Map<Integer, List<String>> creditCardRecords = new HashMap<Integer,List<String>>();
	
	public creditCardList(){
		try{
			readFile();
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	public boolean findCreditCard(int cardID){
		if(creditCardRecords.get(cardID) != null ){
			return true;
		}else{
			return false;
		}
	}
	
	private void readFile() throws IOException{
		String line;
		
		textReader = new BufferedReader(new FileReader("./data/creditCard.txt"));
		
		while((line = textReader.readLine()) != null){
			List<String> recordDetails = new ArrayList<String>();
			String[] record = line.split(" ");
			int key = Integer.parseInt(record[0]);
			
			for(int i=1;i<record.length;i++){
				recordDetails.add(record[i]);
			}

			creditCardRecords.put(key,recordDetails);
		}
	}
}
