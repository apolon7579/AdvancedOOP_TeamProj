package view;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MainRetrievePanel extends JPanel{
	private JTextField searchField;
	private JComboBox searchComboBox;
	private JButton searchBtn;
	private JButton goBackBtn;
	private JButton csvExportBtn;
	private JButton retrieveAllBtn;
	private JButton detailBtn;
	private JTable table;
	
	public MainRetrievePanel() {
		setBounds(103, 10, 1029, 660);
		setLayout(null);
		
		String comboItems[] = {"이름", "기후", "종교", "민족", "언어"};
		searchComboBox = new JComboBox(comboItems);
		searchComboBox.setBounds(95, 74, 101, 23);
		add(searchComboBox);
		
		searchField = new JTextField();
		searchField.setBounds(245, 74, 508, 23);
		add(searchField);
		searchField.setColumns(10);
		
		searchBtn = new JButton("검색");
		searchBtn.setBounds(800, 74, 97, 23);
		add(searchBtn);
				
		
		goBackBtn = new JButton("돌아가기");
		goBackBtn.setBounds(95, 599, 97, 23);
		add(goBackBtn);
		
		csvExportBtn = new JButton("csv 내보내기");
		csvExportBtn.setBounds(783, 599, 114, 23);
		add(csvExportBtn);
		
		retrieveAllBtn = new JButton("전체조회");
		retrieveAllBtn.setBounds(545, 599, 97, 23);
		add(retrieveAllBtn);
		
		String[][] data = {
				{"튀니지", "TN", "튀니스", "북부 아프리카 중앙지중해 연안", "155360"},
				{"트리니다드토바고", "TT", "포트 오브 스페인", "카리브해", "5130"}
		};
		String[] header = {"이름","국가코드","수도","위치","면적"};
		
		detailBtn = new JButton("상세조회");
		detailBtn.setBounds(665, 599, 97, 23);
		add(detailBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(95, 159, 800, 370);
		add(scrollPane);
		
		table = new JTable(data,header);
		table.setBounds(95, 159, 800, 370);
		table.setPreferredScrollableViewportSize(new Dimension(800,370));
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		setVisible(false);
	}
}
