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
import ui.SToast;
import view.ShareWindow;
import view.View;


public class Controller  implements ActionListener, MouseListener{

	Model model;
	View view;
	
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	
	public ActionListener shareFileButtonListener(final String username, final String fileName) {
		return new ActionListener() {
			
            @Override public void actionPerformed (ActionEvent e) {
            	createShareWindow(username, fileName);
            }
        };
	}
	
	public void createShareWindow(final String username, final String fileName){
		ShareWindow shareWindow = new ShareWindow(200 + Constants.padding, 
				200 + Constants.padding * 8, 600 - Constants.padding * 2,
        			Constants.padding * 20, username, fileName, this);
	}
	
	public ActionListener shareFileListener(final String username, final String username2, final String fileName){
			return new ActionListener() {
				@Override public void actionPerformed (ActionEvent e) {
					model.shareFile(username, username2, fileName);
				}
			};
	}
	
	public void shareFile(final String username, final String username2, final String fileName){
		String message;
		if(username.equals(username2)) message = "Eigener Account";
		else message = "Benutzer nicht gefunden";
		
		if(model.shareFile(username, username2, fileName)){
		} else {
			SToast t = new SToast(view.getX() + Constants.padding, view.getY() + Constants.padding * 8,
					800 - Constants.padding * 2, Constants.padding * 30, Constants.redColor,
					message);
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
		
		 ContextMenu cm=new ContextMenu(this, e.getSource(), ((SFileButton) e.getSource()).getUsername(),
			 ((SFileButton) e.getSource()).getFileName(), ((SFileButton) e.getSource()).isOwner());
		 
		 cm.show((Component) e.getSource(), e.getX(), e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {		
	}

	@Override
	public void mouseExited(MouseEvent e) {	
	}
	
}
