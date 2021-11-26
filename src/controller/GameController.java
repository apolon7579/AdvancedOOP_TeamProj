package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import entity.NationForGame;
import service.NationService;
import service.NationServiceImpl;
import service.UpDownGame;
import service.UserService;
import service.UserServiceImpl;
import view.GamePanel;
import view.GameRulePanel;
import view.MainFrame;

public class GameController {
	
	private GamePanel panel;
	private GameRulePanel rulePanel;
	private MainFrame mainFrame;

	private NationService nationService = new NationServiceImpl();
	private List<NationForGame> nationForGameList;
	private int index;
	private int score;
	private int best_score;
	NationForGame left;
	NationForGame right;
	UserService userService = new UserServiceImpl();
	
	public GameController(MainFrame mainFrame) {
		panel = mainFrame.getGamePannel();
		rulePanel = mainFrame.getGameRulePannel();
		this.mainFrame = mainFrame;
		scoreInit();
		gameInit();
		eventInit();
	}
	


	public void scoreInit() {
		best_score = 0;
		try {
			File rd = new File("..\\score.txt");
			BufferedReader inFile = new BufferedReader(new FileReader(rd));
			best_score = Integer.parseInt(inFile.readLine());
			inFile.close();
		} catch (FileNotFoundException e) {
			try {
				System.out.println("score.txt파일이 없어 새로 만들고 0으로 했슴다");
				FileWriter fw = new FileWriter("..\\score.txt");
				fw.write("0");
				fw.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int setScore() {
		if (best_score < score) {
			best_score = score;
			FileWriter fw;
			try {
				fw = new FileWriter("..\\score.txt");
				fw.write(Integer.toString(best_score));
				fw.close();
				
				rulePanel.setBestScore(best_score);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return best_score;
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
		return (index == 227 - 1);
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
					panel.setResultPanelTrue(setScore());
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
					panel.setResultPanelTrue(setScore());
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
