package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dto.NationDto;
import entity.City;
import entity.Climate;
import entity.Language;
import entity.Media;
import entity.Nation;
import entity.Race;
import entity.Religion;
import service.CityService;
import service.CityServiceImpl;
import service.ClimateService;
import service.ClimateServiceImpl;
import service.LanguageService;
import service.LanguageServiceImpl;
import service.MediaService;
import service.MediaServiceImpl;
import service.NationService;
import service.NationServiceImpl;
import service.RaceService;
import service.RaceServiceImpl;
import service.ReligionService;
import service.ReligionServiceImpl;
import view.MainFrame;
import view.NationRegisterPanel;

public class NationRegisterPanelController {

	private MainFrame mainFrame;
	private NationRegisterPanel nationRegisterPanel;
	private NationService nationService;
	private CityService cityService;
	private ClimateService climateService;
	private LanguageService languageService;
	private MediaService mediaService;
	private RaceService raceService;
	private ReligionService religionService;
	
	public NationRegisterPanelController(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.nationRegisterPanel = mainFrame.getNationRegisterPanel();
		
		this.nationService = new NationServiceImpl();
		this.cityService = new CityServiceImpl();
		this.climateService = new ClimateServiceImpl();
		this.languageService = new LanguageServiceImpl();
		this.mediaService = new MediaServiceImpl();
		this.raceService = new RaceServiceImpl();
		this.religionService = new ReligionServiceImpl();
		eventInit();
	}
	
	private void eventInit() {
		
		//뒤로가기 버튼
		nationRegisterPanel.getGoBackBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getCardLayout().show(mainFrame.getContentPane(), "mainNavigatorPanel");
			}
			
		});
		
		//나라 등록 이벤트 처리
		nationRegisterPanel.getNationRegisterBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nationRegisterPanel.getNationName().getText();
				String nationCode = nationRegisterPanel.getNationCode().getText();
				String capital = nationRegisterPanel.getCapital().getText();
				String location = nationRegisterPanel.getNationLocation().getText();
				String area = nationRegisterPanel.getArea().getText();
				String areaSource = nationRegisterPanel.getAreaSource().getText();
				String areaDesc = nationRegisterPanel.getAreaDescription().getText();
				String baseYear = nationRegisterPanel.getBaseYear().getText();
				
				Nation nation = new Nation(0, name, nationCode, capital, location, Double.valueOf(area), areaSource, areaDesc, Integer.valueOf(baseYear));
				nationService.registerNation(nation);
				JOptionPane.showMessageDialog(null, "나라 등록이 완료되었습니다.");
			}
			
		});
		
		//나라 조회 버튼
		nationRegisterPanel.getNationRetrieveBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nationRegisterPanel.getNameRetrieve().getText();
				NationDto nation = nationService.retrieveNationByName(name);
				nationRegisterPanel.getNameData().setText(name);
			}
			
		});
		
		//도시 등록 버튼
		nationRegisterPanel.getCityRegisterBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nationRegisterPanel.getNameData().getText();
				NationDto nation = nationService.retrieveNationByName(name);
				String cityName = nationRegisterPanel.getCityName().getText();
				City city = new City(0, nation.getId(), cityName);
				cityService.registerCity(city);
				JOptionPane.showMessageDialog(null, "도시 등록이 완료되었습니다");
			}
		});
		
		//기후 등록 버튼
		nationRegisterPanel.getClimateRegisterBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nationRegisterPanel.getNameData().getText();
				NationDto nation = nationService.retrieveNationByName(name);
				String climateName = nationRegisterPanel.getClimateName().getText();
				Climate climate = new Climate(0, nation.getId(), climateName);
				climateService.registerClimate(climate);
				JOptionPane.showMessageDialog(null, "기후 등록이 완료되었습니다");
			}
		});
		
		//언어 등록 버튼
		nationRegisterPanel.getLanguageRegisterBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nationRegisterPanel.getNameData().getText();
				NationDto nation = nationService.retrieveNationByName(name);
				String languageName = nationRegisterPanel.getLanguage().getText();
				Language language = new Language(0, nation.getId(), languageName);
				languageService.registerLanguage(language);
				JOptionPane.showMessageDialog(null, "언어 등록이 완료되었습니다");
			}
		});
		
		//언론사 등록 버튼
		nationRegisterPanel.getMediaRegisterBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nationRegisterPanel.getNameData().getText();
				NationDto nation = nationService.retrieveNationByName(name);
				String mediaName = nationRegisterPanel.getMedia().getText();
				Media media = new Media(0, nation.getId(), mediaName);
				mediaService.registerMedia(media);
				JOptionPane.showMessageDialog(null, "언론 등록이 완료되었습니다");
			}
		});
		
		//민족 등록 버튼
		nationRegisterPanel.getRaceRegisterBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nationRegisterPanel.getNameData().getText();
				NationDto nation = nationService.retrieveNationByName(name);
				String raceName = nationRegisterPanel.getRace().getText();
				Double percent = Double.valueOf(nationRegisterPanel.getRacePercent().getText());
				Race race = new Race(0, nation.getId(), raceName, percent);
				raceService.registerRace(race);
				JOptionPane.showMessageDialog(null, "민족 등록이 완료되었습니다");
			}
		});
		
		//종교 등록 버튼
		nationRegisterPanel.getReligionRegsterBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nationRegisterPanel.getNameData().getText();
				NationDto nation = nationService.retrieveNationByName(name);
				String religionName = nationRegisterPanel.getReligion().getText();
				Double percent = Double.valueOf(nationRegisterPanel.getReligionPercent().getText());
				Religion reilgion = new Religion(0, nation.getId(), religionName, percent);
				religionService.registerReligion(reilgion);
				JOptionPane.showMessageDialog(null, "종교 등록이 완료되었습니다");
			}
		});
	}
}
