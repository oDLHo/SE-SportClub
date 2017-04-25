public class makePaymentLogic {
	private paymentList paymentList = new paymentList();
	private orderList orderLists = new orderList();

	
	public void confirmPayment(int paymentNum) {
			paidPayment(paymentNum);
	}
	
	private void paidPayment(int paymentNum){
		paymentList.setPaymentStatus(paymentNum,true);
	}
	
	public int createPayment(int orderNum){
		if(orderLists.findOrder(orderNum) != null ){
			int customerID = orderLists.findOrder(orderNum).getCustomerNumber();
			float totalPrice = orderLists.findOrder(orderNum).getTotalPrice();
			return paymentList.createPayment(customerID , orderNum, totalPrice);
		}else{
			return 0;
		}
	}
}
