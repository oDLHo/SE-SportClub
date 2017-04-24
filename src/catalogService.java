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
	
//	private String buildCatalog(String type){
//		StringBuilder sb = new StringBuilder();
//		if(type.equals("reserveEquipment")){
//			sb.append("Id\tEquipment Name\tAvailability\n");
//			
//			for (int key : catalogDetails.keySet()) {
//				List<String> record = catalogDetails.get(key);
//				sb.append(key+"\t"+record.get(0)+"\t"+record.get(1));
//				sb.append("\n");
//			}
//		}
//		
//		else if(type.equals("sellEquipment")){
//			sb.append("Id\tEquipment Name\tPrice\tOn Hand\n");
//			
//			for (int key : catalogDetails.keySet()) {
//				List<String> record = catalogDetails.get(key);
//				sb.append(key+"\t"+record.get(0)+"\t"+record.get(2)+"\t"+record.get(1));
//				sb.append("\n");
//			}
//		}
//		return sb.toString();
//	}
	
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
