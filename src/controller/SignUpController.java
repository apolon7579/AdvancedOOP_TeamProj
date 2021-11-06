package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.LoginPanel;
import view.MainFrame;
import view.SignUpPanel;

public class SignUpController {

	private MainFrame mainFrame;
	private LoginPanel loginPanel;
	private SignUpPanel signUpPanel;
	
	public SignUpController(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.loginPanel = mainFrame.getLoginPanel();
		this.signUpPanel = mainFrame.getSinUpPanel();
		eventInit();
	}
	
	private void eventInit() {
		signUpPanel.getSignUpBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				signUpPanel.setVisible(false);
				loginPanel.setVisible(true);
			}
		});
	}
}
