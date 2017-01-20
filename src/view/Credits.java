package view;

import javax.swing.JLabel;

import ui.Constants;
import ui.SFrame;

@SuppressWarnings("serial")
public class Credits extends SFrame{

	public Credits(int x, int y){
		setBounds(x, y, 400, 200);
		
		JLabel l =new JLabel("(TM) (C) (R) current year und so");
		l.setForeground(Constants.ribbonColor);
		l.setBounds(Constants.padding, Constants.padding, 400-Constants.padding*2, 50);
		add(l);
		
		setVisible(true);
	}
	
}
