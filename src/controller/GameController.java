package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import entity.NationForGame;
import service.NationService;
import service.NationServiceImpl;
import service.UpDownGame;
import view.GamePanel;
import view.GameRulePanel;
import view.MainFrame;

public class GameController {
	private GamePanel panel;
	private MainFrame mainFrame;

	private NationService nationService = new NationServiceImpl();
	private List<NationForGame> nationForGameList;
	private int index = 0;
	private int score = 0;
	NationForGame left;
	NationForGame right;

	public GameController(MainFrame mainFrame) {
		panel = mainFrame.getGamePannel();
		this.mainFrame = mainFrame;
		gameInit();
		eventInit();
	}

	public void gameInit() {
		nationForGameList = nationService.retrieveAllNationForGame();
		Collections.shuffle(nationForGameList);
		index = 0;
		score = 0;
		this.left = nationForGameList.get(index);
		right = nationForGameList.get(index + 1);

		panel.setResultPanelFalse();
		panel.setUp(score, left.getArea(), left.getName(), right.getName());
	}

	public boolean getFlag() {
		// 왼쪽이 오른쪽보다 크면 false반환
		// 오른쪽이 왼쪽보다 크면 true반환
		return (left.getArea() <= right.getArea());
	}

	public boolean isFinish() {
		// 끝까지 도달
		return (index == nationForGameList.size() - 1);
	}

	public void next() {
		left = nationForGameList.get(++index);
		right = nationForGameList.get(index + 1);
		score++;
	}

	private void eventInit() {
		panel.getBigBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isFinish())
					System.out.println("finish 결과창");
				// 오른쪽이 더 크다고 생각
				if (getFlag()) {
					next();
					panel.setUp(score, left.getArea(), left.getName(), right.getName());
				} else
					panel.setResultPanelTrue(score);
			}
		});
		panel.getSmallBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isFinish())
					System.out.println("finish 결과창");
				// 왼쪽이 더 크다고 생각
				if (!getFlag()) {
					next();
					panel.setUp(score, left.getArea(), left.getName(), right.getName());
				} else
					panel.setResultPanelTrue(score);
			}
		});

		panel.getGoToMainBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gameInit();
				mainFrame.getCardLayout().show(mainFrame.getContentPane(), "mainNavigatorPanel");
			}
		});
		panel.getRePlayButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gameInit();
			}
		});
		panel.getBackBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gameInit();
				mainFrame.getCardLayout().show(mainFrame.getContentPane(), "gameRulePanel");
			}
		});
	}

}
