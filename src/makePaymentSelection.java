
public class makePaymentSelection {
	
	makePayment pay = new makePayment();
	int paymentID;
	
	public int makePayment(int orderNum) {
		return pay.createPayment(orderNum);
	}

	public void confirmPayment(int paymentID) {
		pay.confirmPayment(paymentID);
	}

}
