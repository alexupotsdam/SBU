import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.border.Border;

import ui.Constants;


@SuppressWarnings("serial")
public class ContextMenu extends JPopupMenu{

	int windowWidth=Constants.padding*8;
	int windowHeight=Constants.padding*4;
	
	JMenuItem items[]=new JMenuItem[6];
	
	
	
	public ContextMenu(){
		System.out.println("ContextMenu created.");
		items[0]=new JMenuItem("Kopieren");
		items[1]=new JMenuItem("Umbenennen");
		items[2]=new JMenuItem("Teilen");
		items[3]=new JMenuItem("Herunterladen");
		items[4]=new JMenuItem("Verschieben");
		items[5]=new JMenuItem("Löschen");
		//setBounds(60, 60, windowWidth, windowHeight);
		
		//getContentPane().setLayout(null);
		//getContentPane().setBackground(Constants.backgroundColor);
		//setUndecorated(true);
		
		//setBackground(Constants.backgroundColor);
		
		
		
		// this.setBorder(BorderFactory.createMatteBorder(10, 20, 1, 10, Color.GRAY));
		
		//setVisible(true);
		
		for(int i=0; i<items.length; i++){
			
			add(items[i]);
			
		}
		
	}
	
}
