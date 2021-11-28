package view;

import java.awt.CardLayout;

import javax.swing.JFrame;

//root 프레임
public class MainFrame extends JFrame {

	private SignUpPanel signUpPanel;
	private LoginPanel loginPanel;
	private NationDataSlidePanel nationDataPanel;
	private MainRetrievePanel mainRetrievePanel;
	private MainNavigatorPanel mainNavigatorPanel;
	private GameRulePanel gameRulePanel;
	private MenuBarPanel menuBarPanel;
	private GamePanel gamePanel;
	private HistogramPanel histogramPanel;
	private NationRegisterPanel nationRegisterPanel;

	private CardLayout cardLayout;

	//초기화
	public MainFrame() {
		setSize(1030, 660);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		getContentPane().setLayout(cardLayout = new CardLayout());
		
		loginPanel = new LoginPanel();
		getContentPane().add("loginPanel", loginPanel);

		signUpPanel = new SignUpPanel();
		getContentPane().add("signUpPanel", signUpPanel);

		nationDataPanel = new NationDataSlidePanel();
		getContentPane().add("nationDataPanel", nationDataPanel);

		mainRetrievePanel = new MainRetrievePanel();
		getContentPane().add("mainRetrievePanel", mainRetrievePanel);

		mainNavigatorPanel = new MainNavigatorPanel();
		getContentPane().add("mainNavigatorPanel", mainNavigatorPanel);

		gameRulePanel = new GameRulePanel();
		getContentPane().add("gameRulePanel", gameRulePanel);

		menuBarPanel = new MenuBarPanel();
		getContentPane().add(menuBarPanel);

		gamePanel = new GamePanel();
		getContentPane().add("gamePanel", gamePanel);
		
		histogramPanel = new HistogramPanel();
		getContentPane().add("histogramPanel", histogramPanel);
		
		nationRegisterPanel = new NationRegisterPanel();
		getContentPane().add("nationRegisterPanel", nationRegisterPanel);
	}

	public void setJMenuBar(boolean b) {
		if (b)
			setJMenuBar(menuBarPanel.menuBar);
		else
			setJMenuBar(null);
	}

	public CardLayout getCardLayout() {
		return this.cardLayout;
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

	public NationRegisterPanel getNationRegisterPanel() {
		return nationRegisterPanel;
	}

	public GameRulePanel getGameRulePannel() {
		return gameRulePanel;
	}

	public MenuBarPanel getMenuBarPanel() {
		return menuBarPanel;
	}

	public GamePanel getGamePannel() {
		return gamePanel;
	}
	
	public HistogramPanel getHistogramPanel() {
		return histogramPanel;
	}
}
