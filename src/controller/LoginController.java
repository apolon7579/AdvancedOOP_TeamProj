package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.LoginPanel;
import view.MainFrame;
import view.SignUpPanel;

public class LoginController{

	private MainFrame mainFrame;
	private LoginPanel loginPanel;
	private SignUpPanel signUpPanel;

	// User information Model Example
	String id = "1234";
	String pwd = "12345";

	public LoginController(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.loginPanel = mainFrame.getLoginPanel();
		this.signUpPanel = mainFrame.getSinUpPanel();
		eventInit();
	}

	public void eventInit() {
		loginPanel.getSignInBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Push Sign in Button!!");
				if (id.equals(loginPanel.getID()) && pwd.equals(loginPanel.getPWD())) {
					System.out.println("Login Success!!");
					System.out.println("Login Panel visible false");
				} else {
					System.out.println("Login Fail!!");
				}
			}
		});
		
		loginPanel.getSignUpBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				signUpPanel.setVisible(true);
				loginPanel.setVisible(false);
			}
		});
	}
}
