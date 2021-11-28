package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import entity.User;

//게임 패널
public class GamePanel extends JPanel {

	private JFrame frame;

	JLabel peopleNum;
	JLabel scoreNum;
	JLabel picLabel;
	JLabel picLabel2;
	JLabel name1;
	JLabel name2;
	JButton bigBtn;
	JButton smallBtn;
	private JButton goToMainBtn;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JButton rePlayBtn;
	private JLabel lblResult;
	private JButton btnNewButton;
	private JPanel resultPanel;
	private static User loginedUser;

	//현재 로그인 유저 반환
	public static User getLoginedUser() {
		return loginedUser;
	}

	//현제 로그인 유저 세팅
	public static void setLoginedUser(User loginedUser) {
		GamePanel.loginedUser = loginedUser;
	}
	
	//초기화
	public GamePanel() {
		setBackground(Color.DARK_GRAY);
		setLayout(null);

		resultPanel = new JPanel();
		resultPanel.setBounds(148, 100, 701, 308);
		add(resultPanel);
		resultPanel.setLayout(null);
		resultPanel.setVisible(false);

		goToMainBtn = new JButton("메인으로");
		goToMainBtn.setFont(new Font("굴림", Font.BOLD, 17));
		goToMainBtn.setBounds(154, 210, 136, 43);
		resultPanel.add(goToMainBtn);

		lblNewLabel = new JLabel("점수: 0");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel.setBounds(265, 82, 180, 37);
		resultPanel.add(lblNewLabel);

		lblNewLabel_2 = new JLabel("최고 점수: 0");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_2.setBounds(220, 150, 255, 37);
		resultPanel.add(lblNewLabel_2);

		rePlayBtn = new JButton("다시하기");
		rePlayBtn.setFont(new Font("굴림", Font.BOLD, 17));
		rePlayBtn.setBounds(362, 210, 136, 43);
		resultPanel.add(rePlayBtn);

		lblResult = new JLabel("Result");
		lblResult.setFont(new Font("굴림", Font.BOLD, 37));
		lblResult.setBounds(283, 10, 188, 43);
		resultPanel.add(lblResult);

		JLabel lblNewLabel2 = new JLabel("국가별 면적");
		lblNewLabel2.setForeground(Color.WHITE);
		lblNewLabel2.setFont(new Font("굴림", Font.BOLD, 50));
		lblNewLabel2.setBounds(357, 10, 340, 58);
		this.add(lblNewLabel2);

		picLabel = new JLabel(new ImageIcon(getClass().getResource("/가나.png")));
		picLabel.setBounds(104, 136, 311, 236);
		add(picLabel);
		
		picLabel2 = new JLabel(new ImageIcon(getClass().getResource("/네팔.png")));
		picLabel2.setBounds(607, 136, 311, 236);
		add(picLabel2);

		JLabel lblNewLabel_1 = new JLabel("VS");
		lblNewLabel_1.setForeground(Color.PINK);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 36));
		lblNewLabel_1.setBounds(482, 195, 150, 109);
		add(lblNewLabel_1);

		peopleNum = new JLabel("면적: ");
		peopleNum.setForeground(Color.WHITE);
		peopleNum.setFont(new Font("굴림", Font.PLAIN, 24));
		peopleNum.setBounds(163, 420, 369, 37);
		add(peopleNum);

		bigBtn = new JButton("크다");
		bigBtn.setBounds(660, 430, 97, 23);
		add(bigBtn);

		smallBtn = new JButton("작다");
		smallBtn.setBounds(769, 430, 97, 23);
		add(smallBtn);

		scoreNum = new JLabel("0점");
		scoreNum.setForeground(Color.WHITE);
		scoreNum.setFont(new Font("굴림", Font.PLAIN, 24));
		scoreNum.setBounds(814, 10, 181, 37);
		add(scoreNum);

		name1 = new JLabel("나라이름");
		name1.setHorizontalAlignment(SwingConstants.CENTER);
		name1.setForeground(Color.WHITE);
		name1.setFont(new Font("굴림", Font.PLAIN, 24));
		name1.setBounds(114, 383, 288, 37);
		add(name1);

		name2 = new JLabel("나라이름");
		name2.setHorizontalAlignment(SwingConstants.CENTER);
		name2.setForeground(Color.WHITE);
		name2.setFont(new Font("굴림", Font.PLAIN, 24));
		name2.setBounds(576, 383, 369, 37);
		add(name2);

		btnNewButton = new JButton("돌아가기");
		btnNewButton.setBounds(873, 10, 97, 23);
		add(btnNewButton);
	}

	//맞힌 경우 보이는 화면
	public void setResultPanelTrue(String desc1, String desc2) {
		resultPanel.setVisible(true);
		lblNewLabel.setText(desc1);
		lblNewLabel_2.setText(desc2);
		bigBtn.setEnabled(false);
		smallBtn.setEnabled(false);
	}

	//틀린 경우 보이는 화면
	public void setResultPanelFalse() {
		resultPanel.setVisible(false);
		bigBtn.setEnabled(true);
		smallBtn.setEnabled(true);
	}

	public JButton getBackBtn() {
		return btnNewButton;
	}

	public JButton getBigBtn() {
		return bigBtn;
	}

	public JButton getSmallBtn() {
		return smallBtn;
	}

	public JButton getGoToMainBtn() {
		return goToMainBtn;
	}

	public JButton getRePlayButton() {
		return rePlayBtn;
	}

	//게임 진행화면 세팅
	public void setUp(int score, double peopleNum, String info1, String info2) {
		scoreNum.setText(score + "점");
		this.peopleNum.setText("면적: " + peopleNum + "km²");
		
		picLabel.setIcon(new ImageIcon(getClass().getResource("/" + info1 + ".png")));

		picLabel2.setIcon(new ImageIcon(getClass().getResource("/" + info2 + ".png")));

		name1.setText(info1);
		name2.setText(info2);
	}

	
}