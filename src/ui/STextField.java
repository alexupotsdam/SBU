package ui;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


@SuppressWarnings("serial")
public class STextField extends JTextField{

	public STextField(String string, final Color color) {
		setText(string);
		
		setForeground(Color.gray);
		setBackground(null);
		setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
		
		getDocument().addDocumentListener(new DocumentListener() {
		    public void removeUpdate(DocumentEvent e) {
		        // TODO Auto-generated method stub
		    }
		    public void insertUpdate(DocumentEvent e) {
		        // TODO Auto-generated method stub  
		    	setForeground(color);
		    }
		    public void changedUpdate(DocumentEvent e) {
		        // TODO Auto-generated method stub
		    }
		});
		
		addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	setText("");
            }
        });	
	}
}
