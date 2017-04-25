import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class buyEquipmentCoordinator {
	
	public void coordinate(int cusID, List<Integer> items,JFrame frame){
		int orderID = new buyEquipmentLogic(frame).createOrder(items, cusID);
		JOptionPane.showMessageDialog(frame,"Your Order "+ orderID+"has create.","Create Order.",JOptionPane.PLAIN_MESSAGE);
	}
	
}
