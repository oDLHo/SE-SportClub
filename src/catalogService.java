import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class catalogService {
	private Map<Integer, List<String>> catalogRecords = new HashMap<Integer,List<String>>();
	
	public Map<Integer, List<String>> getCatalog(String type){
		try{
			readFile(type);
		}catch(IOException e){
			
		}
		return catalogRecords;
	}
	
	
	private void readFile(String fileName) throws IOException{
		String line;
		
		BufferedReader textReader = new BufferedReader(new FileReader("./data/"+fileName+".txt"));
		
		while((line = textReader.readLine()) != null){
			List<String> recordDetails = new ArrayList<String>();
			String[] record = line.split(" ");
			int key = Integer.parseInt(record[0]);
			
			for(int i=1;i<record.length;i++){
				recordDetails.add(record[i]);
			}

			catalogRecords.put(key,recordDetails);
		}

	}
}
