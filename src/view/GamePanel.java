package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.Icon;

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
	// 가끔 사진이 없는 나라가 있음;;
	// 캐나다 같은건 이미지가 너무 커서 이상하게 나옴;;

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
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 28));
		lblNewLabel.setBounds(271, 82, 176, 37);
		resultPanel.add(lblNewLabel);

		lblNewLabel_2 = new JLabel("최고 점수: 0");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 28));
		lblNewLabel_2.setBounds(271, 150, 203, 37);
		resultPanel.add(lblNewLabel_2);

		rePlayBtn = new JButton("다시하기");
		rePlayBtn.setFont(new Font("굴림", Font.BOLD, 17));
		rePlayBtn.setBounds(362, 210, 136, 43);
		resultPanel.add(rePlayBtn);

		lblResult = new JLabel("Result");
		lblResult.setFont(new Font("굴림", Font.BOLD, 37));
		lblResult.setBounds(271, 10, 188, 43);
		resultPanel.add(lblResult);

		JLabel lblNewLabel2 = new JLabel("국가별 면적");
		lblNewLabel2.setForeground(Color.WHITE);
		lblNewLabel2.setFont(new Font("굴림", Font.BOLD, 50));
		lblNewLabel2.setBounds(357, 10, 340, 58);
		this.add(lblNewLabel2);

		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("..\\Image\\가나.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		picLabel = new JLabel(new ImageIcon(myPicture));
		picLabel.setBounds(104, 136, 311, 236);
		add(picLabel);

		BufferedImage myPicture2 = null;
		try {
			myPicture2 = ImageIO.read(new File("..\\Image\\네팔.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		picLabel2 = new JLabel(new ImageIcon(myPicture2));
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

	public void setResultPanelTrue(int score) {
		resultPanel.setVisible(true);
		lblNewLabel.setText("점수: " + scoreNum.getText());
		lblNewLabel_2.setText("최고 점수: " + score + "점");
		bigBtn.setEnabled(false);
		smallBtn.setEnabled(false);
	}

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

	public void setUp(int score, double peopleNum, String info1, String info2) {
		scoreNum.setText(score + "점");
		this.peopleNum.setText("면적: " + peopleNum + "km²");
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("..\\Image\\" + info1 + ".png"));
			picLabel.setIcon(new ImageIcon(myPicture));
		} catch (IOException e) {
			System.out.println("파일을 찾을수 없습니다" + info1);
			// e.printStackTrace();
		}

		try {
			myPicture = ImageIO.read(new File("..\\Image\\" + info2 + ".png"));
			picLabel2.setIcon(new ImageIcon(myPicture));
		} catch (IOException e) {
			System.out.println("파일을 찾을수 없습니다" + info2);
			// e.printStackTrace();
		}

		name1.setText(info1);
		name2.setText(info2);
	}
}