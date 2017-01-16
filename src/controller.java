import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;

import ui.Constants;
import ui.SFileButton;


public class Controller  implements ActionListener, MouseListener{

	Model model;
	View view;
	
	public Controller(Model model, View view) {
		// TODO Auto-generated constructor stub
		System.out.println("Controller erstellt.");
		this.model=model;
		this.view=view;
		
	}
	
	public ActionListener getDeleteListener () {
        return new ActionListener() {
            @Override public void actionPerformed (ActionEvent e) {
                model.deleteSomething();
            }
        };
    }
	
	public ActionListener addFileListener (final String username, final String filename) {
        return new ActionListener() {
            @Override public void actionPerformed (ActionEvent e) {
                model.addFile(username, filename);
            }
        };
    }
	
	public ActionListener shareFileListener(final int i) {
		return new ActionListener() {
            @Override public void actionPerformed (ActionEvent e) {
                model.shareFile(i);
            }
        };
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		 ContextMenu cm=new ContextMenu(this, e.getSource(), ((SFileButton) e.getSource()).getID());
         cm.show((Component) e.getSource(), e.getX(), e.getY());
         
         
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
