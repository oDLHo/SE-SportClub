import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.FlowLayout;

import javax.swing.JButton;
public class guiFrame extends JFrame{
	public static final int WIDTH = 500;
	public static final int HEIGHT = 400;
	
	guiFrame(String name){
		setTitle(name);
		setSize(WIDTH,HEIGHT);
		JLabel lb1 = new JLabel("Select The Process");
		JButton bn1 = new JButton("Buy Equipment");
		JButton bn2 = new JButton("Reserve Equipment");
		JButton bn3 = new JButton("Make Payment");
		this.setLayout(new FlowLayout());
		this.add(lb1);
		this.add(bn1);
		this.add(bn2);
		this.add(bn3);
		
	}
	
	
}
