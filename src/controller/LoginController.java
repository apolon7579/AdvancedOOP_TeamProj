package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import service.UserService;
import service.UserServiceImpl;
import view.LoginPanel;
import view.MainFrame;
import view.MainRetrievePanel;
import view.SignUpPanel;

public class LoginController{

	private MainFrame mainFrame;
	private LoginPanel loginPanel;
	private SignUpPanel signUpPanel;
	private MainRetrievePanel mainRetrievePanel;
	private UserService userService = new UserServiceImpl();
	

	//LoginPanel의 이베
	public LoginController(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.loginPanel = mainFrame.getLoginPanel();
		this.signUpPanel = mainFrame.getSinUpPanel();
		this.mainRetrievePanel = mainFrame.getMainRetrievePanel();
		eventInit();
	}

	public void eventInit() {
		loginPanel.getSignInBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean check = userService.userLogin(loginPanel.getID(), loginPanel.getPWD());
				
				if (check) {
					loginPanel.setVisible(false);
					mainRetrievePanel.setVisible(true);		
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
