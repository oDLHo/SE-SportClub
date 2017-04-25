import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class customerCardList {

	private BufferedReader textReader;
	private Map<Integer, List<String>> creditCardRecords = new HashMap<Integer,List<String>>();
	private Map<Integer, customerCard> cardObjs = new HashMap<Integer, customerCard>();
	public customerCardList(){
		try{
			readFile();
			for(int key : creditCardRecords.keySet()){
				cardObjs.put(key, new customerCard(key, creditCardRecords.get(key)));
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	public customerCard findCard(int cardID){
		if(cardObjs.get(cardID) != null ){
			return cardObjs.get(cardID);
		}else{
			return null;
		}
	}
	
	private void readFile() throws IOException{
		String line;
		
		textReader = new BufferedReader(new FileReader("./data/customerCard.txt"));
		
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
