package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainFrame;
import view.MainRetrievePanel;
import view.NationDataSlidePanel;

public class NationDataSlideController {

	private NationDataSlidePanel panel;
	private MainRetrievePanel mainRetrievePanel;
	private MainFrame mainFrame;

	public NationDataSlideController(MainFrame mainFrame) {
		panel = mainFrame.getNationDataSlidePanel();
		mainRetrievePanel = mainFrame.getMainRetrievePanel();
		this.mainFrame = mainFrame;
		eventInit();
	}

	private void eventInit() {
		panel.getBackBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getCardLayout().show(mainFrame.getContentPane(), "mainRetrievePanel");
			}
		});

		panel.getreligionGraphBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Get religion graph");
			}
		});

		panel.getLanguageGraphBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Get Language graph");
			}
		});
	}

}
