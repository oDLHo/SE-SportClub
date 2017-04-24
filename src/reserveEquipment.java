import java.util.List;


public class reserveEquipment extends sportEquipment{
	
	private Boolean status;
	
	public reserveEquipment(int equipmentID, List<String> records){
		super(equipmentID, records.get(0));
		if(records.get(1).equals("available")){
			this.status = true;
		}
		else{
			this.status = false;
		}
	}

	public boolean getStatus(){
		return this.status;
	}
	
	public void setStatus(String status){
		this.status = Boolean.valueOf(status);
	}
}
