
public class buyEquipmentSelection {
	
	private buyEquipmentCoordinator buyCoor = new buyEquipmentCoordinator();
	
	public void startSession(int cusID){
		buyCoor.coordinate(cusID);
	}
}
