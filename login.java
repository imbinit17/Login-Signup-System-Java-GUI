import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.io.File ;
import java.io.FileNotFoundException;
import java.util.*;

public class login implements ActionListener 
{
   
    private static String username ;
    private static String password ;
    private static String res = "" ;
    private static JLabel label1 ;
    private static JLabel label2 ;
    private static JTextField usernameField ;
    private static JTextField passField ;
    private static JLabel resLabel ;
    private static JPanel panel ;

    public static void main(String[] args) 
    {
        panel = new JPanel() ;
        JFrame frame = new JFrame("Login Application") ;
        frame.setSize(375,250) ;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel) ;
        panel.setLayout(null) ;
        
        label1 = new JLabel("Username ") ;
        label1.setBounds(50,35,150,25) ;
        panel.add(label1) ;
        
        usernameField = new JTextField() ;
        usernameField.setBounds(160,35,100,25);
        panel.add(usernameField) ;
        
        label2 = new JLabel("Password ");
        label2.setBounds(50,80,150,25);
        panel.add(label2) ;
        
        passField = new JPasswordField() ;
        passField.setBounds(160,80,100,25);
        panel.add(passField) ;
        
        JButton btn = new JButton("Login") ;
        btn.setBounds(130,125,80,25) ;
        btn.addActionListener(new login());
        panel.add(btn) ;
               
        frame.setVisible(true) ;
      
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        username = usernameField.getText() ;
        password = passField.getText() ;
        
        File file = new File("users.txt") ;
        Scanner sc = new Scanner(System.in);
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        String temp ="" ;
        String dbUser = "" ;
        String dbPass ="" ;
        String dbEmail = "" ;
        String dbMobile = "" ;
        String dbName = "" ;
        int RES = 0 ;
        while(sc.hasNextLine())
        {
            temp = sc.nextLine() ;
            dbUser = temp.substring(0,temp.indexOf(' ')) ;
            temp = temp.substring(temp.indexOf(' ')+1) ;
            dbPass = temp.substring(0,temp.indexOf(' ')) ;
            


            if(username.equals(dbUser))
            {
                RES = 1 ;
                if(password.equals(dbPass))
                {
                    RES = 2 ;
                    temp = temp.substring(dbPass.length()+1) ;
                    dbEmail = temp.substring(0,temp.indexOf(' ')) ;
                    temp = temp.substring(dbEmail.length()+1) ;
                    dbMobile = temp.substring(0,temp.indexOf(' ')) ;
                    temp = temp.substring(dbMobile.length()+1);
                    int tempIndex = temp.indexOf('$') ;
                    dbName = temp.substring(tempIndex+1,temp.length()-1) ;
                }
                
            }

            if(RES==2)
            break ;
        }

        if(RES==2)
        {
            res = "Login  Granted" ;
            JFrame dashboardFrame = new JFrame("Dashboard") ;
            dashboardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            dashboardFrame.setSize(250,250);
            JPanel tempPanel = new JPanel() ;
            dashboardFrame.add(tempPanel) ;
            tempPanel.setLayout(null);

            JLabel msgLabel = new JLabel(res) ;
            msgLabel.setBounds(15,0,100,25);
            tempPanel.add(msgLabel) ;

            dbName = "Name  :  " + dbName ;
            dbUser = "Username  :  "+dbUser ;
            dbEmail = "Email ID  :  "+ dbEmail ;
            dbMobile = "Mobile No  : " + dbMobile ;
            
            
            JLabel lbl1 = new JLabel(dbName) ;
            lbl1.setBounds(10,35,150,25) ;
            tempPanel.add(lbl1) ;

            JLabel lbl2 = new JLabel(dbUser) ;
            lbl2.setBounds(10,70,150,25) ;
            tempPanel.add(lbl2) ;

            JLabel lbl3 = new JLabel(dbEmail) ;
            lbl3.setBounds(10,105,250,25) ;
            tempPanel.add(lbl3) ;

            JLabel lbl4 = new JLabel(dbMobile) ;
            lbl4.setBounds(10,140,150,25) ;
            tempPanel.add(lbl4) ;

            dashboardFrame.setVisible(true);
        }

        if(RES==1)
        {
            res = "Invalid  Password !" ;
            JFrame msgFrame = new JFrame("Dialogue Window-Login Application") ;
            msgFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            msgFrame.setSize(450,150);
            JPanel tempPanel = new JPanel() ;
            msgFrame.add(tempPanel) ;

            JLabel msgLabel = new JLabel(res) ;
            msgLabel.setBounds(15,0,100,25);
            tempPanel.add(msgLabel) ;

            msgFrame.setVisible(true);
        }

        else if(RES==0)
        {
            res = "User  Doesn't  Exist" ;
            JFrame msgFrame = new JFrame("Dialogue Window-Login Application") ;
            msgFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            msgFrame.setSize(450,150);
            JPanel tempPanel = new JPanel() ;
            msgFrame.add(tempPanel) ;

            JLabel msgLabel = new JLabel(res) ;
            msgLabel.setBounds(15,0,100,25);
            tempPanel.add(msgLabel) ;

            msgFrame.setVisible(true);
        }
    }

    
    
}