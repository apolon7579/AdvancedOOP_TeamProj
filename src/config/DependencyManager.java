package config;

import controller.GameController;
import controller.GameRuleController;
import controller.HistogramPanelController;
import controller.LoginController;
import controller.MainNavigatorController;
import controller.MainRetrieveController;
import controller.MenuBarController;
import controller.NationDataSlideController;
import controller.NationRegisterPanelController;
import controller.SignUpController;
import view.MainFrame;

//의존성 관리를 담당하는 클래스
public class DependencyManager {

	private static DependencyManager manager = new DependencyManager();

	// Controller의 모든 의존성 관리를 이 클래스에서 처리한다.
	// MainFrame또한 이 클래스에서 초기화 하며 안의 패널들은 mainFrame안에서 자체적으로 초기화
	// Controller의 경우 맨 처음에는 각 Panel들이 Controller들의 클래스를 가지고 있었고 각 Controller등의 초기화를
	// 담당했으나
	// MainFrame의 모든 지역 변수들이 초기화된 이후에 Controller가 초기화 되어야 하나 이전 방식은 그렇게 할 수 없는
	// 방식이였기떄문에
	// Controller들의 모든 의존성 관리를 현 클래스에서 전부 담당하는것으로 함 즉, 각 Panel 및 Frame들은 더이상
	// Controller 클래스를 가지고있거나
	// 초기화 하는 역할을 맡지 않으며 이런 역할들은 현재 DependencyMangager 클래스에 모두 위임됨
	private DependencyManager() {
		MainFrame mainFrame = new MainFrame();
		LoginController loginController = new LoginController(mainFrame);
		SignUpController signUpController = new SignUpController(mainFrame);
		MainRetrieveController mainRetrieveController = new MainRetrieveController(mainFrame);
		NationDataSlideController nationDataController = new NationDataSlideController(mainFrame);
		MainNavigatorController mainNavigatorController = new MainNavigatorController(mainFrame);
		MenuBarController menuBarController = new MenuBarController(mainFrame);
		GameRuleController gameRuleController = new GameRuleController(mainFrame);
		GameController gameController = new GameController(mainFrame);
		HistogramPanelController histogramController = new HistogramPanelController(mainFrame);
		NationRegisterPanelController nationRegisterPanelController = new NationRegisterPanelController(mainFrame);
		mainFrame.setVisible(true);
	}

	public static DependencyManager managerStart() {
		return manager;
	}

}
