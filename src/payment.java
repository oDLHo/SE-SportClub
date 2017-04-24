import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class payment {

	private Date date = new Date();
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	private int paymentID;
	private int customerNum;
	private int orderNum;
	private int price;
	private boolean status;
	private String paidDate;
	
	public payment(int paymentNum, List<String> records){
		this.paymentID = paymentNum;
		this.customerNum = Integer.parseInt(records.get(0));
		this.orderNum = Integer.parseInt(records.get(1));
		this.price = Integer.parseInt(records.get(2));
		this.status = Boolean.valueOf(records.get(3));
		this.paidDate = records.get(4);
	}
	
	public int getPaymentNumber() { return this.paymentID; }
	
	public int getCustomerNumber() { return this.customerNum; }
	
	public int getEquipmentNumber() { return this.orderNum; }
	
	public int getTotalPrice() { return this.price; }
	
	public String getDate() { return this.paidDate; }
	
	public boolean getPaidStatus() { return this.status; }
	
	public void setStatus(boolean status){
		this.status = status;
		this.paidDate = dateFormat.format(date);
	}
	
}
