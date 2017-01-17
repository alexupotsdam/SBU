import javax.swing.JFrame;

import ui.Constants;


public class SFrame extends JFrame{

	public SFrame(){
		getContentPane().setLayout(null);
		getContentPane().setBackground(Constants.backgroundColor);
		setUndecorated(true); // eklige 90er Java Look and Feels und Titelleiste
								// loswerden
	}
	
}
