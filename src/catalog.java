import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class catalog {
	
	private static Map<Integer,List<String>> catalogRecords = new HashMap<Integer,List<String>>();
	
	public catalog(String catalogType){
		try {
			readFile(catalogType);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Map<Integer,List<String>> getDetails(){
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
//			System.out.println(catalogRecords.toString());
		}

	}
	
}
