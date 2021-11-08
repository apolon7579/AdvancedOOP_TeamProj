package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.GameRulePanel;
import view.MainFrame;
import view.MainNavigatorPanel;
import view.MainRetrievePanel;

public class MainNavigatorController {

	private MainFrame mainFrame;
	private MainNavigatorPanel mainNevigatorPanel;
	private MainRetrievePanel mainRetrievePanel;
	private GameRulePanel gameRulePanel;

	public MainNavigatorController(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		mainNevigatorPanel = mainFrame.getMainNevigatorPanel();
		mainRetrievePanel = mainFrame.getMainRetrievePanel();
		gameRulePanel = mainFrame.getGameRulePannel();
		eventInit();
	}

	public void eventInit() {
		mainNevigatorPanel.getExitBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		mainNevigatorPanel.getSearchBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainRetrievePanel.setVisible(true);
				mainNevigatorPanel.setVisible(false);
			}
		});

		mainNevigatorPanel.getGameBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//게임판넬 true
				mainNevigatorPanel.setVisible(false);
				gameRulePanel.setVisible(true);
			}
		});

	}
}
