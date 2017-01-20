package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import model.Model;

import ui.Constants;
import ui.ContextMenu;
import ui.SFileButton;
import view.ShareWindow;
import view.View;


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
               // e.getSource()
            }
        };
    }
	
	public ActionListener shareFileButtonListener(final String username, final int i) {
		return new ActionListener() {
			
            @Override public void actionPerformed (ActionEvent e) {
               // model.shareFile(username, username2, i);
            	
            	createShareWindow(username, i);
            	
            	//ShareWindow shareWindow = new ShareWindow(200 + Constants.padding, 200 + Constants.padding * 8, 600 - Constants.padding * 2,
            		//	Constants.padding * 20, this);
            }
        };
	}
	
	public void createShareWindow(final String username, final int i){
		ShareWindow shareWindow = new ShareWindow(200 + Constants.padding, 200 + Constants.padding * 8, 600 - Constants.padding * 2,
        			Constants.padding * 20, username, i, this);
	}
	
	public ActionListener shareFileListener(final String username, final String username2, final int i){
			return new ActionListener() {
				@Override public void actionPerformed (ActionEvent e) {
            	model.shareFile(username, username2, i);
				}
			};
	}
	
	public void shareFile(final String username, final String username2, final int i){
		if(model.shareFile(username, username2, i)){
			System.out.println("Success");
	//		Toast t = new Toast(view.getX() + Constants.padding, view.getY() + Constants.padding * 8, 800 - Constants.padding * 2,
		//			Constants.padding * 30, Constants.ribbonColor, "Datei geteilt");
		} else {
			System.out.println("No such user");
	//		Toast t = new Toast(view.getX() + Constants.padding, view.getY() + Constants.padding * 8, 800 - Constants.padding * 2,
		//			Constants.padding * 30, Constants.redColor, "Benutzer nicht gefunden");
		}
	}
	
	public void createFileDropHandler(String username, View view){
		view.setTransferHandler(new FileDropHandler(username,model));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		 ContextMenu cm=new ContextMenu(this, e.getSource(),  
				 ((SFileButton) e.getSource()).getUsername(),  ((SFileButton) e.getSource()).getID(), ((SFileButton) e.getSource()).isOwner());
         
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
