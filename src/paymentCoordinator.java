
public class paymentCoordinator {
	
	makePayment pay = new makePayment();
	int paymentID;
	
	public int makePayment(int orderNum) {
		return pay.createPayment(orderNum);
	}

	public void confirmPayment(int paymentID, int cardID) {
		pay.confirmPayment(paymentID, cardID);
	}
}
