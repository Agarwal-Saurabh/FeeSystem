package feesystem;
import java.awt.*;
import java.awt.event.*;
public class AdminLogin implements ActionListener
{
	Frame f;
	Label name,pass;
	Button login;
	TextField editName,editPass;
	Panel p1,p2,p3;
	public AdminLogin()
	{
		f = new Frame("Admin Login");
		f.setSize(400,400);
		f.setVisible(true);
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
	}
	public void actionPerformed(ActionEvent e)
	{
		
		String n = editName.getText();
		String p = editPass.getText();
		
		if(e.getActionCommand().equals("Login"))
		{
			
			if(n.equals("admin") && p.equals("admin"))
			{
				f.dispose();
				AdminSection adminSec = new AdminSection();
			}
		}
		else
				System.out.println("login failed");
			
	}
		
	public static void main(String st[])
	{
		AdminLogin adminLog = new AdminLogin();
	}
}
