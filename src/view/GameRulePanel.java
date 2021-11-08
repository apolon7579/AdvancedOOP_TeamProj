package view;

import java.awt.Component;
import java.awt.Font;

import javax.swing.DropMode;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class GameRulePanel extends JPanel {
	private JTextField textField;

	public GameRulePanel() {
		setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setEnabled(false);
		textField.setFont(new Font("굴림", Font.PLAIN, 20));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("게임");
		textField.setBounds(224, 56, 347, 65);
		textField.setHorizontalAlignment(JTextField.CENTER);
		add(textField);
		textField.setColumns(10);
		
		JTextArea txtrTest = new JTextArea();
		txtrTest.setText("test");
		txtrTest.setAlignmentX(Component.CENTER_ALIGNMENT);
		txtrTest.setBounds(97, 194, 605, 237);
		add(txtrTest);
		
		JButton btnNewButton = new JButton("게임 시작");
		btnNewButton.setBounds(262, 481, 236, 65);
		add(btnNewButton);

	}
}
