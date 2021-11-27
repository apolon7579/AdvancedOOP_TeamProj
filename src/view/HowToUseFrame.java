package view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HowToUseFrame extends JFrame {

	private JLabel picLabel;
	URL[] myPicture = null;
	int index = 0;

	public HowToUseFrame() {
		setSize(930, 560);
		setLocationRelativeTo(null);
		setVisible(true);
		myPicture = new URL[6];
		for (int i = 0; i < 6; i++) {
			myPicture[i] = getClass().getResource("/how/" + i + ".png");
		}
		picLabel = new JLabel(new ImageIcon(myPicture[index++]));
		picLabel.setHorizontalAlignment(SwingConstants.LEFT);
		getContentPane().add(picLabel);

		JButton btnNewButton = new JButton("다음");
		getContentPane().add(btnNewButton, BorderLayout.EAST);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (index > 5) {
					setVisible(false);
					return;
				}
				picLabel.setIcon(new ImageIcon(myPicture[index++]));
			}
		});
	}
}
