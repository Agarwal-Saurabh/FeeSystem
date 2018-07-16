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
public class AddStudent implements ActionListener {
    	Frame f;
	Label name,course,email,mobile,fee,paid,due,address,city,state,country;
	Button add,back;
	TextField editName,editCourse,editMail,editMobile,editFee,editPaid,editAddress,editCity,editState,editCountry,editDue;
	Panel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12;
	public AddStudent()
	{
		f = new Frame("Add Accountant");
		f.setSize(400,700);
		
		f.setLayout(new GridLayout(12,2));
		add = new Button("Add");
		add.addActionListener(this);
                back = new Button("Back");
		back.addActionListener(this);
		name = new Label("Name : ");
		course = new Label("Course : ");
		email = new Label("E-Mail : ");
		mobile = new Label("Mobile : ");
                fee = new Label("Fee : ");
                paid = new Label("Paid : ");
                due = new Label("Due : ");
                address = new Label("Address : ");
                city = new Label("City : ");
                state = new Label("State : ");
                country = new Label("Country : ");
		editName = new TextField(20);
		editCourse = new TextField(20);
		editMail = new TextField(20);
		editMobile = new TextField(20);
                editFee = new TextField(20);
                editDue = new TextField(20);
                editPaid = new TextField(20);
                editAddress = new TextField(20);
                editCity = new TextField(20);
                editState = new TextField(20);
                editCountry = new TextField(20);
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		p4 = new Panel();
		p5 = new Panel();
		p6 = new Panel();
		p7 = new Panel();
		p8 = new Panel();
		p9 = new Panel();
		p10 = new Panel();
		p11 = new Panel();
		p12 = new Panel();
		p1.setLayout(new FlowLayout());
		p2.setLayout(new FlowLayout());
		p3.setLayout(new FlowLayout());
		p4.setLayout(new FlowLayout());
		p5.setLayout(new FlowLayout());
		p6.setLayout(new FlowLayout());
		p7.setLayout(new FlowLayout());
		p8.setLayout(new FlowLayout());
		p9.setLayout(new FlowLayout());
		p10.setLayout(new FlowLayout());
		p11.setLayout(new FlowLayout());
		p12.setLayout(new FlowLayout());
		p1.add(name);
		p1.add(editName);
		p2.add(course);
		p2.add(editCourse);
		p3.add(email);
		p3.add(editMail);
		p4.add(mobile);
		p4.add(editMobile);
		p5.add(fee);
		p5.add(editFee);
		p6.add(paid);
		p6.add(editPaid);
		p7.add(due);
		p7.add(editDue);
		p8.add(address);
		p8.add(editAddress);
		p9.add(city);
		p9.add(editCity);
		p10.add(state);
		p10.add(editState);
		p11.add(country);
		p11.add(editCountry);
		p12.add(add);
		p12.add(back);
		f.add(p1);
		f.add(p2);
		f.add(p3);
		f.add(p4);
		f.add(p5);
		f.add(p6);
		f.add(p7);
		f.add(p8);
		f.add(p9);
		f.add(p10);
		f.add(p11);
		f.add(p12);
                f.setVisible(true);
        }
	public void actionPerformed(ActionEvent e)
	{
            if(e.getActionCommand().equals("Back"))
            {
                f.dispose();
                AccountantSection student = new AccountantSection();
            }
            
            if(e.getActionCommand().equals("Add"))
            {
                if(editName.getText()!= null && editCourse.getText()!= null && editMail.getText()!= null && editMobile.getText() != null && editFee.getText() != null && editPaid.getText() != null && editDue.getText() != null && editAddress.getText() != null && editCity.getText() != null && editState.getText() != null && editCountry.getText() != null)
                {
                     String url = "jdbc:mysql://localhost:3306/accountant";
                     String uname="root";
                     String pass = "0000";
                     try
                     {
                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                      
                     	Connection conn = DriverManager.getConnection(url,uname,pass);
                       
			Statement stmt = conn.createStatement();
                        int i = stmt.executeUpdate("insert into student_info values (null,'" + editName.getText() + "','" + editCourse.getText() + "','" + editMail.getText() + "'," + Integer.parseInt(editMobile.getText()) + "," + Integer.parseInt(editFee.getText()) + "," + Integer.parseInt(editPaid.getText()) + "," + Integer.parseInt(editDue.getText()) + ",'" + editAddress.getText() + "','" + editCity.getText() + "','" + editState.getText() + "','" + editCountry.getText() + "')");
                        if(i==1)
                        {
                            f.dispose();
                            AccountantSection accn = new AccountantSection();
                        }
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
        
            AddStudent add = new AddStudent();
    }
}
