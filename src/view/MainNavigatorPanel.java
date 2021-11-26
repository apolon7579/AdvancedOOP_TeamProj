package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Color;

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
	private JButton nationRegisterBtn;
	private JButton CSVuploadButton;
	private JButton CSVdownloadButton;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	private void initialize() {
		this.setBounds(0, 0, 1030, 660);
		this.setLayout(null);

		SearchButton = new JButton("검색");
		SearchButton.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		SearchButton.setBounds(368, 218, 230, 80);
		this.add(SearchButton);

		GameButton = new JButton("\uAC8C\uC784");
		GameButton.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		GameButton.setBounds(368, 334, 230, 80);
		this.add(GameButton);

		ExitButton = new JButton("\uC885\uB8CC");
		ExitButton.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		ExitButton.setBounds(368, 451, 230, 80);
		this.add(ExitButton);
		
		nationRegisterBtn = new JButton("나라등록");
		nationRegisterBtn.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		nationRegisterBtn.setBounds(51, 28, 129, 35);
		add(nationRegisterBtn);
		
		CSVuploadButton = new JButton("CSV 업로드");
		CSVuploadButton.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		CSVuploadButton.setBounds(51, 74, 129, 35);
		this.add(CSVuploadButton);
		
		CSVdownloadButton = new JButton("CSV 다운로드");
		CSVdownloadButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		CSVdownloadButton.setBounds(51, 120, 129, 35);
		this.add(CSVdownloadButton);
		
		lblNewLabel = new JLabel("와! 나라위키");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 50));
		lblNewLabel.setBounds(347, 10, 400, 219);
		add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("와! 나라위키");
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 50));
		lblNewLabel_1.setBounds(353, 16, 400, 219);
		add(lblNewLabel_1);
		
		
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
	
	public JButton getNationRegisterBtn() {
		return nationRegisterBtn;
	}

	public JButton getCSVuploadButton() {
		return CSVuploadButton;
	}
	
	public JButton getCSVdownloadButton() {
		return CSVdownloadButton;
	}
	
}
