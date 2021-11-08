package view;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.LoginController;

public class LoginPanel extends JPanel {

	private JTextField txtId;
	private JTextField txtPswd;
	private JButton signInBtn;
	private JButton signUpBtn;

	public LoginPanel() {
		setBounds(0, 0, 1030, 660);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("\uC640! \uB098\uB77C\uC704\uD0A4");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 50));
		lblNewLabel.setBounds(332, 45, 400, 219);
		this.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(388, 295, 18, 26);
		this.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(302, 341, 111, 26);
		this.add(lblNewLabel_2);

		txtId = new JTextField();
		txtId.setText("test");
		txtId.setFont(new Font("굴림", Font.PLAIN, 22));
		txtId.setBounds(425, 288, 155, 35);
		this.add(txtId);
		txtId.setColumns(10);

		txtPswd = new JTextField();
		txtPswd.setText("test");
		txtPswd.setFont(new Font("굴림", Font.PLAIN, 22));
		txtPswd.setBounds(425, 337, 155, 35);
		this.add(txtPswd);
		txtPswd.setColumns(10);

		signInBtn = new JButton("Sign in");
		signInBtn.setFont(new Font("굴림", Font.PLAIN, 22));
		signInBtn.setBounds(425, 404, 150, 35);
		this.add(signInBtn);

		signUpBtn = new JButton("Sigin up");
		signUpBtn.setFont(new Font("굴림", Font.PLAIN, 22));
		signUpBtn.setBounds(425, 448, 150, 35);
		this.add(signUpBtn);

		
	}

	public JButton getSignInBtn() {
		return signInBtn;
	}

	public JButton getSignUpBtn() {
		return signUpBtn;
	}

	public String getID() {
		return txtId.getText();
	}

	public String getPWD() {
		return txtPswd.getText();
	}

}
