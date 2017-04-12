
public class cardReaderInterface {

	public void scanCustomerCard() {
		
		boolean validationStatus = false;
		customerValidation cusValidation = new customerValidation();
		
		if(cusValidation.validateCustomerCard()){
			if(cusValidation.validateCustomer()){
				validationStatus = true;
			}
		}
		
		
	}

	public int scanCreditCard() {
	
		int cardID = 20;
		
		return cardID;
	}
	
}
