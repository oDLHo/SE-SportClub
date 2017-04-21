import java.util.Scanner;

import javax.swing.JFrame;
public class main {

	public static void main(String[] args){
		
		guiFrame window = new guiFrame("Sport Club");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
	}
	
	
//	public static void main(String[] args) {
//		int cusID,cardID,command;
//		String doSomethingElse;
//		boolean end = false;
//		Scanner scanners = new Scanner(System.in);
//		cardReaderInterface cardReader = new cardReaderInterface();
//		customerValidation cusValidation = new customerValidation();
//		System.out.println("Enter your customer card : ");
//		cardID = scanners.nextInt();
//		cardReader.scanCustomerCard(cardID);
//		
//		if(cusValidation.validate(cardID)){
//			cusID = new customerCard().getCustomer(cardID);
//			while(!end){
//				System.out.println("Select the number of menu");
//				System.out.println("0.Terminate process\n1.Buy sport equipment\n2.Reserve sport equipment\n3.Make payment");
//				System.out.println("What would you like to do? ");
//				command = scanners.nextInt();
//				if(command == 1){
//					new buyEquipmentSelection().startSession(cusID);
//				}
//				else if(command == 2){
//					new reserveEquipmentSelection().startSession();
//				}
//				else if(command == 3){
//					new makePaymentSelection().startSession();
//				}
//				else if(command == 0){
//					System.out.println("System is terminated!");
//					break;
//				}
//				
//				System.out.println("Do you want to do something else? (Y/N)");
//				doSomethingElse = scanners.next();
//				if(doSomethingElse.equals("y") || doSomethingElse.equals("Y")){
//					end = false;
//				}else {
//					System.out.println("Thank you to use our system.");
//					end = true;
//				}
//			}
//		}
//		else{
//			System.out.println("Customer card is invalid");
//		}
//		
//	}

}
