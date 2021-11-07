package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GamePanel {

	private JFrame frame;
	private JLabel questionLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GamePanel window = new GamePanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GamePanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(-12, 0, 1266, 683);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		ImageIcon new1= new ImageIcon("C://Users//jsk//Desktop//국기사진/가나.png");
		ImageIcon new2= new ImageIcon("C://Users//jsk//Desktop//국기사진/가봉.png");
		
		
//		Image num1=icon.getImage();
//		Image new1=num1.getScaledInstance(500, 300, Image.SCALE_DEFAULT);
//		ImageIcon icon2=new ImageIcon(new1);
//		JLabel img1=new JLabel(icon2);
//		sampleLabel.add(img1);

		
		questionLabel = new JLabel("무엇이 더 클까?");
		questionLabel.setFont(new Font("HY엽서M", Font.BOLD, 20));
		questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		questionLabel.setBounds(526, 21, 209, 34);
		panel.add(questionLabel);
		
		JPanel samplepanel = new JPanel();
		samplepanel.setBounds(38, 135, 580, 538);
		panel.add(samplepanel);
		samplepanel.setLayout(null);
		
		JLabel sampleLabel = new JLabel(new1);
		
		sampleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sampleLabel.setBounds(80, 10, 368, 308);
		samplepanel.add(sampleLabel);
		
		JLabel sizeLabel = new JLabel("면적(Km2):");
		sizeLabel.setFont(new Font("함초롬돋움", Font.BOLD, 35));
		sizeLabel.setBounds(39, 414, 511, 51);
		samplepanel.add(sizeLabel);
		
		JLabel lblNewLabel = new JLabel("나라:");
		lblNewLabel.setFont(new Font("함초롬돋움", Font.BOLD, 40));
		lblNewLabel.setBounds(57, 328, 376, 47);
		samplepanel.add(lblNewLabel);
		
		JPanel comparepanel = new JPanel();
		comparepanel.setBounds(633, 135, 633, 538);
		panel.add(comparepanel);
		comparepanel.setLayout(null);
		
		JLabel compareLabel = new JLabel(new2);
		//compareLabel.setSize(new2.getWidth(),new2.getHeight());
		compareLabel.setHorizontalAlignment(SwingConstants.CENTER);
		compareLabel.setBounds(62, 10, 503, 334);
		comparepanel.add(compareLabel);
		
		JButton bigButton = new JButton("더 크다");
		bigButton.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 20));
		bigButton.setBounds(70, 414, 227, 74);
		comparepanel.add(bigButton);
		
		JButton smallButton = new JButton("더 작다");
		smallButton.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 20));
		smallButton.setBounds(340, 414, 227, 74);
		comparepanel.add(smallButton);
		
		JLabel lblNewLabel_1 = new JLabel("나라:");
		lblNewLabel_1.setFont(new Font("함초롬돋움", Font.BOLD, 40));
		lblNewLabel_1.setBounds(110, 337, 481, 47);
		comparepanel.add(lblNewLabel_1);
		

	}


}
class ImagePanel extends JPanel{
	private Image img;
	
	public ImagePanel (Image img) {
		this.img=img;
		setSize(1000,300);
		setLayout(null);
	}
	
	
}
