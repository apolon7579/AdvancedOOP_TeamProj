package view;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.TestController;

public class Test extends JPanel {
	
	private JButton btnNewButton;
	private TestController controller;
	
	public Test() {		
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		btnNewButton = new JButton("New button");
		btnNewButton.setBounds(588, 503, 97, 23);
		add(btnNewButton);
		
		controller = new TestController(this);
	}
	
	public JButton getJButton() {
		return this.btnNewButton;
	}
}
