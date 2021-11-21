package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dto.NationDto;
import entity.Climate;
import entity.ListItem;
import entity.Nation;
import service.NationService;
import service.NationServiceImpl;
import service.WriteCSV;
import view.MainFrame;
import view.MainNavigatorPanel;
import view.MainRetrievePanel;
import view.NationDataSlidePanel;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
public class MainRetrieveController {

	private MainRetrievePanel mainRetrievePanel;
	private MainNavigatorPanel mainNavigatorPanel;
	private NationDataSlidePanel nationDataSlidePanel;
	private NationService nationService;
	private MainFrame mainFrame;

	public MainRetrieveController(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		mainRetrievePanel = mainFrame.getMainRetrievePanel();
		mainNavigatorPanel = mainFrame.getMainNevigatorPanel();
		nationDataSlidePanel = mainFrame.getNationDataSlidePanel();
		nationService = new NationServiceImpl();
		eventInit();
	}
	
	private <T> String getListString(List<T> list) {
		
		List<ListItem> tmpList = (List<ListItem>) list;
		
		String tmp = "";
		
		if(list != null) {
			for(int i = 0; i < list.size(); i++) {
				String item = tmpList.get(i).getName();
				tmp += (item + " ");
			}
		}
		
		return tmp;
	}

	private void initTableByNationList(List<Nation> nationList) {
		JTable table = mainRetrievePanel.getTable();
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();

		dtm.setRowCount(nationList.size());
		dtm.setColumnCount(5);
		table.setModel(dtm);

		table.getColumnModel().getColumn(0).setHeaderValue("이름");
		table.getColumnModel().getColumn(1).setHeaderValue("국가코드");
		table.getColumnModel().getColumn(2).setHeaderValue("수도");
		table.getColumnModel().getColumn(3).setHeaderValue("위치");
		table.getColumnModel().getColumn(4).setHeaderValue("면적");
		for (int i = 0; i < nationList.size(); i++) {

			String name = nationList.get(i).getName();
			String code = nationList.get(i).getCode();
			String capital = nationList.get(i).getCapital();
			String location = nationList.get(i).getLocation();
			String area = Double.toString(nationList.get(i).getArea());

			table.setValueAt(name, i, 0);
			table.setValueAt(code, i, 1);
			table.setValueAt(capital, i, 2);
			table.setValueAt(location, i, 3);
			table.setValueAt(area, i, 4);
		}
	}
	
