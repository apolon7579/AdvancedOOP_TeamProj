package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginController;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Button;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;

public class MainFrame extends JFrame {

	private SignUpPanel signUpPanel;
	private LoginPanel loginPanel;

	public MainFrame() {
		setSize(1280, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		loginPanel = new LoginPanel();
		getContentPane().add(loginPanel);

		signUpPanel = new SignUpPanel();
		getContentPane().add(signUpPanel);
	}
	
	public SignUpPanel getSinUpPanel() {
		return this.signUpPanel;
	}
	
	public LoginPanel getLoginPanel() {
		return this.loginPanel;
	}
}
