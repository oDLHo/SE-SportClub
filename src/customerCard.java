import java.util.List;

public class customerCard {
	
	private int customerNumber;
	private int cardNumber;
	private String expireDate;
	
	public customerCard(int cardID, List<String> cardRecords){
			this.customerNumber = Integer.parseInt(cardRecords.get(0));
			this.expireDate = cardRecords.get(1);
			this.cardNumber = cardID;
	}
	
	public int getCardNumber(){
		return this.cardNumber;
	}
	
	public int getCustomer(){
		return this.customerNumber;
	}
	
	public String getExpireDate(){
		return this.expireDate;
	}
}
