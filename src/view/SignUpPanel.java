package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.LoginController;

public class SignUpPanel extends JPanel {

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnNewButton;

	public SignUpPanel() {
		setBounds(320, 200, 517, 398);
		setLayout(null);
		setVisible(false);

		JLabel lblNewLabel = new JLabel("Sign up");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 25));
		lblNewLabel.setBounds(205, 10, 85, 30);
		this.add(lblNewLabel);

		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("굴림", Font.PLAIN, 25));
		lblId.setBounds(178, 107, 22, 30);
		this.add(lblId);

		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("굴림", Font.PLAIN, 25));
		lblPassword.setBounds(62, 147, 138, 30);
		this.add(lblPassword);

		textField = new JTextField();
		textField.setBounds(205, 107, 132, 30);
		this.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(205, 147, 132, 30);
		this.add(textField_1);

		JLabel lblPassword_1 = new JLabel("PASSWORD RE");
		lblPassword_1.setFont(new Font("굴림", Font.PLAIN, 25));
		lblPassword_1.setBounds(23, 187, 177, 30);
		this.add(lblPassword_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(205, 188, 132, 30);
		this.add(textField_2);

		btnNewButton = new JButton("Sign up");
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 22));
		btnNewButton.setBounds(162, 259, 175, 40);
		this.add(btnNewButton);

	}

	public void setBtnListener(LoginController l) {
		btnNewButton.addActionListener(l);
	}

	public JButton getSignUpBtn() {
		return btnNewButton;
	}

	public String getID() {
		return textField.getText();
	}

	public String getPWD() {
		return textField_2.getText();
	}
}
