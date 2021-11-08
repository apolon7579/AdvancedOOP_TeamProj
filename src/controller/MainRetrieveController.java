package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainFrame;
import view.MainNavigatorPanel;
import view.MainRetrievePanel;
import view.NationDataSlidePanel;

public class MainRetrieveController {

	private MainRetrievePanel mainRetrievePanel;
	private MainNavigatorPanel mainNavigatorPanel;
	private NationDataSlidePanel nationDataSlidePanel;
	
	public MainRetrieveController(MainFrame mainFrame) {
		mainRetrievePanel = mainFrame.getMainRetrievePanel();
		mainNavigatorPanel = mainFrame.getMainNevigatorPanel();
		nationDataSlidePanel = mainFrame.getNationDataSlidePanel();
		eventInit();
	}

	private void eventInit() {
		
		mainRetrievePanel.getGoBackBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainRetrievePanel.setVisible(false);
				mainNavigatorPanel.setVisible(true);
			}
			
		});
		
		mainRetrievePanel.getDetailBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainRetrievePanel.setVisible(false);
				nationDataSlidePanel.setVisible(true);
			}
			
		});
	}
	
}
