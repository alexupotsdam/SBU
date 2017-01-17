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
	
	int fileID;
	String ficken="b";
	
	JMenuItem items[]=new JMenuItem[6];
	
			
	public ContextMenu(Controller controller, Object object, String username, int fileID){
		//System.out.println("ContextMenu for "+object+" created.");
		
		this.fileID=fileID;
		System.out.println("ID "+fileID);
		
		items[0]=new JMenuItem("Kopieren");
		items[1]=new JMenuItem("Umbenennen");
		items[2]=new JMenuItem("Teilen");
		items[3]=new JMenuItem("Herunterladen");
		items[4]=new JMenuItem("Verschieben");
		items[5]=new JMenuItem("Löschen");
		//setBounds(60, 60, windowWidth, windowHeight);
		
		for(int i=0; i<items.length; i++){
			add(items[i]);
		}
		
		items[2].addActionListener(controller.shareFileListener(username, ficken, fileID));
		
	}
	
}
