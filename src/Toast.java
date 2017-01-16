import java.awt.Color;
import java.awt.Font;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import ui.Constants;


public class Toast extends JFrame {
	
	float opacity=0.7f;

	public Toast(int x, int y, int xx, int yy, Color color, String text){
		
		setBounds(x, y, xx, yy);
		
		setUndecorated(true);
		
		JLabel	titleText = new JLabel(text);
		titleText.setForeground(Color.white);
		titleText.setFont(new Font("Sans", Font.BOLD, 18));
		titleText.setBounds(0, 0, 200, 20);
		titleText.setHorizontalAlignment(SwingConstants.CENTER);
		titleText.setOpaque(true);
		titleText.setBackground(color);
		
		add(titleText);
		
		setOpacity(opacity);
		setVisible(true);
		
		new java.util.Timer().schedule( 
		        new java.util.TimerTask() {
		            @Override
		            public void run() {
		            	
		            	final ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
		            	exec.scheduleAtFixedRate(new Runnable() {
		            	  @Override
		            	  public void run() {
		            		  setOpacity(opacity);
		            		  opacity=opacity-0.03f;
		            		  if(opacity<0.001f){
		            			  setVisible(false);
		            			  exec.shutdown();
		            			  System.out.println("done");
		            		  }
		            	  }
		            	}, 0, 20, TimeUnit.MILLISECONDS); 	
		            }
		        }, 
		        800 
		);
	}
}
