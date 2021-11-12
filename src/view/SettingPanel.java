package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class SettingPanel{

	private JFrame frame;
	private final JPanel panel = new JPanel();
	private final JLabel coloreLabel = new JLabel("해상도");
	private final JLabel langLabel = new JLabel("언어");
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SettingPanel window = new SettingPanel();
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
	public SettingPanel() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		panel.setBounds(0, 0, 1266, 673);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel setLable = new JLabel("설정");
		setLable.setHorizontalAlignment(SwingConstants.CENTER);
		setLable.setFont(new Font("돋움", Font.BOLD, 50));
		setLable.setBounds(470, 10, 251, 51);
		panel.add(setLable);
		coloreLabel.setFont(new Font("굴림", Font.PLAIN, 25));
		coloreLabel.setBounds(229, 117, 107, 65);
		
		panel.add(coloreLabel);
		langLabel.setFont(new Font("굴림", Font.PLAIN, 25));
		langLabel.setBounds(229, 367, 80, 40);
		
		panel.add(langLabel);
		
		JButton coloredbtn1 = new JButton("해상도1");
		coloredbtn1.setBounds(648, 117, 398, 51);
		panel.add(coloredbtn1);
		
		JButton coloredbtn2 = new JButton("해상도2");
		coloredbtn2.setBounds(648, 188, 398, 51);
		panel.add(coloredbtn2);
		
		JButton coloredbtn3 = new JButton("해상도3");
		coloredbtn3.setBounds(648, 264, 398, 51);
		panel.add(coloredbtn3);
		
		JButton langbtn1 = new JButton("언어1");
		langbtn1.setBounds(648, 365, 398, 51);
		panel.add(langbtn1);
		
		JButton langbtn2 = new JButton("언어2");
		langbtn2.setBounds(648, 444, 398, 51);
		panel.add(langbtn2);
		
		JButton langbtn3 = new JButton("언어3");
		langbtn3.setBounds(648, 519, 398, 51);
		panel.add(langbtn3);
		
		JButton backbtn = new JButton("<-");
		backbtn.setBounds(55, 10, 62, 23);
		panel.add(backbtn);
	}
}
