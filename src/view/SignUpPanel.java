package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.LoginController;

public class SignUpPanel extends JPanel {

	private JTextField idBtn;
	private JTextField pwdBtn;
	private JTextField pwdReBtn;
	private JButton signUpButton;

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

		idBtn = new JTextField();
		idBtn.setBounds(205, 107, 132, 30);
		this.add(idBtn);
		idBtn.setColumns(10);

		pwdBtn = new JTextField();
		pwdBtn.setColumns(10);
		pwdBtn.setBounds(205, 147, 132, 30);
		this.add(pwdBtn);

		JLabel lblPassword_1 = new JLabel("PASSWORD RE");
		lblPassword_1.setFont(new Font("굴림", Font.PLAIN, 25));
		lblPassword_1.setBounds(23, 187, 177, 30);
		this.add(lblPassword_1);

		pwdReBtn = new JTextField();
		pwdReBtn.setColumns(10);
		pwdReBtn.setBounds(205, 188, 132, 30);
		this.add(pwdReBtn);

		signUpButton = new JButton("Sign up");
		signUpButton.setFont(new Font("굴림", Font.PLAIN, 22));
		signUpButton.setBounds(162, 259, 175, 40);
		this.add(signUpButton);

	}

	public JButton getSignUpBtn() {
		return signUpButton;
	}

	public String getID() {
		return idBtn.getText();
	}

	public String getPWD() {
		return pwdReBtn.getText();
	}
}
