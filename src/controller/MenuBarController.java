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
import view.DevelopersFrame;
import view.HowToUseFrame;
import view.MainFrame;
import view.MainRetrievePanel;
import view.MenuBarPanel;

//메뉴바 컨트롤러
public class MenuBarController {
	private MenuBarPanel panel;
	private MainFrame mainFrame;

	private MainRetrievePanel mainRetrievePanel;
	private NationService nationService;

	//초기화
	public MenuBarController(MainFrame mainFrame) {
		panel = mainFrame.getMenuBarPanel();
		this.mainFrame = mainFrame;
		nationService = new NationServiceImpl();
		mainRetrievePanel = mainFrame.getMainRetrievePanel();
		eventInit();
	}

	//버튼 액션리스너 초기화
	private void eventInit() {
		//search버튼
		panel.getSearchMenuItem().addActionListener(new ActionListener() {
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
		//game버튼
		panel.getGameMenuItem().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getGameRulePannel().clicked();
				mainFrame.getCardLayout().show(mainFrame.getContentPane(), "gameRulePanel");
			}
		});
		//login버튼
		panel.getLoginMenuItem().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getCardLayout().show(mainFrame.getContentPane(), "loginPanel");
				mainFrame.setJMenuBar(false);
			}
		});
		//exit버튼
		panel.getExitMenuItem().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		//해상도버튼1
		panel.getResolution_1MenuItem().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Change Resolution 1");
			}
		});
		//해상도버튼2
		panel.getResolution_2MenuItem().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Change Resolution 2");
			}
		});
		//해상도버튼3
		panel.getResolution_3MenuItem().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Change Resolution 3");
			}
		});
		//한국어버튼
		panel.getLanguageKorMenuItem().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Change Language Kor");
			}
		});
		//영어어버튼
		panel.getLanguageEngMenuItem().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Change Language Eng");
			}
		});
		
		//csv업로드버튼
		panel.getCsvUpLoadMenuItem().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileFilter(new FileNameExtensionFilter("csv", "CSV"));
				fileChooser.setMultiSelectionEnabled(false);
				if (fileChooser.showOpenDialog(mainFrame) == JFileChooser.APPROVE_OPTION) {
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
		
		//csv다운로드버튼
		panel.getCsvDownLoadMenuItem().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				fileChooser.setMultiSelectionEnabled(false);
				if (fileChooser.showSaveDialog(mainFrame) == JFileChooser.APPROVE_OPTION) {
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
		//도움말버튼
		panel.getHelpMenuItem().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HowToUseFrame f = new HowToUseFrame();
			}
		});
		//개발자버튼
		panel.getDevelopersMenuItem().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DevelopersFrame f = new DevelopersFrame();
			}
		});
	}

}
