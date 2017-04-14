import java.util.List;
import java.util.Map;

public class customerValidation {

	Map<Integer,List<String>> cusRecords;
	Map<Integer,List<String>> cardRecords;
	
	public boolean validate(int cardNum){
		boolean validationStatus = false;
		customerValidation cusValidation = new customerValidation();
		
		if(cusValidation.validateCustomerCard(cardNum)){
			if(cusValidation.validateCustomer(new customerCard().getCustomer(cardNum))){
				validationStatus = true;
			}
		}
		
		return validationStatus;
	}
	
	private boolean validateCustomerCard(int cardNum) {
		customerCard card = new customerCard();
		cardRecords = card.getAllCard();
		
		if(cardRecords.containsKey(cardNum)){
			return true;
		}else{
			return false;
		}
	}

	private boolean validateCustomer(int customerNum) {
		customer cus = new customer();
		cusRecords = cus.getAllCustomer();
		
		if(cusRecords.containsKey(customerNum)){
			return true;
		}else{
			return false;
		}
	}

}
