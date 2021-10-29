package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

//이름 변경 해도 OK

public class NationData_SlidePanel extends JPanel{

	public NationData_SlidePanel() {
		setBackground(Color.PINK);
		setBounds(3, 34, 349, 333);
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 52, 325, 271);
		this.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		scrollPane.setRowHeaderView(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.MAGENTA);
		scrollPane.setViewportView(panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		panel_2.add(lblNewLabel_2);

		JButton btnNewButton = new JButton("뒤로가기");
		btnNewButton.setBounds(12, 10, 81, 23);
		this.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("나라 이름 가운데 정렬");
		lblNewLabel.setBounds(12, 14, 325, 28);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		this.add(lblNewLabel);

	}

}
