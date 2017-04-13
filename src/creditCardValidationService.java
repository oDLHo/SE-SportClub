import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class creditCardValidationService {
	
	private static Map<Integer,List<String>> cardRecords = new HashMap<Integer,List<String>>();
	
	public creditCardValidationService(){
	    try {
			readFile();
		} catch (IOException e) {
			System.out.println("Read file fails : "+e.getMessage());
		}
	}
	
	public boolean cardValidate(int creditcardID) {
		
		if(cardRecords.containsKey(creditcardID)){
			return true;
		} else {
			return false;
		}
		
	}

	private void readFile() throws IOException{
		String line;
		
		BufferedReader textReader = new BufferedReader(new FileReader("./data/creditCard.txt"));
		
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
}
