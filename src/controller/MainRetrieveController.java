package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainFrame;
import view.MainNavigatorPanel;
import view.MainRetrievePanel;

public class MainRetrieveController {

	private MainRetrievePanel mainRetrievePanel;
	private MainNavigatorPanel mainNavigatorPanel;
	
	public MainRetrieveController(MainFrame mainFrame) {
		mainRetrievePanel = mainFrame.getMainRetrievePanel();
		mainNavigatorPanel = mainFrame.getMainNevigatorPanel();
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
	}
	
}
