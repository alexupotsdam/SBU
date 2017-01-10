package trash;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

class Login extends JFrame implements ActionListener{
    Connection con=null;
    Statement st=null;
    ResultSet rs=null; 
    JLabel l1,l2;
    JButton b1,b2;
    JTextField t1;
    JPasswordField pf;
    Login(){    
        Toolkit tk=Toolkit.getDefaultToolkit();
    Image img=tk.getImage("C:/Image.jpg");
    setIconImage(img);
        Icon icon1=new ImageIcon("C:/Image.jpg");
        JLabel i=new JLabel(icon1);
    JPanel p;
    p=(JPanel)getContentPane();
    p.add(i);
        this.getContentPane().setBackground(new Color(243,67,226));
        setVisible(true);
        setLocation(225,50);
        //setLocationRelativeTo(null);
        setSize(900,600); 
        setTitle("Login");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        l1=new JLabel("UserName");   
        l2=new JLabel("Password");
        t1=new JTextField(10);
        
        t1.setBackground(Color.red);
        
        AbstractAction action = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() instanceof JButton){
            JButton button = (JButton) e.getSource();
            button.doClick();        
            } else if(e.getSource() instanceof JComponent){
                JComponent component = (JComponent) e.getSource();
                component.transferFocus();
            }
        }
        };

        t1.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "TransferFocus");
        t1.getActionMap().put("TransferFocus", action);

        pf=new JPasswordField(10);
        pf.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "TransferFocus");
        pf.getActionMap().put("TransferFocus", action);
        ImageIcon ic=new ImageIcon("C:/key.gif");
        b1=new JButton("Login",ic);
        b1.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "TransferFocus");
        b1.getActionMap().put("TransferFocus", action);
        ImageIcon ic1=new ImageIcon("C:/cancel.jpg");
        b2=new JButton("Exit",ic1);          
        b2.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "TransferFocus");
        b2.getActionMap().put("TransferFocus", action);
        b1.addActionListener(this);
        b2.addActionListener(this);
        JPanel p1=new JPanel();   
        JPanel p2=new JPanel();      
        JPanel p3=new JPanel();  
        JPanel p4=new JPanel();   
        p1.setBackground(new Color(243,67,226));
        p2.setBackground(new Color(243,67,226));
        p3.setBackground(new Color(243,67,226)); 
        p4.setBackground(new Color(243,67,226));
        p1.add(l1);
        p1.add(t1);
        p2.add(l2);
        p2.add(pf);
        p3.add(b1);
        p3.add(b2);
        p4.setLayout(new GridLayout(3,1));
        p4.add(p1);    
        p4.add(p2);
        p4.add(p3);
        add(p4);
        t1.requestFocus();
        //b1.requestFocus();
        //b1.requestFocusInWindow();
        validate();

    }  //eof cons.
    public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==b1){
            try {
                try{
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                    String url=null,url1=null,userID=null,password=null;
                    String dbFileName=null;
                    String dbFileName1=null;
                    String sql=null;

                    dbFileName = "C:/db.accdb";

                    url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};"+
                            "DBQ="+dbFileName+";";
                    con=DriverManager.getConnection(url);//,"system","manager"
                    st=(Statement) con.createStatement();
                }catch(Exception e){
                    System.out.println(e);
                    dispose();
                }
                if(t1.getText().trim().length()==0){
                    JOptionPane.showMessageDialog(this,"Enter User Name");
                    return;
                }
                if(pf.getText().trim().length()==0){
                    JOptionPane.showMessageDialog(this,"Enter Password");
                    return;
                }



                ResultSet rs=((java.sql.Statement) st).executeQuery("select password from LOGIN1 where uname='"+t1.getText().trim()+"'"); 

                if(rs.next()){
                    if(rs.getString(1).equals(pf.getText())){
                        String smess="WEL-COME ";
                        String ss="Congratulations......";
                        int res=JOptionPane.INFORMATION_MESSAGE;
                        JOptionPane.showMessageDialog((Component) null,smess,ss,res);  
                        JFrame frm=new JFrame("Title");
                      //  className b=new className(frm);
                        frm.setSize(800,500);
                        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frm.setResizable(false);
                        frm.setLocationRelativeTo(null);
                        dispose();
                        frm.show();
                    }else{
                        JOptionPane.showMessageDialog(this,"Invalid Password");
                    }

                }else{
                    JOptionPane.showMessageDialog(this,"Invalid User name");
                }

            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            }if(ae.getSource()==b2){
                dispose();
            }
    }
    public static void main(String args[]){
        new Login();
    }

}