import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import ui.Constants;


@SuppressWarnings("serial")
public class ContextMenu extends JPopupMenu{

	int windowWidth=Constants.padding*8;
	int windowHeight=Constants.padding*4;
	
	JMenuItem items[]=new JMenuItem[6];
	
	
	
	public ContextMenu(){
		System.out.println("ContextMenu created.");
		items[0]=new JMenuItem("Kopieren");
		items[1]=new JMenuItem("Kopieren");
		items[2]=new JMenuItem("Kopieren");
		items[3]=new JMenuItem("Kopieren");
		items[4]=new JMenuItem("Kopieren");
		items[5]=new JMenuItem("Kopieren");
		//setBounds(60, 60, windowWidth, windowHeight);
		
		//getContentPane().setLayout(null);
		//getContentPane().setBackground(Constants.backgroundColor);
		//setUndecorated(true);
		
		//setVisible(true);
		
		for(int i=0; i<items.length; i++){
			
			add(items[i]);
			
		}
		
	}
	
}
