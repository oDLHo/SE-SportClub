import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class sportEquipment {
	private Map<Integer,List<String>> equipmentRecords = new HashMap<Integer,List<String>>();
	private int equipmentID;
	private String Name;
	private String Description;
	private int stock;
	
	public sportEquipment(Map<Integer,List<String>> equipmentRecords){
		this.equipmentRecords = equipmentRecords;
	}
}
