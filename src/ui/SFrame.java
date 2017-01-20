package ui;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;



public class SFrame extends JFrame{

	
	public SFrame(){
		getContentPane().setLayout(null);
		getContentPane().setBackground(Constants.backgroundColor);
		setUndecorated(true); // eklige 90er Java Look and Feels und Titelleiste
								// loswerden
	}
	
	public void close(final float o){
	            	final ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
	            	exec.scheduleAtFixedRate(new Runnable() {
	            		float opacity=o;
	            	  @Override
	            	  public void run() {
	            		  
	            		  setOpacity(opacity);
	            		  opacity=opacity-0.05f;
	            		  if(opacity<0.001f){
	            			  setVisible(false);
	            			  exec.shutdown();
	            			  dispose();
	            			  System.out.println("done");
	            		  }
	            	  }
	            	}, 0, 20, TimeUnit.MILLISECONDS); 	
	            }
	   
}
