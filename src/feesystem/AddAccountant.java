/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feesystem;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 *
 * @author Saurabh
 */
public class AddAccountant implements ActionListener {
    	Frame f;
	Label name,pass,email,mobile,status;
	Button add,back;
	TextField editName,editPass,editMail,editMobile;
	Panel p1,p2,p3,p4,p5,p6;
	public AddAccountant()
	{
		f = new Frame("Add Accountant");
		f.setSize(400,400);
		f.setLayout(new GridLayout(6,1));
		add = new Button("Add");
		add.addActionListener(this);
                back = new Button("Back");
		back.addActionListener(this);
		name = new Label("Name : ");
		pass = new Label("Password : ");
		email = new Label("E-Mail : ");
		mobile = new Label("Mobile : ");
		status = new Label("Accountant added");
		editName = new TextField(30);
		editPass = new TextField(30);
		editMail = new TextField(30);
		editMobile = new TextField(30);
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		p4 = new Panel();
		p5 = new Panel();
		p6 = new Panel();
		p1.setLayout(new FlowLayout());
		p2.setLayout(new FlowLayout());
		p3.setLayout(new FlowLayout());
		p4.setLayout(new FlowLayout());
		p5.setLayout(new FlowLayout());
		p6.setLayout(new FlowLayout());
		p1.add(name);
		p1.add(editName);
		p2.add(pass);
		p2.add(editPass);
		p3.add(email);
		p3.add(editMail);
		p4.add(mobile);
		p4.add(editMobile);
		p5.add(add);
		p5.add(back);
                p6.add(status);
		f.add(p1);
		f.add(p2);
		f.add(p3);
		f.add(p4);
		f.add(p5);
                f.add(p6);
                p6.setVisible(false);
		f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
            if(e.getActionCommand().equals("Back"))
            {
                f.dispose();
                AdminSection admin = new AdminSection();
            }
            
            if(e.getActionCommand().equals("Add"))
            {
                if(editName.getText()!= null && editPass.getText()!= null && editMail.getText()!= null && editMobile.getText() != null)
                {
                     String url = "jdbc:mysql://localhost:3306/accountant";
                     String uname="root";
                     String pass = "0000";
                     try
                     {
                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                     	Connection conn = DriverManager.getConnection(url,uname,pass);
                       
			Statement stmt = conn.createStatement();
                        int i = stmt.executeUpdate("insert into accountant_details values (null,'" + editName.getText() + "','" + editPass.getText() + "','" + editMail.getText() + "'," + Integer.parseInt(editMobile.getText()) + ")");
                        if(i==1)
                            p6.setVisible(true);
                        else
                            System.out.println("problem");
                        conn.close();
                        stmt.close();
                     } 
                     catch (Exception a) 
                       {
			a.printStackTrace();
		       }
                }  
            }
            
        }
        public static void main(String[] args) {
        
            AddAccountant add = new AddAccountant();
    }
}
