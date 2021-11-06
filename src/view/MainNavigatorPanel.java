package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainNavigatorPanel extends JPanel {

	// private JFrame frame;
	// private final JPanel panel = new JPanel();
	private JButton SearchButton;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainNavigatorPanel window = new MainNavigatorPanel();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public MainNavigatorPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private JButton ExitButton;
	private JButton GameButton;
	private JButton SettingButton;

	private void initialize() {
		this.setBounds(103, 10, 1028, 661);
		this.setLayout(null);

		SearchButton = new JButton("검색");
		SearchButton.setBounds(373, 217, 186, 51);
		this.add(SearchButton);

		GameButton = new JButton("\uAC8C\uC784");
		GameButton.setBounds(373, 290, 186, 51);
		this.add(GameButton);

		ExitButton = new JButton("\uC885\uB8CC");
		ExitButton.setBounds(373, 366, 186, 51);
		this.add(ExitButton);

		SettingButton = new JButton("\uC124\uC815");
		SettingButton.setBounds(960, 30, 68, 23);
		this.add(SettingButton);

		JLabel NameLabel = new JLabel("\uB098\uB77C\uC704\uD0A4");
		NameLabel.setFont(new Font("굴림", Font.PLAIN, 25));
		NameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		NameLabel.setBounds(387, 160, 152, 37);
		this.add(NameLabel);

		setVisible(false);
	}

	public JButton getExitBtn() {
		return ExitButton;
	}

	public JButton getSearchBtn() {
		return SearchButton;
	}
	
	public JButton getGameBtn() {
		return GameButton;
	}
}
