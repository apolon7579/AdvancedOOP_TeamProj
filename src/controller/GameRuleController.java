package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.GameRulePanel;
import view.MainFrame;

public class GameRuleController {
	private GameRulePanel panel;
	private MainFrame mainFrame;

	public GameRuleController(MainFrame mainFrame) {
		panel = mainFrame.getGameRulePannel();
		this.mainFrame = mainFrame;
		eventInit();
	}
	
	private void eventInit() {
		panel.getBackBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getCardLayout().show(mainFrame.getContentPane(), "mainNavigatorPanel");
			}
		});

		panel.getStartBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				mainFrame.getCardLayout().show(mainFrame.getContentPane(), "gamePanel");
			}
		});
	}
}
