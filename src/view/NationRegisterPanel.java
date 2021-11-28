package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

//국가 등록 화면
public class NationRegisterPanel extends JPanel {
	private JTextField nationName;
	private JTextField nationCode;
	private JTextField capital;
	private JTextField nationLocation;
	private JTextField area;
	private JTextField areaSource;
	private JTextField areaDescription;
	private JTextField baseYear;
	private JTextField nameRetrieve;
	private JTextField nameData;
	private JTextField cityName;
	private JTextField climateName;
	private JTextField language;
	private JTextField media;
	private JTextField race;
	private JTextField racePercent;
	private JTextField religion;
	private JTextField religionPercent;
	private JButton nationRegisterBtn;
	private JButton nationRetrieveBtn;
	private JButton cityRegisterBtn;
	private JButton climateRegisterBtn;
	private JButton languageRegisterBtn;
	private JButton mediaRegisterBtn;
	private JButton raceRegisterBtn;
	private JButton religionRegsterBtn;
	private JButton goBackBtn;

	/**
	 * Create the panel.
	 */
	//초기화
	public NationRegisterPanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("나라등록");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 19));
		lblNewLabel.setBounds(443, 33, 186, 37);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("이름");
		lblNewLabel_1.setBounds(105, 141, 57, 15);
		add(lblNewLabel_1);
		
		nationName = new JTextField();
		nationName.setBounds(184, 138, 116, 21);
		add(nationName);
		nationName.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("국가코드");
		lblNewLabel_1_1.setBounds(105, 180, 57, 15);
		add(lblNewLabel_1_1);
		
		nationCode = new JTextField();
		nationCode.setColumns(10);
		nationCode.setBounds(184, 177, 116, 21);
		add(nationCode);
		
		JLabel lblNewLabel_1_2 = new JLabel("수도");
		lblNewLabel_1_2.setBounds(105, 229, 57, 15);
		add(lblNewLabel_1_2);
		
		capital = new JTextField();
		capital.setColumns(10);
		capital.setBounds(184, 226, 116, 21);
		add(capital);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("위치");
		lblNewLabel_1_1_1.setBounds(105, 268, 57, 15);
		add(lblNewLabel_1_1_1);
		
		nationLocation = new JTextField();
		nationLocation.setColumns(10);
		nationLocation.setBounds(184, 265, 116, 21);
		add(nationLocation);
		
		JLabel lblNewLabel_1_3 = new JLabel("면적");
		lblNewLabel_1_3.setBounds(105, 315, 57, 15);
		add(lblNewLabel_1_3);
		
		area = new JTextField();
		area.setColumns(10);
		area.setBounds(184, 312, 116, 21);
		add(area);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("면적 출처");
		lblNewLabel_1_1_2.setBounds(105, 354, 57, 15);
		add(lblNewLabel_1_1_2);
		
		areaSource = new JTextField();
		areaSource.setColumns(10);
		areaSource.setBounds(184, 351, 116, 21);
		add(areaSource);
		
		JLabel lblNewLabel_1_4 = new JLabel("면적설명");
		lblNewLabel_1_4.setBounds(105, 401, 57, 15);
		add(lblNewLabel_1_4);
		
		areaDescription = new JTextField();
		areaDescription.setColumns(10);
		areaDescription.setBounds(184, 398, 116, 21);
		add(areaDescription);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("기준년도");
		lblNewLabel_1_1_3.setBounds(105, 440, 57, 15);
		add(lblNewLabel_1_1_3);
		
		baseYear = new JTextField();
		baseYear.setColumns(10);
		baseYear.setBounds(184, 437, 116, 21);
		add(baseYear);
		
		nationRegisterBtn = new JButton("등록");
		nationRegisterBtn.setBounds(168, 501, 97, 23);
		add(nationRegisterBtn);
		
		JLabel lblNewLabel_1_5 = new JLabel("이름");
		lblNewLabel_1_5.setBounds(374, 138, 57, 15);
		add(lblNewLabel_1_5);
		
		nameRetrieve = new JTextField();
		nameRetrieve.setColumns(10);
		nameRetrieve.setBounds(453, 135, 116, 21);
		add(nameRetrieve);
		
		nationRetrieveBtn = new JButton("조회");
		nationRetrieveBtn.setBounds(597, 134, 97, 23);
		add(nationRetrieveBtn);
		
		nameData = new JTextField();
		nameData.setEnabled(false);
		nameData.setBounds(453, 180, 241, 21);
		add(nameData);
		nameData.setColumns(10);
		
		JLabel lblNewLabel_1_6 = new JLabel("도시명");
		lblNewLabel_1_6.setBounds(374, 232, 57, 15);
		add(lblNewLabel_1_6);
		
		cityName = new JTextField();
		cityName.setColumns(10);
		cityName.setBounds(453, 229, 116, 21);
		add(cityName);
		
		cityRegisterBtn = new JButton("등록");
		cityRegisterBtn.setBounds(597, 228, 97, 23);
		add(cityRegisterBtn);
		
		JLabel lblNewLabel_1_6_1 = new JLabel("기후");
		lblNewLabel_1_6_1.setBounds(374, 272, 57, 15);
		add(lblNewLabel_1_6_1);
		
		climateName = new JTextField();
		climateName.setColumns(10);
		climateName.setBounds(453, 269, 116, 21);
		add(climateName);
		
		climateRegisterBtn = new JButton("등록");
		climateRegisterBtn.setBounds(597, 268, 97, 23);
		add(climateRegisterBtn);
		
		JLabel lblNewLabel_1_6_2 = new JLabel("언어");
		lblNewLabel_1_6_2.setBounds(374, 319, 57, 15);
		add(lblNewLabel_1_6_2);
		
		language = new JTextField();
		language.setColumns(10);
		language.setBounds(453, 316, 116, 21);
		add(language);
		
		languageRegisterBtn = new JButton("등록");
		languageRegisterBtn.setBounds(597, 315, 97, 23);
		add(languageRegisterBtn);
		
		JLabel lblNewLabel_1_6_3 = new JLabel("언론사");
		lblNewLabel_1_6_3.setBounds(374, 358, 57, 15);
		add(lblNewLabel_1_6_3);
		
		media = new JTextField();
		media.setColumns(10);
		media.setBounds(453, 355, 116, 21);
		add(media);
		
		mediaRegisterBtn = new JButton("등록");
		mediaRegisterBtn.setBounds(597, 354, 97, 23);
		add(mediaRegisterBtn);
		
		JLabel lblNewLabel_1_6_3_1 = new JLabel("민족");
		lblNewLabel_1_6_3_1.setBounds(374, 400, 57, 15);
		add(lblNewLabel_1_6_3_1);
		
		race = new JTextField();
		race.setColumns(10);
		race.setBounds(453, 397, 116, 21);
		add(race);
		
		raceRegisterBtn = new JButton("등록");
		raceRegisterBtn.setBounds(812, 397, 97, 23);
		add(raceRegisterBtn);
		
		JLabel lblNewLabel_1_6_3_1_1 = new JLabel("퍼센티지");
		lblNewLabel_1_6_3_1_1.setBounds(597, 401, 57, 15);
		add(lblNewLabel_1_6_3_1_1);
		
		racePercent = new JTextField();
		racePercent.setColumns(10);
		racePercent.setBounds(665, 398, 116, 21);
		add(racePercent);
		
		JLabel lblNewLabel_1_6_3_1_2 = new JLabel("종교");
		lblNewLabel_1_6_3_1_2.setBounds(374, 443, 57, 15);
		add(lblNewLabel_1_6_3_1_2);
		
		religion = new JTextField();
		religion.setColumns(10);
		religion.setBounds(453, 440, 116, 21);
		add(religion);
		
		religionRegsterBtn = new JButton("등록");
		religionRegsterBtn.setBounds(812, 440, 97, 23);
		add(religionRegsterBtn);
		
		JLabel lblNewLabel_1_6_3_1_1_1 = new JLabel("퍼센티지");
		lblNewLabel_1_6_3_1_1_1.setBounds(597, 444, 57, 15);
		add(lblNewLabel_1_6_3_1_1_1);
		
		religionPercent = new JTextField();
		religionPercent.setColumns(10);
		religionPercent.setBounds(665, 441, 116, 21);
		add(religionPercent);
		
		goBackBtn = new JButton("뒤로가기");
		goBackBtn.setBounds(812, 563, 97, 23);
		add(goBackBtn);

	}

	public JTextField getNationName() {
		return nationName;
	}

	public JTextField getNationCode() {
		return nationCode;
	}

	public JTextField getCapital() {
		return capital;
	}

	public JTextField getNationLocation() {
		return nationLocation;
	}

	public JTextField getArea() {
		return area;
	}

	public JTextField getAreaSource() {
		return areaSource;
	}

	public JTextField getAreaDescription() {
		return areaDescription;
	}

	public JTextField getBaseYear() {
		return baseYear;
	}

	public JTextField getNameRetrieve() {
		return nameRetrieve;
	}

	public JTextField getNameData() {
		return nameData;
	}

	public JTextField getCityName() {
		return cityName;
	}

	public JTextField getClimateName() {
		return climateName;
	}

	public JTextField getLanguage() {
		return language;
	}

	public JTextField getMedia() {
		return media;
	}

	public JTextField getRace() {
		return race;
	}

	public JTextField getRacePercent() {
		return racePercent;
	}

	public JTextField getReligion() {
		return religion;
	}

	public JTextField getReligionPercent() {
		return religionPercent;
	}

	public JButton getNationRegisterBtn() {
		return nationRegisterBtn;
	}

	public JButton getNationRetrieveBtn() {
		return nationRetrieveBtn;
	}

	public JButton getCityRegisterBtn() {
		return cityRegisterBtn;
	}

	public JButton getClimateRegisterBtn() {
		return climateRegisterBtn;
	}

	public JButton getLanguageRegisterBtn() {
		return languageRegisterBtn;
	}

	public JButton getMediaRegisterBtn() {
		return mediaRegisterBtn;
	}

	public JButton getRaceRegisterBtn() {
		return raceRegisterBtn;
	}

	public JButton getReligionRegsterBtn() {
		return religionRegsterBtn;
	}

	public JButton getGoBackBtn() {
		return goBackBtn;
	}

}
