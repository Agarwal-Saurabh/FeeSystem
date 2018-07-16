package feesystem;

//
import java.awt.*;
import java.awt.event.*;
public class FeeReport implements ActionListener
{
	Frame f;
	Label l;
	Button adminLog, accLog;
	Panel p1,p2,p3;
	public FeeReport()
	{
		f = new Frame();
		f.setSize(400,400);
		f.setVisible(true);
		f.setLayout(new GridLayout(3,1));
		adminLog = new Button("Admin Login");
		accLog = new Button("Accountant Login");
		adminLog.addActionListener(this);
		accLog.addActionListener(this);
		l = new Label("FEE REPORT");
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		p1.setLayout(new FlowLayout());
		p2.setLayout(new FlowLayout());
		p3.setLayout(new FlowLayout());
		p1.add(l);
		p2.add(adminLog);
		p3.add(accLog);
		f.add(p1);
		f.add(p2);
		f.add(p3);
	}
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getActionCommand().equals("Admin Login"))
		{
			f.dispose();
			AdminLogin adminLogin = new AdminLogin();
		}
		else
		{	
			f.dispose();
			AccountantLogin accLogin = new AccountantLogin();
		}
	}
	public static void main(String s[])
	{
		FeeReport fee = new FeeReport();
	}
}