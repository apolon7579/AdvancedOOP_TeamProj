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

//업다운 게임의 컨트롤러
public class GameController {

	private GamePanel panel;
	private GameRulePanel rulePanel;
	private MainFrame mainFrame;

	private NationService nationService = new NationServiceImpl();
	private List<NationForGame> nationForGameList;
	private int index;
	private int score;
	NationForGame left;
	NationForGame right;
	UserService userService = new UserServiceImpl();

	//초기화
	public GameController(MainFrame mainFrame) {
		panel = mainFrame.getGamePannel();
		rulePanel = mainFrame.getGameRulePannel();
		this.mainFrame = mainFrame;
		gameInit();
		eventInit();
	}

	//게임 초기화
	public void gameInit() {
		nationForGameList = nationService.retrieveAllNationForGame();
		if(nationForGameList.size() != 0) {
			Collections.shuffle(nationForGameList);
			this.left = nationForGameList.get(index);
			right = nationForGameList.get(index + 1);
			System.out.println("ddd");
			index = 0;
			score = 0;
			panel.setResultPanelFalse();
			panel.setUp(score, left.getArea(), left.getName(), right.getName());
		}
	}

	//국가 면적 비교
	public boolean getFlag() {
		// 왼쪽이 오른쪽보다 크면 false반환
		// 오른쪽이 왼쪽보다 크면 true반환
		return (left.getArea() <= right.getArea());
	}

	//끝까지 도달한 경우
	public boolean isFinish() {
		// 끝까지 도달
		return (index == (nationForGameList.size() - 1));
	}

	//다음 문제로 이동
	public void next() {
		left = nationForGameList.get(++index);
		right = nationForGameList.get(index + 1);
		score++;
	}

	//버튼 액션리스너 초기화
	private void eventInit() {
		//크다버튼
		panel.getBigBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isFinish()) {
					end();
					panel.setResultPanelTrue("마지막!!! " + score + "점입니다.",
							"개인기록: " + userService.retrieveLevelByUserId(GamePanel.getLoginedUser().getUserId())
									+ ", 서버기록: " + userService.retrieveTopLevel());
				}
				// 오른쪽이 더 크다고 생각
				else if (getFlag()) {
					next();
					panel.setUp(score, left.getArea(), left.getName(), right.getName());
				} else {
					end();
					panel.setResultPanelTrue("이번점수: " + score,
							"개인기록: " + userService.retrieveLevelByUserId(GamePanel.getLoginedUser().getUserId())
									+ ", 서버기록: " + userService.retrieveTopLevel());
				}
			}
		});
		//작다버튼
		panel.getSmallBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isFinish()) {
					end();
					panel.setResultPanelTrue("마지막!!! " + score + "점입니다.",
							"개인기록: " + userService.retrieveLevelByUserId(GamePanel.getLoginedUser().getUserId())
									+ ", 서버기록: " + userService.retrieveTopLevel());
				}
				// 왼쪽이 더 크다고 생각
				else if (!getFlag()) {
					next();
					panel.setUp(score, left.getArea(), left.getName(), right.getName());
				} else {
					end();
					panel.setResultPanelTrue("이번점수: " + score,
							"개인기록: " + userService.retrieveLevelByUserId(GamePanel.getLoginedUser().getUserId())
									+ ", 서버기록: " + userService.retrieveTopLevel());
				}
			}
		});

		//메인으로가기버튼
		panel.getGoToMainBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gameInit();
				mainFrame.getCardLayout().show(mainFrame.getContentPane(), "mainNavigatorPanel");
			}
		});
		//다시하기버튼
		panel.getRePlayButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gameInit();
			}
		});
		//뒤로가기버튼
		panel.getBackBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gameInit();
				mainFrame.getCardLayout().show(mainFrame.getContentPane(), "gameRulePanel");
			}
		});
	}

	//게임 종료처리
	private void end() {
		userService.updateLevelByUserAndLevel(GamePanel.getLoginedUser(), score);
	}

}
