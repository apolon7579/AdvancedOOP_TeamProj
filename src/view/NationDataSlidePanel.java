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
import javax.swing.ImageIcon;

//이름 변경 해도 OK

public class NationDataSlidePanel extends JPanel {

	private JButton btnNewButton;
	private JLabel pageTitle;
	private JLabel nationCode;
	private JLabel nationCodeValue;
	private JLabel capital;
	private JLabel capitalValue;
	private JLabel climate;
	private JLabel climateValue;
	private JLabel city;
	private JLabel cityValue;
	private JLabel religion;
	private JLabel religionValue;
	private JLabel race;
	private JLabel raceValue;
	private JLabel media;
	private JLabel mediaValue;
	private JLabel locationHead;
	private JLabel locationValue;
	private JLabel area;
	private JLabel areaValue;
	private JLabel areaSource;
	private JLabel areaSourceValue;
	private JLabel language;
	private JLabel languageValue;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	
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
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		flowLayout_1.setHgap(10);
		flowLayout_1.setVgap(40);
		panel_2.setBackground(Color.ORANGE);
		panel_2.setPreferredSize(new Dimension(750, 1000));
		panel.add(panel_2, BorderLayout.CENTER);

		nationCodeValue = new JLabel("\tGH");
		nationCodeValue.setPreferredSize(new Dimension(800, 35));
		nationCodeValue.setOpaque(true);
		nationCodeValue.setHorizontalAlignment(SwingConstants.CENTER);
		nationCodeValue.setFont(new Font("굴림", Font.PLAIN, 18));
		nationCodeValue.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		nationCodeValue.setBackground(Color.GREEN);
		panel_2.add(nationCodeValue);

		capitalValue = new JLabel("아크라(Accra, 234만명)(＇19, EIU)");
		capitalValue.setPreferredSize(new Dimension(800, 35));
		capitalValue.setOpaque(true);
		capitalValue.setHorizontalAlignment(SwingConstants.CENTER);
		capitalValue.setFont(new Font("굴림", Font.PLAIN, 18));
		capitalValue.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		capitalValue.setBackground(Color.GREEN);
		panel_2.add(capitalValue);

		climateValue = new JLabel("열대성, 남부고온다습, 북부고온건조, 연평균 27℃");
		climateValue.setPreferredSize(new Dimension(800, 35));
		climateValue.setOpaque(true);
		climateValue.setHorizontalAlignment(SwingConstants.CENTER);
		climateValue.setFont(new Font("굴림", Font.PLAIN, 18));
		climateValue.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		climateValue.setBackground(Color.GREEN);
		panel_2.add(climateValue);

		locationValue = new JLabel("서부 아프리카 대서양의 기니만 연안");
		locationValue.setPreferredSize(new Dimension(800, 35));
		locationValue.setOpaque(true);
		locationValue.setHorizontalAlignment(SwingConstants.CENTER);
		locationValue.setFont(new Font("굴림", Font.PLAIN, 18));
		locationValue.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		locationValue.setBackground(Color.GREEN);
		panel_2.add(locationValue);

		cityValue = new JLabel(
				"쿠마시(Kumasi, 206만명), 타말레(Tamale, 56만명) 타코라디(Takoradi, 26만명)(＇19, EIU)");
		cityValue.setPreferredSize(new Dimension(800, 35));
		cityValue.setOpaque(true);
		cityValue.setHorizontalAlignment(SwingConstants.CENTER);
		cityValue.setFont(new Font("굴림", Font.PLAIN, 18));
		cityValue.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		cityValue.setBackground(Color.GREEN);
		panel_2.add(cityValue);

		religionValue = new JLabel("기독교(71%), 이슬람교(17.6%)");
		religionValue.setPreferredSize(new Dimension(800, 35));
		religionValue.setOpaque(true);
		religionValue.setHorizontalAlignment(SwingConstants.CENTER);
		religionValue.setFont(new Font("굴림", Font.PLAIN, 18));
		religionValue.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		religionValue.setBackground(Color.GREEN);
		panel_2.add(religionValue);
		
		btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setIcon(new ImageIcon("..\\image\\graph.png"));
		btnNewButton_1.setPreferredSize(new Dimension(35,35));
		panel_2.add(btnNewButton_1);

