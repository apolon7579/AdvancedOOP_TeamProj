package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainFrame;
import view.MenuBarPanel;

public class MenuBarController {
	private MenuBarPanel panel;

	public MenuBarController(MainFrame mainFrame) {
		panel = mainFrame.getMenuBarPanel();
		eventInit();
	}

	private void eventInit() {
		
	}

}
