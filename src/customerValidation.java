import java.util.List;
import java.util.Map;

public class customerValidation {

	Map<Integer,List<String>> cusRecords;
	Map<Integer,List<String>> cardRecords;
	
	
	public boolean validate(int cardNum){
		boolean validationStatus = false;
		
		if(validateCustomerCard(cardNum)){
			if(validateCustomer(new customerCard(cardNum).getCustomer())){
				validationStatus = true;
			}
		}
		
		return validationStatus;
	}
	
	private boolean validateCustomerCard(int cardNum) {
		try{
			customerCard card = new customerCard(cardNum);
			System.out.println(card.getCustomer());
			return true;
		}catch(NullPointerException e){
			System.out.print(e.getMessage());
			return false;
		}
	}

	private boolean validateCustomer(int customerNum) {
		try{
			customer cus = new customer(customerNum);
			System.out.println(cus.getName());
			return true;
		}catch(NullPointerException e){
			System.out.print(e.getMessage());
			return false;
		}
	}

}