		raceValue = new JLabel("Akan, Ewe족 등");
		raceValue.setPreferredSize(new Dimension(800, 35));
		raceValue.setOpaque(true);
		raceValue.setHorizontalAlignment(SwingConstants.CENTER);
		raceValue.setFont(new Font("굴림", Font.PLAIN, 18));
		raceValue.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		raceValue.setBackground(Color.GREEN);
		panel_2.add(raceValue);

		mediaValue = new JLabel(
				"신 문 Daily Graphic(일간지), Ghanaian Times(일간지), Ghanaian Voice(주간지) TV·라디오 Ghana Broadcasting Corporation(GBC)");
		mediaValue.setPreferredSize(new Dimension(800, 35));
		mediaValue.setOpaque(true);
		mediaValue.setHorizontalAlignment(SwingConstants.CENTER);
		mediaValue.setFont(new Font("굴림", Font.PLAIN, 18));
		mediaValue.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		mediaValue.setBackground(Color.GREEN);
		panel_2.add(mediaValue);

		areaValue = new JLabel("227540");
		areaValue.setPreferredSize(new Dimension(800, 35));
		areaValue.setOpaque(true);
		areaValue.setHorizontalAlignment(SwingConstants.CENTER);
		areaValue.setFont(new Font("굴림", Font.PLAIN, 18));
		areaValue.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		areaValue.setBackground(Color.GREEN);
		panel_2.add(areaValue);

		areaSourceValue = new JLabel("('19) World Bank (최근 수정일 : 2020.12.16.)");
		areaSourceValue.setPreferredSize(new Dimension(800, 35));
		areaSourceValue.setOpaque(true);
		areaSourceValue.setHorizontalAlignment(SwingConstants.CENTER);
		areaSourceValue.setFont(new Font("굴림", Font.PLAIN, 18));
		areaSourceValue.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		areaSourceValue.setBackground(Color.GREEN);
		panel_2.add(areaSourceValue);

		languageValue = new JLabel("영어 공용어, 70%, Twi어 , Ewe어");
		languageValue.setPreferredSize(new Dimension(800, 35));
		languageValue.setOpaque(true);
		languageValue.setHorizontalAlignment(SwingConstants.CENTER);
		languageValue.setFont(new Font("굴림", Font.PLAIN, 18));
		languageValue.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		languageValue.setBackground(Color.GREEN);
		panel_2.add(languageValue);

		btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setIcon(new ImageIcon("..\\image\\graph.png"));
		btnNewButton_2.setPreferredSize(new Dimension(35,35));
		panel_2.add(btnNewButton_2);
		
		nationCode = new JLabel("국가코드");
		nationCode.setPreferredSize(new Dimension(90, 35));
		nationCode.setOpaque(true);
		nationCode.setHorizontalAlignment(SwingConstants.CENTER);
		nationCode.setFont(new Font("굴림", Font.PLAIN, 20));
		nationCode.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		nationCode.setBackground(Color.GREEN);
		panel_1.add(nationCode);

		capital = new JLabel("수도");
		capital.setPreferredSize(new Dimension(90, 35));
		capital.setOpaque(true);
		capital.setHorizontalAlignment(SwingConstants.CENTER);
		capital.setFont(new Font("굴림", Font.PLAIN, 20));
		capital.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		capital.setBackground(Color.GREEN);
		panel_1.add(capital);

		climate = new JLabel("기후");
		climate.setPreferredSize(new Dimension(90, 35));
		climate.setOpaque(true);
		climate.setHorizontalAlignment(SwingConstants.CENTER);
		climate.setFont(new Font("굴림", Font.PLAIN, 20));
		climate.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		climate.setBackground(Color.GREEN);
		panel_1.add(climate);

		locationHead = new JLabel("위치");
		locationHead.setPreferredSize(new Dimension(90, 35));
		locationHead.setOpaque(true);
		locationHead.setHorizontalAlignment(SwingConstants.CENTER);
		locationHead.setFont(new Font("굴림", Font.PLAIN, 20));
		locationHead.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		locationHead.setBackground(Color.GREEN);
		panel_1.add(locationHead);

		city = new JLabel("주요도시");
		city.setPreferredSize(new Dimension(90, 35));
		city.setOpaque(true);
		city.setHorizontalAlignment(SwingConstants.CENTER);
		city.setFont(new Font("굴림", Font.PLAIN, 20));
		city.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		city.setBackground(Color.GREEN);
		panel_1.add(city);

