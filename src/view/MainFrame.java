package view;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	private SignUpPanel signUpPanel;
	private LoginPanel loginPanel;
	private NationDataSlidePanel nationDataPanel;
	private MainRetrievePanel mainRetrievePanel;
	private MainNavigatorPanel mainNavigatorPanel;
	private GameRulePanel gameRulePanel;

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
		
		gameRulePanel = new GameRulePanel();
		getContentPane().add(gameRulePanel);
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

	public NationDataSlidePanel getNationDataSlidePanel() {
		return nationDataPanel;
	}

	public MainNavigatorPanel getMainNevigatorPanel() {
		return mainNavigatorPanel;
	}
	
	public GameRulePanel getGameRulePannel() {
		return gameRulePanel;
	}
}
