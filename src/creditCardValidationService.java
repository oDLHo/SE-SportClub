public class creditCardValidationService {
	
	private creditCardList cardList = new creditCardList();

	
	public boolean cardValidate(int creditcardID) {
		return cardList.findCreditCard(creditcardID);
	}
}
