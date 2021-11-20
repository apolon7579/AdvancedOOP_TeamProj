package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entity.Nation;
import service.NationService;
import service.NationServiceImpl;
import view.GameRulePanel;
import view.MainFrame;
import view.MainNavigatorPanel;
import view.MainRetrievePanel;

public class MainNavigatorController {

	private MainFrame mainFrame;
	private MainNavigatorPanel mainNevigatorPanel;
	private MainRetrievePanel mainRetrievePanel;
	private GameRulePanel gameRulePanel;

	private NationService nationService;

	public MainNavigatorController(MainFrame mainFrame) {

		this.mainFrame = mainFrame;
		nationService = new NationServiceImpl();

		mainNevigatorPanel = mainFrame.getMainNevigatorPanel();
		mainRetrievePanel = mainFrame.getMainRetrievePanel();
		gameRulePanel = mainFrame.getGameRulePannel();
		eventInit();
	}

	public void eventInit() {
		mainNevigatorPanel.getExitBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		// 검색 버튼
		mainNevigatorPanel.getSearchBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				List<Nation> nationList = nationService.retrieveAllNation();
				Nation arr[] = nationList.toArray(new Nation[nationList.size()]);
				JTable table = mainRetrievePanel.getTable();
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();

				dtm.setRowCount(arr.length);
				dtm.setColumnCount(5);
				table.setModel(dtm);

				table.getColumnModel().getColumn(0).setHeaderValue("이름");
				table.getColumnModel().getColumn(1).setHeaderValue("국가코드");
				table.getColumnModel().getColumn(2).setHeaderValue("수도");
				table.getColumnModel().getColumn(3).setHeaderValue("위치");
				table.getColumnModel().getColumn(4).setHeaderValue("면적");

				for (int i = 0; i < arr.length; i++) {

					String name = arr[i].getName();
					String code = arr[i].getCode();
					String capital = arr[i].getCapital();
					String location = arr[i].getLocation();
					String area = Double.toString(arr[i].getArea());

					table.setValueAt(name, i, 0);
					table.setValueAt(code, i, 1);
					table.setValueAt(capital, i, 2);
					table.setValueAt(location, i, 3);
					table.setValueAt(area, i, 4);
				}

				mainFrame.getCardLayout().show(mainFrame.getContentPane(), "mainRetrievePanel");
			}
		});

		mainNevigatorPanel.getGameBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 게임판넬 true
				mainFrame.getCardLayout().show(mainFrame.getContentPane(), "gameRulePanel");
			}
		});

	}
}
