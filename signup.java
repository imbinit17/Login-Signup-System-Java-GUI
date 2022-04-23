import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.io.FileNotFoundException;

import java.io.File ;
import java.io.FileWriter ;
import java.io.IOException;
import java.util.*;

//UDM imports here
//import checkUsername ;

public class signup implements ActionListener{



    private static String res = "" ;

    private static JLabel headingLabel ;
    private static JLabel label1 ;
    private static JLabel label2 ;
    private static JLabel label3 ;
    private static JLabel label4 ;
    private static JLabel label5 ;
    private static JLabel label6 ;


    private static JTextField nameField ;
    private static JTextField mobileField ;
    private static JTextField emailField ;
    private static JTextField usernameField ;
    private static JTextField passField ;
    private static JTextField passField2 ;
    private static JLabel resLabel ;

    private static String name = "" ;
    private static String username = "" ;
    private static String email = "" ;
    private static String mobile = "" ;
    private static String pass1 = "" ;
    private static String pass2 = "" ;


    static void execute()
    {
        JPanel panel = new JPanel() ;
        JFrame frame = new JFrame() ;
        frame.add(panel) ;
        frame.setSize(350,350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null) ;
        
        headingLabel = new JLabel("Sign-Up Form") ;
        headingLabel.setBounds(130,15,150,25);
        panel.add(headingLabel) ;

        label1 = new JLabel("Full Name ") ;
        label1.setBounds(50,50,150,25);
        panel.add(label1) ;

        nameField = new JTextField() ;
        nameField.setBounds(190,50,120,25);
        panel.add(nameField) ;

        label2 = new JLabel("Username") ;
        label2.setBounds(50,80,150,25);
        panel.add(label2) ;

        usernameField = new JTextField() ;
        usernameField.setBounds(190,80,120,25);
        panel.add(usernameField) ;
        
        label3 = new JLabel("Email ID") ;
        label3.setBounds(50,110,150,25);
        panel.add(label3) ;

        emailField = new JTextField() ;
        emailField.setBounds(190,110,120,25);
        panel.add(emailField) ;

        label4 = new JLabel("Mobile Number") ;
        label4.setBounds(50,140,150,25);
        panel.add(label4) ;

        mobileField = new JTextField() ;
        mobileField.setBounds(190,140,120,25);
        panel.add(mobileField) ;

        label5 = new JLabel("Password") ;
        label5.setBounds(50,170,150,25);
        panel.add(label5) ;

        passField = new JPasswordField() ;
        passField.setBounds(190,170,120,25);
        panel.add(passField) ;

        label6 = new JLabel("Confirm Password") ;
        label6.setBounds(50,200,150,25);
        panel.add(label6) ;

        passField2 = new JPasswordField() ;
        passField2.setBounds(190,200,120,25);
        panel.add(passField2) ;
     
        

        JButton btn = new JButton("Register") ;
        btn.setBounds(130,230,120,25) ;
        btn.addActionListener(new signup());
        panel.add(btn) ;
        
        resLabel = new JLabel(res) ;
        resLabel.setBounds(100, 260, 150,25 );
        panel.add(resLabel) ;
        
        
        
        
        
        frame.setVisible(true);
    }
    public static void main(String args[]) {
        //signup obj = new signup() ;
        execute();
    }


    @Override
    public void actionPerformed(ActionEvent e) 
    {    
        name = nameField.getText() ;
        name = "$"+name+"$" ;
        username = usernameField.getText() ;
        email = emailField.getText() ;
        mobile = mobileField.getText() ;
        pass1 = passField.getText() ;
        pass2 = passField2.getText() ;
     
        String msgRes = "Passwords do not match" ;

        File file = new File("users.txt") ;
        Scanner sc = new Scanner(System.in);
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        if(pass1.equals(pass2))
        msgRes = "" ;

        String dbUser = "" ;
        String temp ="" ;
        int RES = 0 ;
        while(sc.hasNextLine())
        {
            temp = sc.nextLine() ;
            dbUser = temp.substring(0,temp.indexOf(' ')) ;


            if(username.equals(dbUser))
            RES = 1 ;
        }

        
        if(RES==1)
        {
        JFrame msgFrame = new JFrame("Dialogue Window-Login Application") ;
        msgFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        msgFrame.setSize(450,150);
        JPanel tempPanel = new JPanel() ;
        msgFrame.add(tempPanel) ;

        JLabel msgLabel = new JLabel(msgRes) ;
        msgLabel.setBounds(15,0,100,25);
        tempPanel.add(msgLabel) ;

        msgFrame.setVisible(true);
        }

        else
        {
            File file2 = new File("users.txt") ;
        Scanner kb = new Scanner(System.in);
        try {
            kb = new Scanner(file2);
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        }

        String content = "" ;
        while(kb.hasNextLine())
        {
            content += kb.nextLine() + "\n" ;
        }

        content += username + " " + pass1 + " " + email + " " + mobile +" "+name+"\n" ;

        try (FileWriter wr = new FileWriter("users.txt")) {
            try {
                wr.write(content) ;
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                wr.close() ;
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
	    JFrame msgFrame = new JFrame("Dialogue Window-Login Application") ;
        msgFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        msgFrame.setSize(450,150);
        JPanel tempPanel = new JPanel() ;
        msgFrame.add(tempPanel) ;

        JLabel msgLabel = new JLabel("User  Registered  !  Please  Login.....") ;
        msgLabel.setBounds(15,0,100,25);
        tempPanel.add(msgLabel) ;

        msgFrame.setVisible(true);
        


        }

    


       
        
    }

    



    

}
