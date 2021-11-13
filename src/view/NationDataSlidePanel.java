package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

//이름 변경 해도 OK

public class NationDataSlidePanel extends JPanel {

	private JButton btnNewButton;

	public NationDataSlidePanel() {
		setLayout(null);
		setBounds(0, 0, 1030, 660);
		setBackground(Color.PINK);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(15, 52, 980, 660);
		this.add(scrollPane);

		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setVgap(40);
		panel_1.setBackground(Color.MAGENTA);
		panel_1.setPreferredSize(new Dimension(100, 0));
		panel.add(panel_1, BorderLayout.WEST);

		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setVgap(40);
		panel_2.setBackground(Color.ORANGE);
		panel_2.setPreferredSize(new Dimension(800, 1000));
		panel.add(panel_2, BorderLayout.CENTER);

		JLabel lblNewLabel_2_1 = new JLabel("\tGH");
		lblNewLabel_2_1.setPreferredSize(new Dimension(800, 35));
		lblNewLabel_2_1.setOpaque(true);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel_2_1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		lblNewLabel_2_1.setBackground(Color.GREEN);
		panel_2.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("아크라(Accra, 234만명)(＇19, EIU)");
		lblNewLabel_2_1_1_1.setPreferredSize(new Dimension(800, 35));
		lblNewLabel_2_1_1_1.setOpaque(true);
		lblNewLabel_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel_2_1_1_1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		lblNewLabel_2_1_1_1.setBackground(Color.GREEN);
		panel_2.add(lblNewLabel_2_1_1_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("열대성, 남부고온다습, 북부고온건조, 연평균 27℃");
		lblNewLabel_2_1_1.setPreferredSize(new Dimension(800, 35));
		lblNewLabel_2_1_1.setOpaque(true);
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel_2_1_1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		lblNewLabel_2_1_1.setBackground(Color.GREEN);
		panel_2.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_1_1_2 = new JLabel("서부 아프리카 대서양의 기니만 연안");
		lblNewLabel_2_1_1_2.setPreferredSize(new Dimension(800, 35));
		lblNewLabel_2_1_1_2.setOpaque(true);
		lblNewLabel_2_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_2.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel_2_1_1_2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		lblNewLabel_2_1_1_2.setBackground(Color.GREEN);
		panel_2.add(lblNewLabel_2_1_1_2);

		JLabel lblNewLabel_2_1_1_2_1 = new JLabel(
				"쿠마시(Kumasi, 206만명), 타말레(Tamale, 56만명) 타코라디(Takoradi, 26만명)(＇19, EIU)");
		lblNewLabel_2_1_1_2_1.setPreferredSize(new Dimension(800, 35));
		lblNewLabel_2_1_1_2_1.setOpaque(true);
		lblNewLabel_2_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_2_1.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel_2_1_1_2_1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		lblNewLabel_2_1_1_2_1.setBackground(Color.GREEN);
		panel_2.add(lblNewLabel_2_1_1_2_1);

		JLabel lblNewLabel_2_1_1_2_1_1 = new JLabel("기독교(71%), 이슬람교(17.6%)");
		lblNewLabel_2_1_1_2_1_1.setPreferredSize(new Dimension(800, 35));
		lblNewLabel_2_1_1_2_1_1.setOpaque(true);
		lblNewLabel_2_1_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_2_1_1.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel_2_1_1_2_1_1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		lblNewLabel_2_1_1_2_1_1.setBackground(Color.GREEN);
		panel_2.add(lblNewLabel_2_1_1_2_1_1);

		JLabel lblNewLabel_2_1_1_2_1_1_1 = new JLabel("Akan, Ewe족 등");
		lblNewLabel_2_1_1_2_1_1_1.setPreferredSize(new Dimension(800, 35));
		lblNewLabel_2_1_1_2_1_1_1.setOpaque(true);
		lblNewLabel_2_1_1_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_2_1_1_1.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel_2_1_1_2_1_1_1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		lblNewLabel_2_1_1_2_1_1_1.setBackground(Color.GREEN);
		panel_2.add(lblNewLabel_2_1_1_2_1_1_1);

		JLabel lblNewLabel_2_1_1_2_1_1_1_1 = new JLabel(
				"신 문 Daily Graphic(일간지), Ghanaian Times(일간지), Ghanaian Voice(주간지) TV·라디오 Ghana Broadcasting Corporation(GBC)");
		lblNewLabel_2_1_1_2_1_1_1_1.setPreferredSize(new Dimension(800, 35));
		lblNewLabel_2_1_1_2_1_1_1_1.setOpaque(true);
		lblNewLabel_2_1_1_2_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_2_1_1_1_1.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel_2_1_1_2_1_1_1_1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		lblNewLabel_2_1_1_2_1_1_1_1.setBackground(Color.GREEN);
		panel_2.add(lblNewLabel_2_1_1_2_1_1_1_1);

		JLabel lblNewLabel_2_1_1_2_1_1_1_2 = new JLabel("227540");
		lblNewLabel_2_1_1_2_1_1_1_2.setPreferredSize(new Dimension(800, 35));
		lblNewLabel_2_1_1_2_1_1_1_2.setOpaque(true);
		lblNewLabel_2_1_1_2_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_2_1_1_1_2.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel_2_1_1_2_1_1_1_2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		lblNewLabel_2_1_1_2_1_1_1_2.setBackground(Color.GREEN);
		panel_2.add(lblNewLabel_2_1_1_2_1_1_1_2);

		JLabel lblNewLabel_2_1_1_2_1_1_1_3 = new JLabel("('19) World Bank (최근 수정일 : 2020.12.16.)");
		lblNewLabel_2_1_1_2_1_1_1_3.setPreferredSize(new Dimension(800, 35));
		lblNewLabel_2_1_1_2_1_1_1_3.setOpaque(true);
		lblNewLabel_2_1_1_2_1_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_2_1_1_1_3.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel_2_1_1_2_1_1_1_3.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		lblNewLabel_2_1_1_2_1_1_1_3.setBackground(Color.GREEN);
		panel_2.add(lblNewLabel_2_1_1_2_1_1_1_3);

		JLabel lblNewLabel_2_1_1_2_1_1_1_4 = new JLabel("영어 공용어, 70%, Twi어 , Ewe어");
		lblNewLabel_2_1_1_2_1_1_1_4.setPreferredSize(new Dimension(800, 35));
		lblNewLabel_2_1_1_2_1_1_1_4.setOpaque(true);
		lblNewLabel_2_1_1_2_1_1_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_2_1_1_1_4.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel_2_1_1_2_1_1_1_4.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		lblNewLabel_2_1_1_2_1_1_1_4.setBackground(Color.GREEN);
		panel_2.add(lblNewLabel_2_1_1_2_1_1_1_4);

		JLabel lblNewLabel_2 = new JLabel("국가코드");
		lblNewLabel_2.setPreferredSize(new Dimension(90, 35));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		lblNewLabel_2.setBackground(Color.GREEN);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_1_1 = new JLabel("수도");
		lblNewLabel_1_1.setPreferredSize(new Dimension(90, 35));
		lblNewLabel_1_1.setOpaque(true);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_1_1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		lblNewLabel_1_1.setBackground(Color.GREEN);
		panel_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("기후");
		lblNewLabel_1_2.setPreferredSize(new Dimension(90, 35));
		lblNewLabel_1_2.setOpaque(true);
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_1_2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		lblNewLabel_1_2.setBackground(Color.GREEN);
		panel_1.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("위치");
		lblNewLabel_1_3.setPreferredSize(new Dimension(90, 35));
		lblNewLabel_1_3.setOpaque(true);
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_1_3.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		lblNewLabel_1_3.setBackground(Color.GREEN);
		panel_1.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("주요도시");
		lblNewLabel_1_4.setPreferredSize(new Dimension(90, 35));
		lblNewLabel_1_4.setOpaque(true);
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_1_4.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		lblNewLabel_1_4.setBackground(Color.GREEN);
		panel_1.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_5 = new JLabel("종교");
		lblNewLabel_1_5.setPreferredSize(new Dimension(90, 35));
		lblNewLabel_1_5.setOpaque(true);
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_1_5.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		lblNewLabel_1_5.setBackground(Color.GREEN);
		panel_1.add(lblNewLabel_1_5);

		JLabel lblNewLabel_1_6 = new JLabel("주요민족");
		lblNewLabel_1_6.setPreferredSize(new Dimension(90, 35));
		lblNewLabel_1_6.setOpaque(true);
		lblNewLabel_1_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_6.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_1_6.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		lblNewLabel_1_6.setBackground(Color.GREEN);
		panel_1.add(lblNewLabel_1_6);

		JLabel lblNewLabel_1_7 = new JLabel("언론");
		lblNewLabel_1_7.setPreferredSize(new Dimension(90, 35));
		lblNewLabel_1_7.setOpaque(true);
		lblNewLabel_1_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_7.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_1_7.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		lblNewLabel_1_7.setBackground(Color.GREEN);
		panel_1.add(lblNewLabel_1_7);

		JLabel lblNewLabel_1_8_1 = new JLabel("면적");
		lblNewLabel_1_8_1.setPreferredSize(new Dimension(90, 35));
		lblNewLabel_1_8_1.setOpaque(true);
		lblNewLabel_1_8_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_8_1.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_1_8_1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		lblNewLabel_1_8_1.setBackground(Color.GREEN);
		panel_1.add(lblNewLabel_1_8_1);

		JLabel lblNewLabel_1_8 = new JLabel("면적출처");
		lblNewLabel_1_8.setPreferredSize(new Dimension(90, 35));
		lblNewLabel_1_8.setOpaque(true);
		lblNewLabel_1_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_8.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_1_8.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		lblNewLabel_1_8.setBackground(Color.GREEN);
		panel_1.add(lblNewLabel_1_8);

		JLabel lblNewLabel_1_9 = new JLabel("언어");
		lblNewLabel_1_9.setPreferredSize(new Dimension(90, 35));
		lblNewLabel_1_9.setOpaque(true);
		lblNewLabel_1_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_9.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_1_9.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		lblNewLabel_1_9.setBackground(Color.GREEN);
		panel_1.add(lblNewLabel_1_9);

		btnNewButton = new JButton("뒤로가기");
		btnNewButton.setBounds(12, 10, 100, 23);
		this.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("가나");
		lblNewLabel.setBounds(465, 10, 100, 32);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		this.add(lblNewLabel);
		
		setVisible(false);
	}

	public JButton getBackBtn() {
		return btnNewButton;
	}
}
