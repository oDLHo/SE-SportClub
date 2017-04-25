
import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
public class mainGUI {

	private JFrame frame;
	private JLabel lblSelectTheProcess;
	private JLabel lblHello;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	
	public mainGUI(int cusID) {
		initialize(cusID);
	}

	private void initialize(int cusID) {
		
		frame = new JFrame("Sport Club");
		frame.setBounds(new Rectangle(0, 0, 592, 374));
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		lblSelectTheProcess = new JLabel("Select the process");
		lblSelectTheProcess.setFont(new Font("Calibri", Font.BOLD, 24));
		lblSelectTheProcess.setBounds(188, 50, 185, 30);
		frame.getContentPane().add(lblSelectTheProcess);
		
		lblHello = new JLabel("Hello : "+ new customerList().findCustomer(cusID).getName());
		lblHello.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 16));
		lblHello.setBounds(10, 11, 238, 30);
		frame.getContentPane().add(lblHello);
		
		button = new JButton("Buy Equipment");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new buyEquipmentSelection().startSession(cusID);
			}
		});
		button.setBounds(25, 138, 154, 37);
		frame.getContentPane().add(button);
		
		button_1 = new JButton("Reserve Equipment");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new reserveEquipmentSelection().startSession();
			}
		});
		button_1.setBounds(199, 138, 167, 37);
		frame.getContentPane().add(button_1);
		
		button_2 = new JButton("Make Payment");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String insertOrderID = JOptionPane.showInputDialog(null,"Insert Order ID : ","Make payment",JOptionPane.PLAIN_MESSAGE);
				if(insertOrderID == null){
					
				}else{
					new makePaymentSelection().startSession(Integer.parseInt(insertOrderID) ,cusID, frame);
				}
			}
		});
		button_2.setBounds(393, 138, 153, 37);
		frame.getContentPane().add(button_2);
		frame.setVisible(true);
	}
}
