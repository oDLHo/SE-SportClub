import java.util.List;

public class customer {
	
	private int customerNumber;
	private String firstName;
	private String lastName;
	private String gender;
	
	public customer(int customerNum, List<String> customerRecords){
		this.customerNumber = customerNum;	
		this.firstName = customerRecords.get(0);
		this.lastName = customerRecords.get(1);
		this.gender = customerRecords.get(2);
	}

	public int getCustomerNumber(){
		return this.customerNumber;
	}
	
	public String getName(){
		String fullName = this.firstName + " " + this.lastName;
		return fullName;
	}
	
	public String getGender(){
		return this.gender;
	}
}
