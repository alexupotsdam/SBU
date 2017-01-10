import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.SwingConstants;


public class Login  extends JWindow {

	private int X = 0;
	private int Y = 0;
	
	int windowWidth=400;
	int windowHeight=600;
	
	int padding=14;
	int frameOffset;
	
	
	 public final static Color backgroundColor      = new Color(250, 250, 250);
	 public final static Color ribbonColor      	= new Color(0, 230,190);
	
	static JButton	closeButton;
	static JLabel	label1 ;
	static JLabel	titleText ;
	static JPanel topRibbon;
	
	static JTextField usernameField;
	static JPasswordField passwordField;
	
	private ImageIcon closeImageIcon = new ImageIcon("raw/close.png");
	
	public Login() {
		setBounds(60, 60, windowWidth, windowHeight);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0); // An Exit Listener
			}
		});

		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				X = e.getX();
				Y = e.getY();
			}
		});
		
		addMouseMotionListener(new MouseMotionAdapter() {

			public void mouseDragged(MouseEvent e) {
				setLocation(getLocation().x + (e.getX() - X),
						getLocation().y + (e.getY() - Y));
			}
		});
		
		getContentPane().setLayout(null);
		getContentPane().setBackground(backgroundColor);
		
		label1 = new JLabel("Bitte loggen sie sich ein.");
		label1.setForeground(Color.white);
		label1.setFont(new Font("Sans", Font.BOLD, 12));
		//label1.setBackground(Color.gray);
		//label1.setOpaque(true);		
		label1.setBounds(padding, padding*5, 450, 36);
		
		//label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setVerticalAlignment(SwingConstants.NORTH);
		add(label1);
		
		
		titleText = new JLabel("Sharedbox Ultimate");
		titleText.setForeground(Color.white);
		titleText.setFont(new Font("Sans", Font.BOLD, 22));
		//label1.setBackground(Color.gray);
		//label1.setOpaque(true);		
		titleText.setBounds(0, 0, windowWidth, padding*3);
		
		titleText.setHorizontalAlignment(SwingConstants.CENTER);
		//titleText.setVerticalAlignment(SwingConstants.NORTH);
		add(titleText);
		
		
		closeButton=new JButton();
		buttonStuff(closeButton);
		add(closeButton);
		closeButton.setBounds(windowWidth-40, -42+padding*3, 40, 40);
		closeButton.setIcon(closeImageIcon);
		closeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		
		topRibbon=new JPanel();
		topRibbon.setBackground(ribbonColor);
		topRibbon.setBounds(0,0,windowWidth,padding*7);
		add(topRibbon);
	
		
		
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Login();
		
		//Insets insets = this.getInsets();
		//System.out.println(insets.top);
		
		
		
		

	}
	
	public void buttonStuff(JButton b){
		b.setBorderPainted(false); 
		b.setContentAreaFilled(false); 
		b.setFocusPainted(false); 
		b.setOpaque(false);
	}

}
