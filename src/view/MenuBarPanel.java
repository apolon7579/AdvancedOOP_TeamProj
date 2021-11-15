package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

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

	private JMenuItem helpItem;
	private JMenuItem developerItem;

	public MenuBarPanel() {
		setPreferredSize(new Dimension(100, 1));
		setBackground(Color.LIGHT_GRAY);
		menuBar = new JMenuBar();

		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		helpMenu = new JMenu("Help");

		setFileMenu();
		setEditMenu();
		setHelpMenu();

		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);
	}

	private void setHelpMenu() {
		helpItem = new JMenuItem("How to use");
		developerItem = new JMenuItem("Developers");
		helpMenu.add(helpItem);
		helpMenu.add(developerItem);
	}

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

	// TODO..
	public void getSearchMenuItem() {

	}
}
