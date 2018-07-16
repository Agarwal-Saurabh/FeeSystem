package feesystem;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class AccountantLogin implements ActionListener
{
	Frame f;
	Label name,pass;
	Button login;
	TextField editName,editPass;
	Panel p1,p2,p3;
	public AccountantLogin()
	{
		f = new Frame("Accountant Login");
		f.setSize(400,400);
		f.setLayout(new GridLayout(3,1));
		login = new Button("Login");
		login.addActionListener(this);
		name = new Label("Name : ");
		pass = new Label("Password : ");
		editName = new TextField(20);
		editPass = new TextField(20);
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		p1.setLayout(new FlowLayout());
		p2.setLayout(new FlowLayout());
		p3.setLayout(new FlowLayout());
		p1.add(name);
		p1.add(editName);
		p2.add(pass);
		p2.add(editPass);
		p3.add(login);
		f.add(p1);
		f.add(p2);
		f.add(p3);
		f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
                String password ="";
		
		if(e.getActionCommand().equals("Login"))
		{
		    String url = "jdbc:mysql://localhost:3306/accountant";
                    String uname="root";
                    String pass = "0000";
                        try 
                        {
                        Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection(url,uname,pass);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT password FROM accountant_details where name = '" + editName.getText() + "'");
			while(rs.next())
                        {
                            password = rs.getString("password");
                        }
                        
		        conn.close();
                        }
                        
                        catch (Exception exp) {
			exp.printStackTrace();
                        }
                        
                        if(editPass.getText().equals(password))
                        {
                            f.dispose();
		             AccountantSection acc = new AccountantSection();
                        }
                }
		else
				System.out.println("login failed");
			
	}
		
	public static void main(String st[])
	{
		AccountantLogin accountantLog = new AccountantLogin();
	}
}