	private void eventInit() {

		// 뒤로가기 버튼
		mainRetrievePanel.getGoBackBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getCardLayout().show(mainFrame.getContentPane(), "mainNavigatorPanel");
			}

		});

		// 상세조회 버튼
		mainRetrievePanel.getDetailBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JTable table = mainRetrievePanel.getTable();
				int row = table.getSelectedRow();
				String nationName = (String) table.getModel().getValueAt(row, 0);
				NationDto nation = nationService.retrieveNationByName(nationName);
				
				JLabel title = nationDataSlidePanel.getPageTitle();
				JLabel nationCodeValue = nationDataSlidePanel.getNationCodeValue();
				JLabel capitalValue = nationDataSlidePanel.getCapitalValue();
				JLabel climateValue = nationDataSlidePanel.getClimateValue();
				JLabel cityValue = nationDataSlidePanel.getCityValue();
				JLabel religionValue = nationDataSlidePanel.getReligionValue();
				JLabel raceValue = nationDataSlidePanel.getRaceValue();
				JLabel mediaValue = nationDataSlidePanel.getMediaValue();
				JLabel locationValue = nationDataSlidePanel.getLocationValue();
				JLabel areaValue = nationDataSlidePanel.getAreaValue();
				JLabel areaSourceValue = nationDataSlidePanel.getAreaSourceValue();
				JLabel languageValue = nationDataSlidePanel.getLanguageValue();
				
				title.setText(nation.getName());
				nationCodeValue.setText(nation.getCode());
				capitalValue.setText(nation.getCapital());
								
				List<Climate> climateList = nation.getClimateList();
				getListString(climateList);
				
				climateValue.setText(getListString(nation.getClimateList()));
				cityValue.setText(getListString(nation.getCityList()));
				religionValue.setText(getListString(nation.getReligionList()));
				raceValue.setText(getListString(nation.getRaceList()));
				mediaValue.setText(getListString(nation.getMediaList()));
				locationValue.setText(nation.getLocation());
				areaValue.setText(Double.toString(nation.getArea()));
				areaSourceValue.setText(nation.getAreaSource());
				languageValue.setText(getListString(nation.getLanguageList()));
				
				mainFrame.getCardLayout().show(mainFrame.getContentPane(), "nationDataPanel");
			}

		});
		
		//전체조회 버튼
		mainRetrievePanel.getRetrieveAllBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				List<Nation> nationList = nationService.retrieveAllNation();
				Nation arr[] = nationList.toArray(new Nation[nationList.size()]);
				JTable table = mainRetrievePanel.getTable();
				DefaultTableModel dtm = (DefaultTableModel)table.getModel();
				
				dtm.setRowCount(arr.length);
				dtm.setColumnCount(5);
				table.setModel(dtm);
				
				table.getColumnModel().getColumn(0).setHeaderValue("이름");
				table.getColumnModel().getColumn(1).setHeaderValue("국가코드");
				table.getColumnModel().getColumn(2).setHeaderValue("수도");
				table.getColumnModel().getColumn(3).setHeaderValue("위치");
				table.getColumnModel().getColumn(4).setHeaderValue("면적");
				
				for(int i = 0; i < arr.length; i++) {
										
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
			}
			
		});
		
		//검색하기 버튼

		mainRetrievePanel.getSearchBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox box = mainRetrievePanel.getSearchComboBox();
				String searchValue = mainRetrievePanel.getSearchField().getText();
				String val = box.getSelectedItem().toString();
				List<Nation> nationList = null;
				if (val.equals("이름")) {
				    nationList = nationService.retrieveBySearchValue(searchValue, "name");
					JTable table = mainRetrievePanel.getTable();
					DefaultTableModel dtm = (DefaultTableModel) table.getModel();

					dtm.setRowCount(nationList.size());
					dtm.setColumnCount(5);
					table.setModel(dtm);

					table.getColumnModel().getColumn(0).setHeaderValue("이름");
					table.getColumnModel().getColumn(1).setHeaderValue("국가코드");
					table.getColumnModel().getColumn(2).setHeaderValue("수도");
					table.getColumnModel().getColumn(3).setHeaderValue("위치");
					table.getColumnModel().getColumn(4).setHeaderValue("면적");

					for (int i = 0; i < nationList.size(); i++) {

						String name = nationList.get(i).getName();
						String code = nationList.get(i).getCode();
						String capital = nationList.get(i).getCapital();
						String location = nationList.get(i).getLocation();
						String area = Double.toString(nationList.get(i).getArea());

						table.setValueAt(name, i, 0);
						table.setValueAt(code, i, 1);
						table.setValueAt(capital, i, 2);
						table.setValueAt(location, i, 3);
						table.setValueAt(area, i, 4);
					}
				}else if(val.equals("기후")) {
					nationList = nationService.retrieveBySearchValueAndTable(searchValue, "climate");
					initTableByNationList(nationList);
				}else if(val.equals("종교")) {
					nationList = nationService.retrieveBySearchValueAndTable(searchValue, "religion");
					initTableByNationList(nationList);
				}else if(val.equals("민족")) {
					nationList = nationService.retrieveBySearchValueAndTable(searchValue, "race");
					initTableByNationList(nationList);
				}else if(val.equals("언어")) {
					nationList = nationService.retrieveBySearchValueAndTable(searchValue, "language");
					initTableByNationList(nationList);
				}
			}

		});
        mainRetrievePanel.getCsvExportBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTable table = mainRetrievePanel.getTable();
                List<Nation> nations = new ArrayList<Nation>();
                for(int i = 0; i < table.getRowCount(); i++)
                {
                    nations.add(new Nation(null, table.getValueAt(i, 0) == null ? null : table.getValueAt(i, 0).toString(),
                            table.getValueAt(i, 1) == null ? null : table.getValueAt(i, 1).toString(),
                            table.getValueAt(i, 2) == null ? null : table.getValueAt(i, 2).toString(),
                            table.getValueAt(i, 3) == null ? null : table.getValueAt(i, 3).toString(),
                            table.getValueAt(i, 4) == null ? null : Double.parseDouble(table.getValueAt(i, 4).toString()), null, null, null));
                }
                if(nations == null || nations.size() == 0)
                    return;
                WriteCSV writeCSV = new WriteCSV();
                if(writeCSV.writeFile(nations, LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd_")) + LocalTime.now().format(DateTimeFormatter.ofPattern("HH_mm_ss")), "./"))
                    JOptionPane.showMessageDialog(null, "데이터 내보내기 성공");
                else
                    JOptionPane.showMessageDialog(null, "데이터 내보내기 실패");
            }
        });
	}

}
