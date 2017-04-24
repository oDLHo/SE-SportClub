
import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class qqq {

	private JFrame frame;
	private customer cus;
	private JTable equipTable;
	private JTable ordersTable;
	private String columnName[] = new String[] {"ID", "Name", "Available", "Price"};
	private DefaultTableModel equipModel;
	private DefaultTableModel ordersModel;
	private Map<Integer, List<String>> catalogDetails = new HashMap<Integer,List<String>>();
	
	public qqq(int cusID) {
		initialize(cusID);
//		cus = new customer(cusID);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int cusID) {
		frame = new JFrame("'s Buy Equipment | Sport Club");
		frame.setBounds(new Rectangle(0, 0, 800, 1000));
		frame.getContentPane().setLayout(null);
		
		JScrollPane equipPanel = new JScrollPane();
		equipPanel.setBorder(null);
		equipPanel.setBounds(10, 48, 375, 183);
		frame.getContentPane().add(equipPanel);
		equipTable = new JTable();
		equipTable.setRowSelectionAllowed(false);
		equipPanel.setViewportView(equipTable);
		
		equipModel = new DefaultTableModel(0, 0);
		equipModel.setColumnIdentifiers(columnName);
		catalogDetails = new catalogService().getCatalog("sellEquipment");
		for (int key : catalogDetails.keySet()) {
	        equipModel.addRow(new Object[] { key ,catalogDetails.get(key).get(0), catalogDetails.get(key).get(1),
	        		catalogDetails.get(key).get(2) });
		}
		
		equipTable.setModel(equipModel);
		
		JLabel lblEquipments = new JLabel("Equipments");
		lblEquipments.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblEquipments.setBounds(130, 11, 96, 24);
		frame.getContentPane().add(lblEquipments);
		
		JScrollPane orderPanel = new JScrollPane();
		orderPanel.setBorder(null);
		orderPanel.setBounds(393, 48, 339, 183);
		frame.getContentPane().add(orderPanel);
		
		ordersTable = new JTable();
		ordersModel = (DefaultTableModel)ordersTable.getModel();
		ordersTable.setModel(new DefaultTableModel());
		ordersModel.addColumn(columnName);
		orderPanel.setViewportView(ordersTable);
		
		JLabel lblYourOrders = new JLabel("Your Orders\r\n");
		lblYourOrders.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblYourOrders.setBounds(511, 11, 108, 24);
		frame.getContentPane().add(lblYourOrders);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
