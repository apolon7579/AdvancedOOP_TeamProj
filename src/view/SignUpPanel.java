package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.LoginController;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUpPanel extends JPanel {

	private JTextField idBtn;
	private JTextField pwdBtn;
	private JTextField pwdReBtn;
	private JButton signUpButton;
	private JButton goBackButton;
	private JTextField nameBtn;

	public SignUpPanel() {
		setBounds(0, 0, 1030, 660);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Sign up");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 25));
		lblNewLabel.setBounds(455, 151, 85, 30);
		this.add(lblNewLabel);

		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("굴림", Font.PLAIN, 25));
		lblId.setBounds(273, 244, 22, 30);
		this.add(lblId);

		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("굴림", Font.PLAIN, 25));
		lblPassword.setBounds(273, 284, 138, 30);
		this.add(lblPassword);

		idBtn = new JTextField();
		idBtn.setBounds(475, 247, 132, 30);
		this.add(idBtn);
		idBtn.setColumns(10);

		pwdBtn = new JTextField();
		pwdBtn.setColumns(10);
		pwdBtn.setBounds(475, 287, 132, 30);
		this.add(pwdBtn);

		JLabel lblPassword_1 = new JLabel("PASSWORD RE");
		lblPassword_1.setFont(new Font("굴림", Font.PLAIN, 25));
		lblPassword_1.setBounds(273, 328, 177, 30);
		this.add(lblPassword_1);

		pwdReBtn = new JTextField();
		pwdReBtn.setColumns(10);
		pwdReBtn.setBounds(475, 328, 132, 30);
		this.add(pwdReBtn);

		signUpButton = new JButton("회원가입");
		signUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		signUpButton.setFont(new Font("굴림", Font.PLAIN, 22));
		signUpButton.setBounds(411, 404, 153, 40);
		this.add(signUpButton);
		
		goBackButton = new JButton("돌아가기");
		goBackButton.setFont(new Font("굴림", Font.PLAIN, 22));
		goBackButton.setBounds(816, 574, 145, 40);
		add(goBackButton);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("굴림", Font.PLAIN, 25));
		lblName.setBounds(273, 201, 79, 30);
		add(lblName);
		
		nameBtn = new JTextField();
		nameBtn.setColumns(10);
		nameBtn.setBounds(475, 204, 132, 30);
		add(nameBtn);

		setVisible(false);
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
		return pwdReBtn.getText();
	}

	public JButton getGoBackButton() {
		return goBackButton;
	}
}
