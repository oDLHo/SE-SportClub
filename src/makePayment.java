
public class makePayment {
	
	private payment payment = new payment();
	private equipmentOrder order = new equipmentOrder();
	
	
	
	
	public int createPayment(int orderNum){
		
		int customerID = order.getCustomerNumber(orderNum);
		int totalPrice = order.getTotalPrice(orderNum);
		return payment.createPaymentRecord(customerID , orderNum, totalPrice);
	}
	
	public void confirmPayment(int paymentID) {
			payment.paidPayment(paymentID);
	}

}
