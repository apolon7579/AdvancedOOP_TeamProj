package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.LoginPanel;
import view.SignUpPanel;

public class LoginController implements ActionListener {

	private LoginPanel _loginPanel;
	private SignUpPanel _signUpPanel;

	// User information Model Example
	String id = "1234";
	String pwd = "12345";

	public LoginController(LoginPanel p1, SignUpPanel p2) {
		_loginPanel = p1;
		_signUpPanel = p2;

		_loginPanel.setBtnListener(this);
		_signUpPanel.setBtnListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (_loginPanel.isVisible()) {
			if (e.getSource() == _loginPanel.getSignInBtn()) {
				System.out.println("Push Sign in Button!!");
				if (id.equals(_loginPanel.getID()) && pwd.equals(_loginPanel.getPWD())) {
					System.out.println("Login Success!!");
					System.out.println("Login Panel visible false");
					_loginPanel.setVisible(false);
				} else {
					System.out.println("Login Fail!!");
				}
			} else if (e.getSource() == _loginPanel.getSignUpBtn()) {
				System.out.println("Push Sign up Button!!");
				System.out.println("Pop Up Sign up Panel plz");
				_signUpPanel.setVisible(true);
				_loginPanel.setVisible(false);
			}
		}
		if (_signUpPanel.isVisible()) {
			if (e.getSource() == _signUpPanel.getSignUpBtn()) {
				id = _signUpPanel.getID();
				pwd = _signUpPanel.getPWD();
				_signUpPanel.setVisible(false);
				_loginPanel.setVisible(true);
			}
		}
	}

}
