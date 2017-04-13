import java.util.Scanner;
public class main {

	
	public static void main(String[] args) {
		int orderID, paymentID, cardID;
		String command;
		Scanner scaners = new Scanner(System.in);
		cardReaderInterface cardReader = new cardReaderInterface();
		cardReader.scanCustomerCard(1);
	}

}