		religion = new JLabel("종교");
		religion.setPreferredSize(new Dimension(90, 35));
		religion.setOpaque(true);
		religion.setHorizontalAlignment(SwingConstants.CENTER);
		religion.setFont(new Font("굴림", Font.PLAIN, 20));
		religion.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		religion.setBackground(Color.GREEN);
		panel_1.add(religion);

		race = new JLabel("주요민족");
		race.setPreferredSize(new Dimension(90, 35));
		race.setOpaque(true);
		race.setHorizontalAlignment(SwingConstants.CENTER);
		race.setFont(new Font("굴림", Font.PLAIN, 20));
		race.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		race.setBackground(Color.GREEN);
		panel_1.add(race);

		media = new JLabel("언론");
		media.setPreferredSize(new Dimension(90, 35));
		media.setOpaque(true);
		media.setHorizontalAlignment(SwingConstants.CENTER);
		media.setFont(new Font("굴림", Font.PLAIN, 20));
		media.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		media.setBackground(Color.GREEN);
		panel_1.add(media);

		area = new JLabel("면적");
		area.setPreferredSize(new Dimension(90, 35));
		area.setOpaque(true);
		area.setHorizontalAlignment(SwingConstants.CENTER);
		area.setFont(new Font("굴림", Font.PLAIN, 20));
		area.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		area.setBackground(Color.GREEN);
		panel_1.add(area);

		areaSource = new JLabel("면적출처");
		areaSource.setPreferredSize(new Dimension(90, 35));
		areaSource.setOpaque(true);
		areaSource.setHorizontalAlignment(SwingConstants.CENTER);
		areaSource.setFont(new Font("굴림", Font.PLAIN, 20));
		areaSource.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		areaSource.setBackground(Color.GREEN);
		panel_1.add(areaSource);

		language = new JLabel("언어");
		language.setPreferredSize(new Dimension(90, 35));
		language.setOpaque(true);
		language.setHorizontalAlignment(SwingConstants.CENTER);
		language.setFont(new Font("굴림", Font.PLAIN, 20));
		language.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		language.setBackground(Color.GREEN);
		panel_1.add(language);

		btnNewButton = new JButton("뒤로가기");
		btnNewButton.setBounds(12, 10, 100, 23);
		this.add(btnNewButton);

		pageTitle = new JLabel("가나");
		pageTitle.setBounds(465, 10, 100, 32);
		pageTitle.setHorizontalAlignment(SwingConstants.CENTER);
		pageTitle.setOpaque(true);
		pageTitle.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		pageTitle.setFont(new Font("굴림", Font.PLAIN, 20));
		this.add(pageTitle);
		
		setVisible(false);
	}

	public JButton getBackBtn() {
		return btnNewButton;
	}

	public JLabel getPageTitle() {
		return pageTitle;
	}

	public JLabel getNationCode() {
		return nationCode;
	}

	public JLabel getNationCodeValue() {
		return nationCodeValue;
	}

	public JLabel getCapital() {
		return capital;
	}

	public JLabel getCapitalValue() {
		return capitalValue;
	}

	public JLabel getClimate() {
		return climate;
	}

	public JLabel getClimateValue() {
		return climateValue;
	}

	public JLabel getCity() {
		return city;
	}

	public JLabel getCityValue() {
		return cityValue;
	}

	public JLabel getReligion() {
		return religion;
	}

	public JLabel getReligionValue() {
		return religionValue;
	}

	public JLabel getRace() {
		return race;
	}

	public JLabel getRaceValue() {
		return raceValue;
	}

	public JLabel getMedia() {
		return media;
	}

	public JLabel getMediaValue() {
		return mediaValue;
	}

	public JLabel getLocationHead() {
		return locationHead;
	}

	public JLabel getLocationValue() {
		return locationValue;
	}

	public JLabel getArea() {
		return area;
	}

	public JLabel getAreaValue() {
		return areaValue;
	}

	public JLabel getAreaSource() {
		return areaSource;
	}

	public JLabel getAreaSourceValue() {
		return areaSourceValue;
	}

	public JLabel getLanguage() {
		return language;
	}

	public JLabel getLanguageValue() {
		return languageValue;
	}
	
	
}
