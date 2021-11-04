package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import service.UserService;
import service.UserServiceImpl;
import view.LoginPanel;
import view.MainFrame;
import view.MainNavigatorPanel;
import view.SignUpPanel;

public class MainNavigatorController {

	private MainFrame mainFrame;
	private MainNavigatorPanel mainNevigatorPanel;

	public MainNavigatorController(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		mainNevigatorPanel = mainFrame.getMainNevigatorPanel();
		eventInit();
	}

	public void eventInit() {
		mainNevigatorPanel.getExitBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("qwe");
				System.exit(0);
			}
		});
	}
}
