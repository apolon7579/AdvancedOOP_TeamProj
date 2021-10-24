package view;

import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.LoginController;
import controller.TestController;

import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class LoginPanel extends JPanel {
	
	private LoginController _lc;
	
	public LoginPanel() {
		setLayout(null);
		setBounds(30, 30, 400, 400);
		//check panel size
		setBackground(Color.BLUE);
	
		
		JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514");
		lblNewLabel.setBounds(80, 134, 57, 15);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uD328\uC2A4\uC6CC\uB4DC");
		lblNewLabel_1.setBounds(80, 162, 57, 15);
		add(lblNewLabel_1);
		
		JTextField textField = new JTextField();
		textField.setBounds(137, 131, 116, 21);
		add(textField);
		textField.setColumns(10);
		
		JTextField textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(137, 159, 116, 21);
		add(textField_1);
		
		JButton btnNewButton = new JButton("\uB85C\uADF8\uC778");
		btnNewButton.setBounds(147, 190, 97, 23);
		add(btnNewButton);
		btnNewButton.addActionListener(_lc);
		
		JLabel lblNewLabel_2 = new JLabel("\uC640!\uB098\uB77C\uC704\uD0A4");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 34));
		lblNewLabel_2.setBounds(121, 33, 212, 83);
		add(lblNewLabel_2);
		
		JButton btnNewButton2 = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnNewButton2.setBounds(146, 222, 97, 23);
		add(btnNewButton2);
		btnNewButton2.addActionListener(_lc);
	}
}
