package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import service.DataService;
import service.DataServiceImpl;
import view.Test;

public class TestController {

	private Test panel;
	private DataService dataService;
	
	public TestController(Test panel) {
		this.panel = panel;
		this.dataService = new DataServiceImpl();
		eventInit();
	}
	
	public void eventInit() {
		panel.getJButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//dataService.getAllNationList();
				System.out.println("이벤트동작 확인");
			}
		});
	}
	
}
