import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import ui.Constants;
import ui.SButton;
import ui.SFileButton;

@SuppressWarnings("serial")
public class View extends JFrame implements java.util.Observer {

	private int X = 0;
	private int Y = 0;

	int padding = 14;
	int windowWidth = 800;
	int windowHeight = padding * 44;

	Controller controller;
	Model model;

	JPanel panel;
	JPanel contentPane;

	static SButton uploadButton, closeButton;

	static JLabel titleText, label1;
	static JPanel topRibbon; // Sharedbox Überschrift Hintergrund

	static SFileButton filesButtons[] = new SFileButton[999]; // TODO
																// vernünftiges
																// Format vllt
																// Liste

	private ImageIcon closeImageIcon = new ImageIcon("raw/close.png");

	String file1 = "mixtape.mp3"; // Datei platzhalter

	public View(Model model) {
		this.model = model;
		controller = new Controller(model, this);

		model.addObserver(this);

		setBounds(60, 60, windowWidth, windowHeight);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0); // Beenden
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

		getContentPane().setLayout(null);
		getContentPane().setBackground(Constants.backgroundColor);
		setUndecorated(true); // eklige 90er Java Look and Feels und Titelleiste
								// loswerden

		closeButton = new SButton();
		add(closeButton);
		closeButton.setBounds(windowWidth - 40, -42 + padding * 3, 40, 40);
		closeButton.setIcon(closeImageIcon);

		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		createGUI();

		panel = new JPanel();
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setBackground(null);
		panel.setBackground(Constants.backgroundColor);
		panel.setLayout(boxlayout);
		panel.setBounds(padding, padding * 8, windowWidth - padding * 3, padding * 30);

		refreshFileList();

		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		scrollPane.setBounds(0, 0, windowWidth - padding * 2, padding * 30);
		scrollPane.setBorder(null);
		// scrollPane.setBackground(Color.blue);

		contentPane = new JPanel(null);
		contentPane.setLayout(null);
		// contentPane.setBackground(Color.green);
		contentPane.setPreferredSize(new Dimension(windowWidth - padding * 2, padding * 30));
		contentPane.add(scrollPane);
		// setContentPane(contentPane);
		contentPane.setBounds(padding, padding * 8, windowWidth - padding * 2, padding * 30);
		getContentPane().add(contentPane);
		// pack();

		setVisible(true);

	}

	public void refreshFileList() {
		panel.removeAll();
	
		String fileList[] = new String[99];
		fileList = model.files();
		
		int i = 0;
		
		for (String item : model.files()) {
			if (item != null) {
				filesButtons[i] = new SFileButton(fileList[i], i);
				panel.add(filesButtons[i]);
				filesButtons[i].setPreferredSize(new Dimension(windowWidth - padding * 4, padding * 2));
				filesButtons[i].setMaximumSize(new Dimension(windowWidth - padding * 4, padding * 2));

				panel.revalidate();

				filesButtons[i].addMouseListener(controller);
				i++;
			}
		}

		panel.repaint();
		System.out.println("View file list refreshed");
		System.out.println("height" + panel.getHeight());

	}

	@Override
	public void update(Observable o, Object arg) {
		refreshFileList();
		System.out.println("View Update observed");
		repaint();
	}

	private void createGUI() {
		// TODO Auto-generated method stub
		label1 = new JLabel("Kann man hier noch was cooles hinschreiben?");
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

		topRibbon = new JPanel();
		topRibbon.setBackground(Constants.ribbonColor);
		topRibbon.setBounds(0, 0, windowWidth, padding * 7);
		add(topRibbon);

		uploadButton = new SButton("Datei Hochladen");
		uploadButton.setBounds(padding, windowHeight - padding * 5, windowWidth - padding * 2, padding * 4);
		uploadButton.setBackground(Constants.ribbonColor);
		uploadButton.setOpaque(true);
		uploadButton.addActionListener(controller.addFileListener());
		add(uploadButton);
	}

}
