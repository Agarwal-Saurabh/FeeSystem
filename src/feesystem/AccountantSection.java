package feesystem;
import java.awt.*;
import java.awt.event.*;
public class AccountantSection implements ActionListener
{
	Frame f;
	Button add,view,logout,edit;
	Panel p1,p2,p3,p4;
	public AccountantSection()
	{
		f = new Frame("Accountant Section");
		f.setSize(400,400);
		f.setVisible(true);
		f.setLayout(new GridLayout(4,1));
		add = new Button("Add Student");
		view = new Button("View Student");
		logout = new Button("Logout");
		edit = new Button("Edit Student");
		add.addActionListener(this);
		view.addActionListener(this);
		edit.addActionListener(this);
		logout.addActionListener(this);
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		p4 = new Panel();
		p1.setLayout(new FlowLayout());
		p2.setLayout(new FlowLayout());
		p3.setLayout(new FlowLayout());
		p4.setLayout(new FlowLayout());
		p1.add(add);
		p2.add(view);
		p3.add(edit);
		p4.add(logout);
		f.add(p1);
		f.add(p2);
		f.add(p3);
		f.add(p4);
	}
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getActionCommand().equals("Logout"))
		{
		 f.dispose();
		}
                if(e.getActionCommand().equals("Add Student"))
                {
                    f.dispose();
                    AddStudent add = new AddStudent();
                    
                }
                if(e.getActionCommand().equals("View Student"))
                {
                    
                }
                else
                {
                }
          
	}
		public static void main(String st[])
	{
		AccountantSection acc = new AccountantSection();
	}
}