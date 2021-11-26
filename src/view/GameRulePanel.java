package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.DropMode;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import service.UserService;
import service.UserServiceImpl;

import javax.swing.JButton;
import javax.swing.JLabel;

public class GameRulePanel extends JPanel {

	private JButton backBtn;
	private JButton btnNewButton;
	private static String loginUserName;
	UserService userService = new UserServiceImpl();
	JLabel localRecordLabel;

	public GameRulePanel() {
		setLayout(null);

		JLabel title = new JLabel("업 다운 게임");
		title.setPreferredSize(new Dimension(800, 35));
		title.setOpaque(true);
		title.setBounds(240, 31, 568, 57);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("굴림", Font.PLAIN, 18));
		title.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		title.setBackground(Color.LIGHT_GRAY);
		this.add(title);

		btnNewButton = new JButton("게임 시작");
		btnNewButton.setBounds(413, 460, 236, 65);
		add(btnNewButton);

		JLabel ruleLabel = new JLabel("업 다운 게임은 주제에 따라 두 수중 무엇이 더 클까 맞추는 게임입니다. 최고기록을 노려보세요!");
		ruleLabel.setBounds(70, 115, 907, 57);
		ruleLabel.setPreferredSize(new Dimension(800, 35));
		ruleLabel.setOpaque(true);
		ruleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ruleLabel.setFont(new Font("굴림", Font.PLAIN, 18));
		ruleLabel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		ruleLabel.setBackground(Color.LIGHT_GRAY);
		this.add(ruleLabel);

		int score = 0;
		try {
			File rd = new File("..\\score.txt");
			BufferedReader inFile = new BufferedReader(new FileReader(rd));
			score = Integer.parseInt(inFile.readLine());
			inFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("그딴 파일 없슴;;");
		} catch (IOException e) {
			e.printStackTrace();
		}
		localRecordLabel = new JLabel("개인 최고 기록 : " + score);
		localRecordLabel.setBounds(70, 194, 907, 57);
		localRecordLabel.setPreferredSize(new Dimension(800, 35));
		localRecordLabel.setOpaque(true);
		localRecordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		localRecordLabel.setFont(new Font("굴림", Font.PLAIN, 18));
		localRecordLabel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		localRecordLabel.setBackground(Color.LIGHT_GRAY);
		this.add(localRecordLabel);

		JLabel serverRecordLabel = new JLabel("서버 최고 기록 : " + userService.retrieveTopLevel());
		serverRecordLabel.setPreferredSize(new Dimension(800, 35));
		serverRecordLabel.setOpaque(true);
		serverRecordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		serverRecordLabel.setFont(new Font("굴림", Font.PLAIN, 18));
		serverRecordLabel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		serverRecordLabel.setBackground(Color.LIGHT_GRAY);
		serverRecordLabel.setBounds(70, 273, 907, 57);
		add(serverRecordLabel);

		backBtn = new JButton("돌아가기");
		backBtn.setBounds(872, 31, 97, 23);
		add(backBtn);
	}

	public static void setUserName(String userName) {
		loginUserName = userName;
	}
	
	public JButton getBackBtn() {
		return backBtn;
	}

	public JButton getStartBtn() {
		return btnNewButton;
	}

	public void setBestScore(int best_score) {
		localRecordLabel.setText("개인 최고 기록 : " + best_score);
	}
}
