package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginController;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Button;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

public class MainFrame extends JFrame {

	private SignUpPanel signUpPanel;
	private LoginPanel loginPanel;
	private NationDataSlidePanel nationDataPanel;
	private MainRetrievePanel mainRetrievePanel;
	private MainNavigatorPanel mainNavigatorPanel;

	public MainFrame() {
		setSize(1030, 660);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		loginPanel = new LoginPanel();
		getContentPane().add(loginPanel);

		signUpPanel = new SignUpPanel();
		getContentPane().add(signUpPanel);

		nationDataPanel = new NationDataSlidePanel();
		getContentPane().add(nationDataPanel);

		mainRetrievePanel = new MainRetrievePanel();
		getContentPane().add(mainRetrievePanel);

		mainNavigatorPanel = new MainNavigatorPanel();
		getContentPane().add(mainNavigatorPanel);
	}

	public SignUpPanel getSinUpPanel() {
		return this.signUpPanel;
	}

	public LoginPanel getLoginPanel() {
		return this.loginPanel;
	}

	public MainRetrievePanel getMainRetrievePanel() {
		return mainRetrievePanel;
	}

	public NationDataSlidePanel getShowNationDataPanel() {
		return nationDataPanel;
	}

	public MainNavigatorPanel getMainNevigatorPanel() {
		return mainNavigatorPanel;
	}
}
