package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Button;

public class MFrame extends JFrame {
	private JTextField textField;
	private JTextField textField_1;

	//private JPanel contentPane;
	
	public MFrame() {
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		LoginPanel LoginPanel = new LoginPanel();
		getContentPane().add(LoginPanel);
		
		//setBounds(100, 100, 800, 600);
		//contentPane = new Test();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		//contentPane.setLayout(null);
	}	
}
