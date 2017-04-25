import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class cardReaderInterface {
	
	private JFrame frame;
	private JTextField cardInput;
	private JLabel lblInsertCardNumber;
	private JButton btnValidate;
	private JPanel panel;
	private int cardID;
	private boolean cardStatus;
	
	public cardReaderInterface(){
		readCustomerCard();
	}
	
	private void readCustomerCard(){
		frame = new JFrame("Sport Club");
		frame.setBounds(new Rectangle(0, 0, 350, 170));
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Card Reader", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(37, 4, 261, 112);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		cardInput = new JTextField();
		cardInput.setBounds(29, 41, 202, 20);
		panel.add(cardInput);
		cardInput.setColumns(10);
		
		lblInsertCardNumber = new JLabel("Insert Card Number");
		lblInsertCardNumber.setBounds(79, 16, 102, 14);
		panel.add(lblInsertCardNumber);
		
		btnValidate = new JButton("Validate");
		btnValidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardID = scanCard(Integer.parseInt(cardInput.getText()));
				cardStatus = new customerValidation().validate(cardID);
				if(cardStatus){
					frame.dispose();
					new mainGUI(new customerCardList().findCard(cardID).getCustomer());
				}else{
					JOptionPane.showMessageDialog(frame,"Invalid card number. Plese enter a correct card number","Card number is not valid.",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnValidate.setBounds(79, 72, 89, 23);
		panel.add(btnValidate);
		frame.setVisible(true);
	}
	
	private int scanCard(int cardNum) {
		return cardNum;
	}
	
}
