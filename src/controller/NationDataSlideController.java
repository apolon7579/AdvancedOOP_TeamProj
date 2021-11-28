package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import dto.NationDto;
import entity.Race;
import entity.Religion;
import service.NationService;
import service.NationServiceImpl;
import view.HistogramPanel;
import view.MainFrame;
import view.MainRetrievePanel;
import view.NationDataSlidePanel;

//국가조회버튼
public class NationDataSlideController {

	private MainFrame mainFrame;
	private NationDataSlidePanel panel;
	private MainRetrievePanel mainRetrievePanel;
	private HistogramPanel histogramPanel;
	
	private NationService nationService;

	//초기화
	public NationDataSlideController(MainFrame mainFrame) {
		
		this.mainFrame = mainFrame;
		this.panel = mainFrame.getNationDataSlidePanel();
		this.mainRetrievePanel = mainFrame.getMainRetrievePanel();
		histogramPanel = mainFrame.getHistogramPanel();
		nationService = new NationServiceImpl();
		
		eventInit();
	}

	//버튼 액션 리스너 초기화
	private void eventInit() {
		//뒤로가기 버튼
		panel.getBackBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getCardLayout().show(mainFrame.getContentPane(), "mainRetrievePanel");
			}
		});

		// 종교 그래프조회 버튼
		panel.getreligionGraphBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String nationName = panel.getPageTitle().getText();
				NationDto nation = nationService.retrieveNationByName(nationName);
				List<Religion> religionList = nation.getReligionList();
				
				histogramPanel.getBarList().clear();
				
				if(religionList != null) {
					for(int i =0; i < religionList.size(); i++) {
						String raceName = religionList.get(i).getName();
						int percentage = (int) Math.round(religionList.get(i).getPercentage());
						if(percentage == 0) {
							JOptionPane.showMessageDialog(null, "종교 퍼센티지 정보가 없습니다.");
							return;
						}
						histogramPanel.addHistogramColumn(raceName, percentage,Color.YELLOW);
					}
					histogramPanel.layoutHistogram();
					mainFrame.getCardLayout().show(mainFrame.getContentPane(), "histogramPanel");
				}else {
					JOptionPane.showMessageDialog(null, "종교 퍼센티지 정보가 없습니다.");
				}
			}
		});

		// 민족 그래프 조회 버튼
		panel.getLanguageGraphBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nationName = panel.getPageTitle().getText();
				NationDto nation = nationService.retrieveNationByName(nationName);
				List<Race> raceList = nation.getRaceList();
				
				histogramPanel.getBarList().clear();
				
				if(raceList != null) {
					for(int i =0; i < raceList.size(); i++) {
						String raceName = raceList.get(i).getName();
						int percentage = (int) Math.round(raceList.get(i).getPercentage());
						if(percentage == 0) {
							JOptionPane.showMessageDialog(null, "인종 퍼센티지 정보가 없습니다.");
							return;
						}
						histogramPanel.addHistogramColumn(raceName, percentage,Color.YELLOW);
					}
					histogramPanel.layoutHistogram();
					mainFrame.getCardLayout().show(mainFrame.getContentPane(), "histogramPanel");
				}else {
					JOptionPane.showMessageDialog(null, "인종 퍼센티지 정보가 없습니다.");
				}
			}
		});
	}

}
