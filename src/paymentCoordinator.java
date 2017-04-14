import java.util.Scanner;

public class paymentCoordinator {
	
	private makePayment pay = new makePayment();
	private int orderID, paymentID, cardID;
	private String command;
	private Scanner scaners = new Scanner(System.in);
	
	private int makePayment(int orderNum) {
		return pay.createPayment(orderNum);
	}

	private void confirmPayment(int paymentID, int cardID) {
		cardReaderInterface cardReader = new cardReaderInterface();
		int creditcardID = cardReader.scanCreditCard(cardID);
		creditCardValidationService creditValidation = new creditCardValidationService();
		if(creditValidation.cardValidate(creditcardID)){
			pay.confirmPayment(paymentID);
			System.out.println("Pay money successful");
		}
		else{
			System.out.println("Invalid Credit Card");
		}
	}
	
	public void coordinate(){
		System.out.println("Enter Order Number : ");
		 orderID = scaners.nextInt();
		 paymentID = makePayment(orderID);
		 
		 System.out.println("Do you want to pay Order : "+orderID+"?(Y/N)");
		 command = scaners.next();
		 if(command.equals("y")||command.equals("Y")){
			 System.out.println("Insert your credit card (cardID) : ");
			 cardID = scaners.nextInt();
			 confirmPayment(paymentID, cardID);
		 } else {
			 System.out.println("Cancel the payment!!");
		 }
	}
}
