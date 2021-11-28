package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.GameRulePanel;
import view.MainFrame;

//업다운 게임 룰 설명 패널의 컨트롤러
public class GameRuleController {
	private GameRulePanel panel;
	private MainFrame mainFrame;

	//초기화
	public GameRuleController(MainFrame mainFrame) {
		panel = mainFrame.getGameRulePannel();
		this.mainFrame = mainFrame;
		eventInit();
	}
	
	//버튼 액션 리스너 초기화
	private void eventInit() {
		//뒤로가기버튼
		panel.getBackBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getCardLayout().show(mainFrame.getContentPane(), "mainNavigatorPanel");
			}
		});

		//시작버튼
		panel.getStartBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getCardLayout().show(mainFrame.getContentPane(), "gamePanel");
			}
		});
	}
}
