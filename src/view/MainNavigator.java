package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainNavigator {

	private JFrame frame;
	private final JPanel panel = new JPanel();
	private JButton SearchButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainNavigator window = new MainNavigator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainNavigator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		panel.setBounds(0, 0, 436, 263);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		SearchButton = new JButton("\uAC80\uC0C9");
		SearchButton.setBounds(128, 73, 186, 51);
		panel.add(SearchButton);
		
		JButton GameButton = new JButton("\uAC8C\uC784");
		GameButton.setBounds(128, 134, 186, 51);
		panel.add(GameButton);
		
		JButton ExitButton = new JButton("\uC885\uB8CC");
		ExitButton.setBounds(128, 202, 186, 51);
		panel.add(ExitButton);
		
		JLabel NameLabel = new JLabel("\uB098\uB77C\uC704\uD0A4");
		NameLabel.setFont(new Font("굴림", Font.PLAIN, 25));
		NameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		NameLabel.setBounds(145, 26, 152, 37);
		panel.add(NameLabel);
		
		JButton SettingButton = new JButton("\uC124\uC815");
		SettingButton.setBounds(356, 10, 68, 23);
		panel.add(SettingButton);
	}
}
