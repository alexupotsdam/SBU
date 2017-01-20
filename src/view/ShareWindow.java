package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controller.Controller;

import ui.Constants;
import ui.SButton;
import ui.SFrame;
import ui.STextField;

@SuppressWarnings("serial")
public class ShareWindow extends SFrame {

	public ShareWindow(int x, int y, int xx, int yy, final String username, final int i, final Controller controller) {
		setBounds(x, y, xx, yy);

		getContentPane().setBackground(Constants.ribbonColor);

		JLabel label1 = new JLabel("Mit wem soll die Datei geteilt werden?");
		label1.setForeground(Color.white);
		label1.setFont(new Font("Sans", Font.BOLD, 12));
		label1.setBounds(Constants.padding, Constants.padding * 5, 450, 36);
		label1.setVerticalAlignment(SwingConstants.NORTH);
		add(label1);

		final STextField usernameField = new STextField("Name", Color.white);
		usernameField.setBorder((BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE)));
		usernameField.setForeground(Color.white);
		usernameField.setCaretColor(Color.WHITE);

		add(usernameField);
		usernameField.setBounds(Constants.padding, Constants.padding * 9, xx - Constants.padding * 2,
				Constants.padding * 2);

		SButton shareButton = new SButton("Datei teilen");
		shareButton.setBounds(Constants.padding, yy - Constants.padding * 5, xx - Constants.padding * 2,
				Constants.padding * 4);
		shareButton.setBackground(Constants.ribbonColor);
		shareButton.setOpaque(true);
		// shareButton.addActionListener(controller.addFileListener(username,
		// "ficken.mp3"));
		add(shareButton);

		// shareButton.setBackground(Constants.backgroundColor);
		shareButton.setForeground(Color.white);

		shareButton.setBorder((BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE)));
		shareButton.setBorderPainted(true);
		
		shareButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.shareFile(username, usernameField.getText(), i);
				close(1.0f);
			}
		});

		setVisible(true);

	}
	
	public ShareWindow self(){
		return this;
		
	}
	
	
}
