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
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;

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
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 50));
		lblNewLabel.setBounds(347, 10, 400, 219);
		this.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		lblNewLabel_1.setBounds(357, 206, 270, 26);
		this.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		lblNewLabel_2.setBounds(357, 284, 270, 26);
		this.add(lblNewLabel_2);

		txtId = new JTextField();
		txtId.setText("");
		txtId.setFont(new Font("굴림", Font.PLAIN, 22));
		txtId.setBounds(357, 239, 270, 35);
		this.add(txtId);
		txtId.setColumns(10);

		txtPswdVisible = new JTextField();
		txtPswdVisible.setText("");
		txtPswdVisible.setFont(new Font("굴림", Font.PLAIN, 22));
		txtPswdVisible.setBounds(357, 320, 270, 35);
		this.add(txtPswdVisible);
		txtPswdVisible.setColumns(10);
		txtPswdVisible.setVisible(false);

		txtPswdUnVisible = new JPasswordField();
		txtPswdUnVisible.setText("");
		txtPswdUnVisible.setFont(new Font("굴림", Font.PLAIN, 22));
		txtPswdUnVisible.setBounds(357, 320, 270, 35);
		this.add(txtPswdUnVisible);
		txtPswdUnVisible.setColumns(10);
		txtPswdUnVisible.setVisible(true);

		signInBtn = new JButton("Sign in");
		signInBtn.setBackground(UIManager.getColor("Button.light"));
		signInBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		signInBtn.setBounds(357, 405, 270, 35);
		this.add(signInBtn);

		signUpBtn = new JButton("Sign up");
		signUpBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		signUpBtn.setBounds(357, 448, 270, 35);
		this.add(signUpBtn);
		
		chckbxNewCheckBox = new JCheckBox("Show password");
		chckbxNewCheckBox.setBounds(357, 361, 155, 23);
		add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_3 = new JLabel("와! 나라위키");
		lblNewLabel_3.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 50));
		lblNewLabel_3.setBounds(353, 16, 400, 219);
		add(lblNewLabel_3);
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
	
	public void Clean() {
		//씬이 바뀔때 text에 저장된 값을 비워줌 약간 소멸자 느낌
		txtId.setText("");
		txtPswdUnVisible.setText("");
		txtPswdVisible.setText("");
	}
}
