import java.util.Scanner;

public class reserveEquipmentCoordinator {
	private reserveEquipment reserveEquip = new reserveEquipment();
	private Scanner scanners = new Scanner(System.in);
	private String reserveItem;
	public void showCatalog(){
		catalogService catalog = new catalogService();
		catalog.showCatalog("reserveEquipment");
	}
	
	private void reserved(int equipmentID){
		if(isAvailable(equipmentID)){
			reserveEquip.setStatus(equipmentID, "reserved");
		}
	}
	
	private boolean isAvailable(int equipmentID){
		boolean reserve;
		if(reserveEquip.getStatus(equipmentID).equals("available")){
			reserve = true;
		} else{
			reserve = false;
		}
		return reserve;
	}
	
	public void coordinate(){

		showCatalog();

			System.out.println("Which item you want to reserve : ");
			reserveItem = scanners.next();
			
			if(reserveItem.equals("q") || reserveItem.equals("Q")){ 
				System.out.println("Reserve process is terminated");
			}
			else{
				reserved(Integer.parseInt(reserveItem));
				System.out.println("Reserved successful");
			}
	}
}
