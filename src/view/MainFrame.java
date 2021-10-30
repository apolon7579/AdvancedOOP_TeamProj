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
	private NationData_SlidePanel nationDataPanel;
	private MainRetrievePanel mainRetrievePanel;

	public MainFrame() {
		setSize(1280, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		// 이중화 슬라이드 판넬 테스트
		nationDataPanel = new NationData_SlidePanel();
		getContentPane().add(nationDataPanel);

		loginPanel = new LoginPanel();
		// getContentPane().add(loginPanel);

		signUpPanel = new SignUpPanel();
		// getContentPane().add(signUpPanel);

		mainRetrievePanel = new MainRetrievePanel();
		// getContentPane().add(mainRetrievePanel);
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

	public NationData_SlidePanel getShowNationDataPanel() {
		return nationDataPanel;
	}
}
