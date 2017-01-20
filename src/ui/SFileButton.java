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
	
	String text;
	String username;
	
	boolean ownsFile;
	
	public int fileID;
	

	public SFileButton(String string, String username, int fileID, boolean ownsFile) {
		// TODO Auto-generated constructor stub
		
		this.username=username;
		this.ownsFile=ownsFile;
		this.fileID=fileID;
		//System.out.println("created "+fileID);
		
		if(string!=null){
 
		if(string.endsWith("png")||string.endsWith("jpg")||string.endsWith("jpeg")||string.endsWith("psd")){
			 resource = getClass().getClassLoader().getResource("raw/pic.png");  
		}
		else if(string.endsWith("doc")||string.endsWith("docx")){
			resource = getClass().getClassLoader().getResource("raw/doc.png");  
		}
		else if(string.endsWith("mp3")||string.endsWith("wav")){
			resource = getClass().getClassLoader().getResource("raw/note.png");  
		}
		else if(string.endsWith("xls")||string.endsWith("csv")){
			resource = getClass().getClassLoader().getResource("raw/xls.png");  
		}
		else {
			resource = getClass().getClassLoader().getResource("raw/other.png");  
		}
		
		 try {
	        	icon = ImageIO.read(resource);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
		text=string;
		}
		
		setup();
		
		
	}

	public SFileButton() {
		// TODO Auto-generated constructor stub
		setup();
	}

	public void setup(){
		
		setBorderPainted(false); 
		setContentAreaFilled(false); 
		setFocusPainted(false); 
		setOpaque(false);
		
		setForeground(Color.black);
		setBackground(null);
		//setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.GRAY));
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@Override
	   protected void paintComponent(Graphics g) {
		
	      Graphics2D g2 = (Graphics2D) g.create();
	      Graphics2D g3 = (Graphics2D) g.create();
	 
	      g3.setPaint( new Color(250, 250, 250));       
	      g3.fillRect(0, 0, getWidth(), getHeight());  
	     
	      g2.setPaint( new Color(0, 0, 0));
	      g2.setRenderingHint(
	    	        RenderingHints.KEY_TEXT_ANTIALIASING,
	    	        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	      
	      g2.setPaint( new Color(100, 100, 100));
	      g2.drawString(text, 30, 18);
	      g2.dispose();

	     g.drawImage(icon, 2, 2, 22, 22, this);
	 	    
	   }

	public int getID(){
		return fileID;
	}
	
	public String getUsername(){
		return username;
	}
	
	public boolean isOwner(){
		return ownsFile;
	}
}
