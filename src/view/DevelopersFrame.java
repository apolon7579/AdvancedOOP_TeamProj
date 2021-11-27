package view;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class DevelopersFrame extends JFrame {

	public DevelopersFrame() {
		getContentPane().setBackground(Color.WHITE);
		setSize(760, 550);
		setLocationRelativeTo(null);
		setVisible(true);
		JLabel picLabel = new JLabel(new ImageIcon(getClass().getResource("/how/secret.png")));
		picLabel.setHorizontalAlignment(SwingConstants.LEFT);
		getContentPane().add(picLabel);
	}
}
