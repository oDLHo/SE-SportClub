import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class paymentCoordinator {
	private JFrame frame;
	private makePaymentLogic pay = new makePaymentLogic();
	private paymentList paymentList = new paymentList();
	
	private boolean confirmPayment(int paymentID, int cardID) {
		creditCardValidationService creditValidation = new creditCardValidationService();
		if(creditValidation.cardValidate(cardID)){
			pay.confirmPayment(paymentID);
			return true;
		}
		else{
			JOptionPane.showMessageDialog(this.frame, "Credit Card is invalid", "Make Payment", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	public void coordinate(int orderID, int cusID, JFrame frame){
		this.frame = frame;
		int confirm = JOptionPane.showConfirmDialog(null, "Do you want to pay order: "+orderID+" ?","Confirm Payment",JOptionPane.YES_NO_OPTION);
		 
		if(confirm == JOptionPane.YES_OPTION){
			String insertCardID = JOptionPane.showInputDialog(null,"Insert Credit Card : ","Make payment",JOptionPane.PLAIN_MESSAGE);
			int paymentID = pay.createPayment(orderID);
			if(paymentID != 0){
				if(confirmPayment(paymentID, Integer.parseInt(insertCardID))){
					JOptionPane.showMessageDialog(this.frame, "Payment Successful", "Make Payment", JOptionPane.PLAIN_MESSAGE);
				}
			}else{
				JOptionPane.showMessageDialog(this.frame, "Payment has terminated", "Confirm Payment", JOptionPane.ERROR_MESSAGE);
			}
		}else if(confirm == JOptionPane.NO_OPTION){
			JOptionPane.showMessageDialog(this.frame, "Payment has terminated", "Confirm Payment", JOptionPane.ERROR_MESSAGE);
			return ;
		}
	}
	
}
