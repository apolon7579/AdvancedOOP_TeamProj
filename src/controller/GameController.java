package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import entity.NationForGame;
import service.NationService;
import service.NationServiceImpl;
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

		panel.setUp(0, left.getArea(), left.getName(), right.getName());
	}

	private void eventInit() {
		panel.getBigBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("BIG??");
			}
		});
		panel.getSmallBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("SMALL??");
			}
		});
	}

}
