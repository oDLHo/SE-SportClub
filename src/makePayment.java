
public class makePayment {
	
	private payment payment = new payment();
	private equipmentOrder order = new equipmentOrder();
	
	
	
	
	public int createPayment(int orderNum){
		
		int customerID = order.getCustomerNumber(orderNum);
		int totalPrice = order.getTotalPrice(orderNum);
		int paymentId = 999;
		payment.createPaymentRecord(paymentId, customerID , orderNum, totalPrice);
		return paymentId;
	}
	
	public void confirmPayment(int paymentID) {
		
		cardReaderInterface cardReader = new cardReaderInterface();
		int creditcardID = cardReader.scanCreditCard();
		creditCardValidationService creditValidation = new creditCardValidationService();
		if(creditValidation.validate(creditcardID)){
			payment.paidPayment(paymentID);
			System.out.println("Pay money successful");
		}
		else{
			System.out.println("Invalid Credit Card");
		}
	}

}
