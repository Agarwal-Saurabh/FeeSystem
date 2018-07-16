package feesystem;
import java.awt.*;
import java.awt.event.*;
public class AdminSection implements ActionListener
{
	Frame f;
	Button add,view,logout;
	Panel p1,p2,p3;
	public AdminSection()
	{
		f = new Frame("Admin Section");
		f.setSize(400,400);
		f.setVisible(true);
		f.setLayout(new GridLayout(3,1));
		add = new Button("Add Accountant");
		view = new Button("View Accountant");
		logout = new Button("Logout");
		add.addActionListener(this);
		view.addActionListener(this);
		logout.addActionListener(this);
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		p1.setLayout(new FlowLayout());
		p2.setLayout(new FlowLayout());
		p3.setLayout(new FlowLayout());
		p1.add(add);
		p2.add(view);
		p3.add(logout);
		f.add(p1);
		f.add(p2);
		f.add(p3);
	}
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getActionCommand().equals("Logout"))
		{
		 f.dispose();
		}
                if(e.getActionCommand().equals("Add Accountant"))
                {
                    f.dispose();
                    AddAccountant add = new AddAccountant();
                }
                else
                {
                }
          
	}
		public static void main(String st[])
	{
		AdminSection admin = new AdminSection();
	}
}