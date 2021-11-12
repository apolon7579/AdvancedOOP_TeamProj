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
	private String[] header = {"이름","국가코드","수도","위치","면적"};
	private String[][] data = {};
	
	public MainRetrievePanel() {
		setBounds(0, 0, 1030, 660);
		setLayout(null);
		
		String comboItems[] = {"이름", "기후", "종교", "민족", "언어"};
		searchComboBox = new JComboBox(comboItems);
		searchComboBox.setBounds(93, 49, 101, 23);
		add(searchComboBox);
		
		searchField = new JTextField();
		searchField.setBounds(243, 49, 508, 23);
		add(searchField);
		searchField.setColumns(10);
		
		searchBtn = new JButton("검색");
		searchBtn.setBounds(798, 49, 97, 23);
		add(searchBtn);
				
		
		goBackBtn = new JButton("돌아가기");
		goBackBtn.setBounds(93, 574, 97, 23);
		add(goBackBtn);
		
		csvExportBtn = new JButton("csv 내보내기");
		csvExportBtn.setBounds(781, 574, 114, 23);
		add(csvExportBtn);
		
		retrieveAllBtn = new JButton("전체조회");
		retrieveAllBtn.setBounds(543, 574, 97, 23);
		add(retrieveAllBtn);
				
		detailBtn = new JButton("상세조회");
		detailBtn.setBounds(663, 574, 97, 23);
		add(detailBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(93, 134, 800, 370);
		add(scrollPane);
		
		table = new JTable();
		table.setBounds(95, 159, 800, 370);
		table.setPreferredScrollableViewportSize(new Dimension(800,370));
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		setVisible(false);
	}

	public JTextField getSearchField() {
		return searchField;
	}

	public JComboBox getSearchComboBox() {
		return searchComboBox;
	}

	public JButton getSearchBtn() {
		return searchBtn;
	}

	public JButton getGoBackBtn() {
		return goBackBtn;
	}

	public JButton getCsvExportBtn() {
		return csvExportBtn;
	}

	public JButton getRetrieveAllBtn() {
		return retrieveAllBtn;
	}

	public JButton getDetailBtn() {
		return detailBtn;
	}

	public JTable getTable() {
		return table;
	}

	public void setData(String[][] data) {
		this.data = data;
	}

	public String[] getHeader() {
		return header;
	}

	public String[][] getData() {
		return data;
	}


	
	
}
