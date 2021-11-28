package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import service.UserService;
import service.UserServiceImpl;
import view.GamePanel;
import view.LoginPanel;
import view.MainFrame;
import view.MainNavigatorPanel;
import view.SignUpPanel;

//로그인 컨트롤러
public class LoginController {

	private MainFrame mainFrame;
	private LoginPanel loginPanel;
	private SignUpPanel signUpPanel;
	private MainNavigatorPanel mainNavigatorPanel;
	private UserService userService = new UserServiceImpl();

	// LoginPanel의 초기화
	public LoginController(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.loginPanel = mainFrame.getLoginPanel();
		this.signUpPanel = mainFrame.getSinUpPanel();
		this.mainNavigatorPanel = mainFrame.getMainNevigatorPanel();
		eventInit();
	}

	//버튼 액션 리스너 초기화
	public void eventInit() {
		//로그인버튼
		loginPanel.getSignInBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean check = userService.loginByUserIdAndPassword(loginPanel.getID(), loginPanel.getPWD());

				if (check) {
					GamePanel.setLoginedUser(userService.retrievebyUserId(loginPanel.getID()));
					mainFrame.getCardLayout().show(mainFrame.getContentPane(), "mainNavigatorPanel");
					mainFrame.setJMenuBar(true);
					loginPanel.Clean();
				} else {
					JOptionPane.showMessageDialog(null, "계정을 찾을 수 없습니다.");
				}
			}
		});

		//회원가입버튼
		loginPanel.getSignUpBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getCardLayout().show(mainFrame.getContentPane(), "signUpPanel");
				loginPanel.Clean();
			}
		});
	
		//비밀번호 보이기 체크박스
		loginPanel.getCheckBox().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//체크박스 체크 되있는 경우 = show pwd
				if(loginPanel.getCheckBox().isSelected()) {
					loginPanel.getVisibleTextField().setText(loginPanel.getUnVisibleTextField().getText());
					loginPanel.getVisibleTextField().setVisible(true);
					loginPanel.getUnVisibleTextField().setVisible(false);
				}
				else {
					loginPanel.getUnVisibleTextField().setText(loginPanel.getVisibleTextField().getText());
					loginPanel.getVisibleTextField().setVisible(false);
					loginPanel.getUnVisibleTextField().setVisible(true);
				}
			}
		});
	}
}
