import javax.swing.JFrame;

public class makePaymentSelection {
		paymentCoordinator paymentCoor = new paymentCoordinator();
		public void startSession(int orderID, int cusID, JFrame frame){
			paymentCoor.coordinate(orderID, cusID, frame);
		}
}
