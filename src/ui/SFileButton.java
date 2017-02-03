package ui;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class SFileButton extends JButton{

	BufferedImage icon;
	URL resource;
	
	String fileName;
	String username;
	
	boolean ownsFile;
	public int fileID;

	public SFileButton(String fileName, String username, int fileID, boolean ownsFile) {
		
		this.username = username;
		this.ownsFile = ownsFile;
		this.fileID = fileID;
		
		this.fileName=fileName;

		if (fileName != null) {

			if (fileName.endsWith("png") || fileName.endsWith("jpg") || fileName.endsWith("jpeg") || fileName.endsWith("psd")) {
				resource = getClass().getClassLoader().getResource("raw/pic.png");
			} else if (fileName.endsWith("doc") || fileName.endsWith("docx")) {
				resource = getClass().getClassLoader().getResource("raw/doc.png");
			} else if (fileName.endsWith("mp3") || fileName.endsWith("wav")) {
				resource = getClass().getClassLoader().getResource("raw/note.png");
			} else if (fileName.endsWith("xls") || fileName.endsWith("csv")) {
				resource = getClass().getClassLoader().getResource("raw/xls.png");
			} else {
				resource = getClass().getClassLoader().getResource("raw/other.png");  
			}
		
			try {
		    	icon = ImageIO.read(resource);
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
		
		setup();
	}

	public SFileButton() {
		setup();
	}

	public void setup(){
		
		setBorderPainted(false); 
		setContentAreaFilled(false); 
		setFocusPainted(false); 
		setOpaque(false);
		
		setForeground(Color.black);
		setBackground(null);
		
	}
	
	@Override
	   protected void paintComponent(Graphics g) {
		
	      Graphics2D g2 = (Graphics2D) g.create();
	      Graphics2D g3 = (Graphics2D) g.create();
	 
	      g3.setPaint(new Color(250, 250, 250));       
	      g3.fillRect(0, 0, getWidth(), getHeight());  
	     
	      g2.setPaint(new Color(0, 0, 0));
	      g2.setRenderingHint(
	    	        RenderingHints.KEY_TEXT_ANTIALIASING,
	    	        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	      
	      g2.setPaint( new Color(100, 100, 100));
	      g2.drawString(fileName, 30, 18);
	      g2.dispose();

	      g.drawImage(icon, 2, 2, 22, 22, this);
	 	    
	   }

	public int getID(){
		return fileID;
	}
	
	public String getFileName(){
		return fileName;
	}
	
	public String getUsername(){
		return username;
	}
	
	public boolean isOwner(){
		return ownsFile;
	}
}
