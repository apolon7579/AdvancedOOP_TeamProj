package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.HistogramPanel;
import view.MainFrame;

public class HistogramPanelController {
	
	private MainFrame mainFrame;
	private HistogramPanel histogramPanel;
	
	public HistogramPanelController(MainFrame mainFrame){
		this.mainFrame = mainFrame;
		this.histogramPanel = mainFrame.getHistogramPanel();
		eventInit();
	}
	
	private void eventInit() {
		histogramPanel.getBackBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getCardLayout().show(mainFrame.getContentPane(), "nationDataPanel");
			}
			
		});
	}
}
