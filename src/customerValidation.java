public class customerValidation {
	
	private customerList cusList = new customerList();
	private customerCardList cusCardList = new customerCardList();
	
	public boolean validate(int cardNum){
		boolean validationStatus = false;

		if(validateCustomerCard(cardNum)){
			if(validateCustomer(cusCardList.findCard(cardNum).getCustomer())){
				validationStatus = true;
			}
		}
		
		return validationStatus;
	}
	
	private boolean validateCustomerCard(int cardNum) {
		if(cusCardList.findCard(cardNum) != null){
			return true;
		}else{
			return false;
		}
	}

	private boolean validateCustomer(int customerNum) {
			if(cusList.findCustomer(customerNum) != null){
				return true;
			}else{
				return false;
			}
	}

}
