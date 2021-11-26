					package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import entity.Nation;
import service.FileService;
import service.FileServiceImpl;
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
				
				
				mainFrame.getGameRulePannel().clicked();
				mainFrame.getCardLayout().show(mainFrame.getContentPane(), "gameRulePanel");
			}
		});

		mainNevigatorPanel.getNationRegisterBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getCardLayout().show(mainFrame.getContentPane(), "nationRegisterPanel");
			}

		});

		mainNevigatorPanel.getCSVuploadButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileFilter(new FileNameExtensionFilter("csv", "CSV"));
				fileChooser.setMultiSelectionEnabled(false);
				if (fileChooser.showOpenDialog(mainNevigatorPanel) == JFileChooser.APPROVE_OPTION) {
					try {
						FileService fileService = new FileServiceImpl();
						fileService.upload(Path.of(fileChooser.getSelectedFile().getPath()));
						JOptionPane.showMessageDialog(null, "업로드가 완료되었습니다.");
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "업로드에 실패했습니다.\n에러내용: " + e1.getMessage(), "파일 업로드 에러",
								JOptionPane.ERROR_MESSAGE);
					}

				}
			}
		});
		
		mainNevigatorPanel.getCSVdownloadButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				fileChooser.setMultiSelectionEnabled(false);
				if (fileChooser.showSaveDialog(mainNevigatorPanel) == JFileChooser.APPROVE_OPTION) {
					try {
						FileService fileService = new FileServiceImpl();
						fileService.download(Path.of(fileChooser.getSelectedFile().getPath()));
						JOptionPane.showMessageDialog(null, "다운로드가 완료되었습니다.");
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "다운로드에 실패했습니다.\n에러내용: " + e1.getMessage(), "파일 다운로드 에러",
								JOptionPane.ERROR_MESSAGE);
					}

				}
			}
		});
	}
}
