package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import model.Model;

import ui.Constants;
import ui.SButton;
import ui.SFrame;
import ui.SPasswordField;
import ui.STextField;
import ui.SToast;

@SuppressWarnings("serial")
public class Login extends SFrame {
	
	Model model;

	private int X = 0;
	private int Y = 0;

	int padding = 14;

	int windowWidth = 400;
	int windowHeight = padding * 22;

	int windowX = 100;
	int windowY = 100;

	int frameOffset;

	static JPasswordField d;

	static SButton closeButton, loginButton;

	static JLabel titleText, label1;
	static JPanel topRibbon;

	static STextField usernameField;
	static SPasswordField passwordField;

	private ImageIcon closeImageIcon = new ImageIcon("raw/close.png");

	public Login(final Model model) {

		this.model = model;
		
		setBounds(windowX, windowY, windowWidth, windowHeight);
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
				setLocation(getLocation().x + (e.getX() - X), getLocation().y + (e.getY() - Y));
			}
		});
		
		Action action = new AbstractAction()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		        if (model.loginAction(usernameField.getText(), passwordField.getText()) == true) {
					View view = new View(model, usernameField.getText());
				} else {
					SToast t = new SToast(self().getX() + padding, self().getY() + padding * 8, windowWidth - padding * 2,
							padding * 13, Constants.redColor, "Falsche Nutzerdaten");
				}
		    }
		};

		label1 = new JLabel("Bitte loggen sie sich ein.");
		label1.setForeground(Color.white);
		label1.setFont(new Font("Sans", Font.BOLD, 12));
		label1.setBounds(padding, padding * 5, 450, 36);

		label1.setVerticalAlignment(SwingConstants.NORTH);
		add(label1);

		titleText = new JLabel("Sharedbox Ultimate");
		titleText.setForeground(Color.white);
		titleText.setFont(new Font("Sans", Font.BOLD, 22));
		titleText.setBounds(0, 0, windowWidth, padding * 3);
		titleText.setHorizontalAlignment(SwingConstants.CENTER);
		add(titleText);

		closeButton = new SButton();
		add(closeButton);
		closeButton.setBounds(windowWidth - 40, -42 + padding * 3, 40, 40);
		closeButton.setIcon(closeImageIcon);
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		topRibbon = new JPanel();
		topRibbon.setBackground(Constants.ribbonColor);
		topRibbon.setBounds(0, 0, windowWidth, padding * 7);
		add(topRibbon);

		usernameField = new STextField("Benutzername",Color.darkGray);
		passwordField = new SPasswordField("Passwort");

		add(usernameField);
		usernameField.setBounds(padding, padding * 9, windowWidth - padding * 2, padding * 2);
		usernameField.addActionListener(action);

		add(passwordField);
		passwordField.setBounds(padding, padding * 13, windowWidth - padding * 2, padding * 2);
		passwordField.addActionListener(action);
		
		loginButton = new SButton("login");
		loginButton.setBounds(padding, padding * 17, windowWidth - padding * 2, padding * 4);
		loginButton.setBackground(Constants.ribbonColor);
		loginButton.setOpaque(true);
		loginButton.addActionListener(action);		

		add(loginButton);
		
		setVisible(true);
	}
	
	public Login self(){
		return this;
	}
	
}
