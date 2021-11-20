package view;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.LoginController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import javax.swing.JCheckBox;

public class LoginPanel extends JPanel {

	private JTextField txtId;
	private JTextField txtPswdVisible;
	private JPasswordField txtPswdUnVisible;
	private JButton signInBtn;
	private JButton signUpBtn;
	private JTextField textField;
	private JTextField textField_1;
	private JCheckBox chckbxNewCheckBox;
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
		txtId.setText("");
		txtId.setFont(new Font("굴림", Font.PLAIN, 22));
		txtId.setBounds(425, 288, 155, 35);
		this.add(txtId);
		txtId.setColumns(10);

		txtPswdVisible = new JTextField();
		txtPswdVisible.setText("");
		txtPswdVisible.setFont(new Font("굴림", Font.PLAIN, 22));
		txtPswdVisible.setBounds(425, 337, 155, 35);
		this.add(txtPswdVisible);
		txtPswdVisible.setColumns(10);
		txtPswdVisible.setVisible(false);

		txtPswdUnVisible = new JPasswordField();
		txtPswdUnVisible.setText("");
		txtPswdUnVisible.setFont(new Font("굴림", Font.PLAIN, 22));
		txtPswdUnVisible.setBounds(425, 337, 155, 35);
		this.add(txtPswdUnVisible);
		txtPswdUnVisible.setColumns(10);
		txtPswdUnVisible.setVisible(true);

		signInBtn = new JButton("Sign in");
		signInBtn.setFont(new Font("굴림", Font.PLAIN, 22));
		signInBtn.setBounds(425, 404, 150, 35);
		this.add(signInBtn);

		signUpBtn = new JButton("Sigin up");
		signUpBtn.setFont(new Font("굴림", Font.PLAIN, 22));
		signUpBtn.setBounds(425, 448, 150, 35);
		this.add(signUpBtn);
		
		chckbxNewCheckBox = new JCheckBox("Show password");
		chckbxNewCheckBox.setBounds(425, 375, 155, 23);
		add(chckbxNewCheckBox);
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
		return txtPswdVisible.isVisible() ? txtPswdVisible.getText() : txtPswdUnVisible.getText();
	}
	
	public JCheckBox getCheckBox() {
		return chckbxNewCheckBox;
	}
	
	public JTextField getVisibleTextField() {
		return txtPswdVisible;
	}
	
	public JPasswordField getUnVisibleTextField() {
		return txtPswdUnVisible;
	}
}
