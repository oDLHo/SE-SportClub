public class reserveEquipmentLogic {
	private reserveEquipmentList reserveEquipList = new reserveEquipmentList();
	
	private boolean isAvailable(int equipmentID){
		return reserveEquipList.findEquipment(equipmentID).getStatus();
	}
	
	public boolean reserved(int equipmentID){
		if(isAvailable(equipmentID)){
			reserveEquipList.setStatus(equipmentID, false);
			return true;
		}else{
			return false;
		}
	}
	
	
}
