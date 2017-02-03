package ui;
import java.awt.Color;

import javax.swing.JButton;


public class SButton extends JButton{

	private static final long serialVersionUID = 5064648328217226105L;

	public SButton(String string) {
		setText(string);
		setup();
	}

	public SButton() {
		setup();
	}

	public void setup(){
		setBorderPainted(false); 
		setContentAreaFilled(false); 
		setFocusPainted(false); 
		setOpaque(false);
		setForeground(Color.white);
	}

	public static void main(String[] args) {
	}
}
