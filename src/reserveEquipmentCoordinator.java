
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class reserveEquipmentCoordinator {
	public void coordinate(JFrame frame, int reserveItem){
				if(new reserveEquipmentLogic().reserved(reserveItem)){
					JOptionPane.showMessageDialog(frame, "Reserve Successful", "Reserve Equipment", JOptionPane.INFORMATION_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(frame, "Item is not available", "Reserve Equipment", JOptionPane.ERROR_MESSAGE);
				}

	}
}
