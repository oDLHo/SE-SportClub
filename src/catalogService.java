import java.util.List;
import java.util.Map;

public class catalogService {
	Map<Integer, List<String>> catalogDetails;
	
	public void showCatalog(String type){
		catalog catalog = new catalog(type);
		catalogDetails = catalog.getDetails();
		System.out.print(printCatalog(type));
	}
	
	private String printCatalog(String type){
		StringBuilder sb = new StringBuilder();
		if(type.equals("reserveEquipment")){
			sb.append("Id\tEquipment Name\tAvailability\n");
			
			for (int key : catalogDetails.keySet()) {
				List<String> record = catalogDetails.get(key);
				sb.append(key+"\t"+record.get(0)+"\t"+record.get(1));
				sb.append("\n");
			}
			
			}
		
		else if(type.equals("sellEquipment")){
			sb.append("Id\tEquipment Name\tPrice\tOn Hand\n");
			
			for (int key : catalogDetails.keySet()) {
				List<String> record = catalogDetails.get(key);
				sb.append(key+"\t"+record.get(0)+"\t"+record.get(2)+"\t"+record.get(1));
				sb.append("\n");
			}
		}
		return sb.toString();
	}
}
