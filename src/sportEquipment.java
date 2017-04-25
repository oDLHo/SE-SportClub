
public class sportEquipment {
	private int equipmentID;
	private String Name;
	
	public sportEquipment(int ID, String name){
		this.equipmentID = ID;
		this.Name = name;
	}
	
	public int getEquipmentID(){
		return this.equipmentID;
	}
	
	public String getName(){
		return this.Name;
	}
	
}
