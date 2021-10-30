package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainFrame;
import view.NationData_SlidePanel;

public class ShowNationDataController {

	private NationData_SlidePanel panel;

	public ShowNationDataController(MainFrame mainFrame) {
		panel = mainFrame.getShowNationDataPanel();
		eventInit();
	}

	private void eventInit() {
		panel.getBackBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
			}
		});
	}

}
