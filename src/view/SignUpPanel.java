package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.LoginController;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.Color;

public class SignUpPanel extends JPanel {

	private JTextField idBtn;
	private JTextField pwdBtn;
	private JTextField pwdReBtn;
	private JPasswordField pwdBtn2;
	private JPasswordField pwdReBtn2;
	private JButton signUpButton;
	private JButton goBackButton;
	private JTextField nameBtn;
	private JCheckBox chckbxNewCheckBox;

	public SignUpPanel() {
		setBounds(0, 0, 1030, 660);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Sign up");
		lblNewLabel.setFont(new Font("나눔고딕", Font.BOLD, 30));
		lblNewLabel.setBounds(318, 171, 219, 40);
		this.add(lblNewLabel);

		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("나눔고딕", Font.BOLD, 22));
		lblId.setBounds(318, 290, 22, 30);
		this.add(lblId);

		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("나눔고딕", Font.BOLD, 22));
		lblPassword.setBounds(318, 330, 138, 30);
		this.add(lblPassword);

		idBtn = new JTextField();
		idBtn.setBounds(520, 293, 132, 30);
		this.add(idBtn);
		idBtn.setColumns(10);

		pwdBtn = new JTextField();
		pwdBtn.setColumns(10);
		pwdBtn.setBounds(520, 333, 132, 30);
		this.add(pwdBtn);
		pwdBtn.setVisible(false);

		pwdBtn2 = new JPasswordField();
		pwdBtn2.setColumns(10);
		pwdBtn2.setBounds(520, 333, 132, 30);
		this.add(pwdBtn2);
		pwdBtn2.setVisible(true);

		JLabel lblPassword_1 = new JLabel("PASSWORD RE");
		lblPassword_1.setFont(new Font("나눔고딕", Font.BOLD, 22));
		lblPassword_1.setBounds(318, 374, 177, 30);
		this.add(lblPassword_1);

		pwdReBtn = new JTextField();
		pwdReBtn.setColumns(10);
		pwdReBtn.setBounds(520, 374, 132, 30);
		this.add(pwdReBtn);
		pwdReBtn.setVisible(false);

		pwdReBtn2 = new JPasswordField();
		pwdReBtn2.setColumns(10);
		pwdReBtn2.setBounds(520, 374, 132, 30);
		this.add(pwdReBtn2);
		pwdReBtn2.setVisible(true);

		signUpButton = new JButton("회원가입");
		signUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		signUpButton.setFont(new Font("나눔고딕", Font.BOLD, 22));
		signUpButton.setBounds(418, 439, 153, 40);
		this.add(signUpButton);

		goBackButton = new JButton("돌아가기");
		goBackButton.setFont(new Font("나눔고딕", Font.BOLD, 22));
		goBackButton.setBounds(418, 489, 153, 40);
		add(goBackButton);

		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("나눔고딕", Font.BOLD, 22));
		lblName.setBounds(318, 247, 79, 30);
		add(lblName);

		nameBtn = new JTextField();
		nameBtn.setColumns(10);
		nameBtn.setBounds(520, 250, 132, 30);
		add(nameBtn);

		chckbxNewCheckBox = new JCheckBox("Show password");
		chckbxNewCheckBox.setBounds(520, 410, 132, 23);
		add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_1 = new JLabel("와! 나라위키");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 50));
		lblNewLabel_1.setBounds(347, 10, 400, 219);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("와! 나라위키");
		lblNewLabel_3.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 50));
		lblNewLabel_3.setBounds(353, 16, 400, 219);
		add(lblNewLabel_3);

		setVisible(false);
	}

	public JCheckBox getCheckBox() {
		return chckbxNewCheckBox;
	}

	public JTextField[] getVisibleTextField() {
		JTextField[] arr = { pwdBtn, pwdReBtn };
		return arr;
	}

	public JPasswordField[] getUnVisibleTextField() {
		JPasswordField[] arr = { pwdBtn2, pwdReBtn2 };
		return arr;
	}

	public JButton getSignUpBtn() {
		return signUpButton;
	}

	public String getName() {
		return nameBtn.getText();
	}

	public String getID() {
		return idBtn.getText();
	}

	public String getPWD() {
		return pwdReBtn2.getText();
	}

	public JButton getGoBackButton() {
		return goBackButton;
	}

	public void Clean() {
		// 씬이 바뀔때 text에 저장된 값을 비워줌 약간 소멸자 느낌
		idBtn.setText("");
		nameBtn.setText("");
		pwdBtn.setText("");
		pwdBtn2.setText("");
		pwdReBtn.setText("");
		pwdReBtn2.setText("");
	}
}
