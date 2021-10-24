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

public class MFrame extends JFrame {

	private LoginController _lc;

	public MFrame() {
		setSize(1280, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		LoginPanel _loginPanel = new LoginPanel();
		getContentPane().add(_loginPanel);

		SignUpPanel _signUpPanel = new SignUpPanel();
		getContentPane().add(_signUpPanel);

		_lc = new LoginController(_loginPanel, _signUpPanel);

		// setBounds(100, 100, 800, 600);
		// contentPane = new Test();
		// contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// setContentPane(contentPane);
		// contentPane.setLayout(null);
	}
}
