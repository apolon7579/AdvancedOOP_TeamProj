package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.HistogramPanel;
import view.MainFrame;

//HistogramPanel의 컨트롤러
public class HistogramPanelController {
	
	private MainFrame mainFrame;
	private HistogramPanel histogramPanel;

	//초기화
	public HistogramPanelController(MainFrame mainFrame){
		this.mainFrame = mainFrame;
		this.histogramPanel = mainFrame.getHistogramPanel();
		eventInit();
	}

	//버튼 액션 리스너 초기화
	private void eventInit() {
		histogramPanel.getBackBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getCardLayout().show(mainFrame.getContentPane(), "nationDataPanel");
			}
			
		});
	}
}
