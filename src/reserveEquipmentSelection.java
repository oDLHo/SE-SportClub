import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class reserveEquipmentSelection {
	private JTable equipTable;
	private JFrame frame;
	private String columnName[] = new String[] {"ID", "Name", "Available"};
	private DefaultTableModel equipModel;
	private Map<Integer, List<String>> catalogDetails = new HashMap<Integer,List<String>>();
	private reserveEquipmentCoordinator reserveCoor = new reserveEquipmentCoordinator();
	
	public void startSession(){
		frame = new JFrame("'s Buy Equipment | Sport Club");
		frame.setBounds(new Rectangle(0, 0, 410, 530));
		frame.getContentPane().setLayout(null);
		
		JScrollPane equipPanel = new JScrollPane();
		equipPanel.setBorder(null);
		equipPanel.setBounds(10, 48, 375, 234);
		frame.getContentPane().add(equipPanel);
		equipTable = new JTable();
		equipTable.setRowSelectionAllowed(false);
		equipPanel.setViewportView(equipTable);
		
		equipModel = new DefaultTableModel(0, 0);
		equipModel.setColumnIdentifiers(columnName);
		catalogDetails = new catalogService().getCatalog("reserveEquipment");
		for (int key : catalogDetails.keySet()) {
	        equipModel.addRow(new Object[] { key ,catalogDetails.get(key).get(0), catalogDetails.get(key).get(1)});
		}
		
		equipTable.setModel(equipModel);
		
		JLabel lblEquipments = new JLabel("Equipments");
		lblEquipments.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblEquipments.setBounds(130, 11, 96, 24);
		frame.getContentPane().add(lblEquipments);
		
		JPanel reservePanel = new JPanel();
		reservePanel.setBorder(new TitledBorder(null, "Reserve Item", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		reservePanel.setBounds(94, 313, 194, 143);
		frame.getContentPane().add(reservePanel);
		reservePanel.setLayout(null);
		
		JButton btnReserve = new JButton("Reserve");
		btnReserve.setBounds(56, 96, 89, 23);
		reservePanel.add(btnReserve);
		
		Vector comboBoxItems = new Vector();
		for(int key : catalogDetails.keySet()){
			comboBoxItems.add(key+ " "+ catalogDetails.get(key).get(0));
		}
		
		JComboBox itemList = new JComboBox(comboBoxItems);
		itemList.setBounds(36, 62, 125, 20);
		reservePanel.add(itemList);
		
		JLabel lblSelect = new JLabel("Select Equipments");
		lblSelect.setBounds(22, 27, 162, 24);
		reservePanel.add(lblSelect);
		lblSelect.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		btnReserve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedItem = (String) itemList.getSelectedItem();
				String[] item = selectedItem.split(" ");
				reserveCoor.coordinate(frame, Integer.parseInt(item[0]));
			}
		});
		

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
