import java.util.Scanner;

public class makePaymentSelection {
	
	int orderID, paymentID, cardID;
	String command;
	Scanner scaners = new Scanner(System.in);
	paymentCoordinator paymentCoor = new paymentCoordinator();
	
	public void startSession(){
		System.out.println("Enter Order Number : ");
		 orderID = scaners.nextInt();
		 paymentID = paymentCoor.makePayment(orderID);
		 
		 System.out.println("Do you want to pay Order : "+orderID+"?(Y/N)");
		 command = scaners.next();
		 if(command.equals("y")||command.equals("Y")){
			 System.out.println("Insert your credit card (cardID) : ");
			 cardID = scaners.nextInt();
			 paymentCoor.confirmPayment(paymentID, cardID);
		 } else {
			 System.out.println("Cancel the payment!!");
		 }
	}

}
