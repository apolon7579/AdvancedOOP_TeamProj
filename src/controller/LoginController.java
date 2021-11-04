package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import service.UserService;
import service.UserServiceImpl;
import view.LoginPanel;
import view.MainFrame;
import view.MainNavigatorPanel;
import view.MainRetrievePanel;
import view.SignUpPanel;

public class LoginController {

	private MainFrame mainFrame;
	private LoginPanel loginPanel;
	private SignUpPanel signUpPanel;
	private MainNavigatorPanel mainNavigatorPanel;
	private UserService userService = new UserServiceImpl();

	// LoginPanel의 이베
	public LoginController(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.loginPanel = mainFrame.getLoginPanel();
		this.signUpPanel = mainFrame.getSinUpPanel();
		this.mainNavigatorPanel = mainFrame.getMainNevigatorPanel();
		eventInit();
	}

	public void eventInit() {
		loginPanel.getSignInBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//이중화 드라이버 연결 실패 예외처리 나서 우선 true로 테스트
				//boolean check = userService.loginByUserIdAndPassword(loginPanel.getID(), loginPanel.getPWD());

				if (true) {
					loginPanel.setVisible(false);
					mainNavigatorPanel.setVisible(true);
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
