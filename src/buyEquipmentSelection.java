import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class buyEquipmentSelection {
	
	private buyEquipmentCoordinator buyCoor = new buyEquipmentCoordinator();
	private JFrame frame;
	private JTable equipTable;
	private JTable ordersTable;
	private String columnName[] = new String[] {"ID", "Name", "Available", "Price"};
	private DefaultTableModel equipModel;
	private DefaultTableModel ordersModel;
	private Map<Integer, List<String>> catalogDetails = new HashMap<Integer,List<String>>();
	private List<Integer> items = new ArrayList<Integer>();
	private Vector comboBoxItems = new Vector();
	
	public void startSession(int cusID){

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
		ordersTable.setRowSelectionAllowed(false);
		orderPanel.setViewportView(ordersTable);
		
		ordersModel = new DefaultTableModel(0, 0);
		ordersModel.setColumnIdentifiers(columnName);
		ordersTable.setModel(ordersModel);
		
		JLabel lblYourOrders = new JLabel("Your Orders\r\n");
		lblYourOrders.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblYourOrders.setBounds(511, 11, 108, 24);
		frame.getContentPane().add(lblYourOrders);
		
		
		for(int key : catalogDetails.keySet()){
			comboBoxItems.add(key+ " "+ catalogDetails.get(key).get(0));
		}
		
		JPanel addPanel = new JPanel();
		addPanel.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		addPanel.setBounds(33, 242, 227, 144);
		frame.getContentPane().add(addPanel);
		addPanel.setLayout(null);
		JComboBox comboBox = new JComboBox(comboBoxItems);
		comboBox.setBounds(20, 56, 186, 20);
		addPanel.add(comboBox);
		
		JLabel lblSelectEquipment = new JLabel("Select Equipment");
		lblSelectEquipment.setBounds(59, 31, 102, 14);
		addPanel.add(lblSelectEquipment);
		
		JButton btnAddToOrders = new JButton("Add to Orders");
		btnAddToOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String selectedItem = (String) comboBox.getSelectedItem();
				String[] item = selectedItem.split(" ");
        		ordersModel.addRow(new Object[] { Integer.parseInt(item[0]) ,catalogDetails.get(Integer.parseInt(item[0])).get(0), catalogDetails.get(Integer.parseInt(item[0])).get(1),
                		catalogDetails.get(Integer.parseInt(item[0])).get(2) });
        		items.add(Integer.parseInt(item[0]));
        		System.out.print(items.toString());
			}
		});
		btnAddToOrders.setBounds(45, 98, 123, 23);
		addPanel.add(btnAddToOrders);
		
		JButton btnCreateOrder = new JButton("Create Order");
		btnCreateOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyCoor.coordinate(cusID, items,frame);
				frame.setVisible(false);
				new mainGUI(cusID);
			}
		});
		btnCreateOrder.setBounds(485, 278, 156, 23);
		frame.getContentPane().add(btnCreateOrder);
		
		JButton btnCancel = new JButton("Cancel order");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				frame.setVisible(false);
				new mainGUI(cusID);
			}
		});
		btnCancel.setBounds(485, 312, 156, 23);
		frame.getContentPane().add(btnCancel);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
