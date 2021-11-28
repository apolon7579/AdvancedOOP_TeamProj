package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

//메뉴바 패널
public class MenuBarPanel extends JPanel {

	public JMenuBar menuBar;

	private JMenu fileMenu;
	private JMenu editMenu;
	private JMenu helpMenu;

	private JMenu openMenu;
	private JMenuItem searchItem;
	private JMenuItem gameItem;
	private JMenuItem loginItem;
	private JMenuItem exitItem;

	private JMenu resolutionMenu;
	private JMenuItem resolutionItem_1;
	private JMenuItem resolutionItem_2;
	private JMenuItem resolutionItem_3;
	
	private JMenu languageMenu;
	private JMenuItem languageMenuItem_1;
	private JMenuItem languageMenuItem_2;
	
	private JMenu csvMenu;
	private JMenuItem csvUpLoadMenuItem;
	private JMenuItem csvDownLoadMenuItem;

	private JMenuItem helpItem;
	private JMenuItem developerItem;

	//초기화
	public MenuBarPanel() {
		setPreferredSize(new Dimension(100, 1));
		setBackground(Color.LIGHT_GRAY);
		menuBar = new JMenuBar();

		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		helpMenu = new JMenu("Help");
		csvMenu = new JMenu("CSV");

		setFileMenu();
		setEditMenu();
		setHelpMenu();
		setcsvMenu();

		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(csvMenu);
		menuBar.add(helpMenu);
	}

	//HelpMenu 초기화
	private void setHelpMenu() {
		helpItem = new JMenuItem("How to use");
		developerItem = new JMenuItem("Developers");
		helpMenu.add(helpItem);
		helpMenu.add(developerItem);
	}

	//FileMenu 초기화
	private void setFileMenu() {
		openMenu = new JMenu("Open");
		searchItem = new JMenuItem("Search");
		gameItem = new JMenuItem("Game");
		loginItem = new JMenuItem("Login");
		exitItem = new JMenuItem("Exit");

		openMenu.add(searchItem);
		openMenu.add(gameItem);
		openMenu.add(loginItem);

		fileMenu.add(openMenu);
		fileMenu.add(exitItem);
	}

	//editMenu 초기화
	private void setEditMenu() {
		resolutionMenu = new JMenu("Resolution");
		resolutionItem_1 = new JMenuItem("300x300");
		resolutionItem_2 = new JMenuItem("500x500");
		resolutionItem_3 = new JMenuItem("800x800");
		languageMenu = new JMenu("Language");
		languageMenuItem_1 = new JMenuItem("Korean");
		languageMenuItem_2 = new JMenuItem("English");

		resolutionMenu.add(resolutionItem_1);
		resolutionMenu.add(resolutionItem_2);
		resolutionMenu.add(resolutionItem_3);

		languageMenu.add(languageMenuItem_1);
		languageMenu.add(languageMenuItem_2);

		editMenu.add(resolutionMenu);
		editMenu.add(languageMenu);
	}
	
	//csvMenu 초기화
	private void setcsvMenu() {
		csvUpLoadMenuItem = new JMenuItem("upload");
		csvDownLoadMenuItem = new JMenuItem("download");
		csvMenu.add(csvUpLoadMenuItem);
		csvMenu.add(csvDownLoadMenuItem);
	}

	// TODO..
	public JMenuItem getSearchMenuItem() {
		return searchItem;
	}

	public JMenuItem getGameMenuItem() {
		return gameItem;
	}

	public JMenuItem getLoginMenuItem() {
		return loginItem;
	}

	public JMenuItem getExitMenuItem() {
		return exitItem;
	}

	public JMenuItem getResolution_1MenuItem() {
		return resolutionItem_1;
	}

	public JMenuItem getResolution_2MenuItem() {
		return resolutionItem_2;
	}

	public JMenuItem getResolution_3MenuItem() {
		return resolutionItem_3;
	}

	public JMenuItem getLanguageKorMenuItem() {
		return languageMenuItem_1;
	}

	public JMenuItem getLanguageEngMenuItem() {
		return languageMenuItem_2;
	}

	public JMenuItem getHelpMenuItem() {
		return helpItem;
	}

	public JMenuItem getDevelopersMenuItem() {
		return developerItem;
	}

	public JMenuItem getCsvUpLoadMenuItem() {
		return csvUpLoadMenuItem;
	}

	public JMenuItem getCsvDownLoadMenuItem() {
		return csvDownLoadMenuItem;
	}
}
