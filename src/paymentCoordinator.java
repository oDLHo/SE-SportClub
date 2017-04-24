import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class paymentCoordinator {
	private JFrame frame;
	private makePayment pay = new makePayment();
	private BufferedReader textReader;
	private Map<Integer,List<String>> paymentRecords = new HashMap<Integer,List<String>>();
	



	private void confirmPayment(payment paymentObj, int cardID) {
		creditCardValidationService creditValidation = new creditCardValidationService();
		if(creditValidation.cardValidate(cardID)){
			pay.confirmPayment(paymentObj);
		}
		else{
			JOptionPane.showMessageDialog(this.frame, "Credit Card is invalid", "Make Payment", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void coordinate(int orderID, int cusID, JFrame frame){
		this.frame = frame;
		try{
			readFile();
		} catch(IOException e){
			System.out.println(e.getMessage());
		}
		System.out.println(paymentRecords.toString());
		 int confirm = JOptionPane.showConfirmDialog(null, "Do you want to pay order: "+orderID+" ?","Confirm Payment",JOptionPane.YES_NO_OPTION);
		 
		 if(confirm == JOptionPane.YES_OPTION){
			 String insertCardID = JOptionPane.showInputDialog(null,"Insert Order ID : ","Make payment",JOptionPane.PLAIN_MESSAGE);
			System.out.println(insertCardID);
			confirmPayment(pay.createPayment(orderID,paymentRecords), Integer.parseInt(insertCardID));
			JOptionPane.showMessageDialog(frame, "Payment Successful", "Make Payment", JOptionPane.PLAIN_MESSAGE);
		 }else if(confirm == JOptionPane.NO_OPTION){
			 JOptionPane.showMessageDialog(this.frame, "Payment has terminated", "Confirm Payment", JOptionPane.ERROR_MESSAGE);
			 return ;
		 }
	}
	
	private void readFile() throws IOException{
		String line;
		
		textReader = new BufferedReader(new FileReader("./data/payment.txt"));
		
		while((line = textReader.readLine()) != null){
			List<String> recordDetails = new ArrayList<String>();
			String[] record = line.split(" ");
			int key = Integer.parseInt(record[0]);
			
			for(int i=1;i<record.length;i++){
				recordDetails.add(record[i]);
			}

			paymentRecords.put(key,recordDetails);
		}

	}
	
}
