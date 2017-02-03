package ui;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPasswordField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class SPasswordField extends JPasswordField{

	private static final long serialVersionUID = 5898473840091837323L;

	public SPasswordField(String string) {
		super(string);
		
		setForeground(Color.gray);
		setBackground(null);
		setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
		
		getDocument().addDocumentListener(new DocumentListener() {
		    public void removeUpdate(DocumentEvent e) {
		        // TODO Auto-generated method stub
		    }
		    public void insertUpdate(DocumentEvent e) {
		    	setForeground(Color.darkGray);
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
