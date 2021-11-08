package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainFrame;
import view.MainRetrievePanel;
import view.NationDataSlidePanel;

public class NationDataSlideController {

	private NationDataSlidePanel panel;
	private MainRetrievePanel mainRetrievePanel;

	public NationDataSlideController(MainFrame mainFrame) {
		panel = mainFrame.getNationDataSlidePanel();
		mainRetrievePanel = mainFrame.getMainRetrievePanel();
		eventInit();
	}

	private void eventInit() {
		panel.getBackBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				mainRetrievePanel.setVisible(true);
			}
		});
	}

}
