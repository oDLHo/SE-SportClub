import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class buyEquipmentLogic {
	
	private JFrame frame;
	private float totalPrice;
	private sellEquipmentList equipLists = new sellEquipmentList();
	private orderList orderLists = new orderList();
	
	public buyEquipmentLogic(JFrame frame){
		this.frame = frame;
	}
	
	private void adjustStock(int equipmentID){
		if(equipLists.findEquipment(equipmentID).getStock() > 0){
			equipLists.setStock(equipmentID, equipLists.findEquipment(equipmentID).getStock()-1);
		}else{
			JOptionPane.showMessageDialog(this.frame,"Not enough equipment available","Create Order.",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public int createOrder(List<Integer> items, int customerNum){
		totalPrice = calculateTotalPrice(items);
		return orderLists.createOrder(customerNum, totalPrice);
	}
	
	private float calculateTotalPrice(List<Integer> itemRecords){
		float totalPrice = 0;
		for(int i=0;i<itemRecords.size();i++){
			adjustStock(itemRecords.get(i));
			totalPrice += equipLists.findEquipment(itemRecords.get(i)).getPrice();
		}
		return totalPrice;
	}
	
}
