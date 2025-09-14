package UniManSya;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Project extends JFrame implements ActionListener{
	JButton exit;
	public Project() {
		setSize(1390, 680);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1390, 680,  Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		add(image);

		JMenuBar adBar = new JMenuBar();
		//Add info
		JMenu newInfo =new JMenu("New Information");
		newInfo.setForeground(Color.blue);
		newInfo.setFont(new Font("Tahoma",Font.BOLD,  17));
		JMenuItem Finfo =new JMenuItem("Add Faculty");
		Finfo.setBackground(Color.white);
		Finfo.addActionListener(this);
		newInfo.add(Finfo);
		JMenuItem Sinfo =new JMenuItem("Add Student");
		Sinfo.setBackground(Color.white);
		Sinfo.addActionListener(this);
		newInfo.add(Sinfo);
		
		//show info
		JMenu showInfo =new JMenu("View Information ");
		showInfo.setForeground(Color.red);
		showInfo.setFont(new Font("Tahoma",Font.BOLD,  17));
		JMenuItem vFinfo =new JMenuItem("Faculty Imformation");
		vFinfo.setBackground(Color.white);
		vFinfo.addActionListener(this);
		showInfo.add(vFinfo);
		JMenuItem vSinfo =new JMenuItem("Student Imformation");
		vSinfo.setBackground(Color.white);
		vSinfo.addActionListener(this);
		showInfo.add(vSinfo);
		
		//Leave apply
		JMenu leave =new JMenu("leave Apply");
		leave.setForeground(Color.blue);
		leave.setFont(new Font("Tahoma",Font.BOLD,  17));
		JMenuItem fleave =new JMenuItem("Faculty Application");
		fleave.setBackground(Color.white);
		fleave.addActionListener(this);
		leave.add(fleave);
		JMenuItem sleave =new JMenuItem("Student Application");
		sleave.setBackground(Color.white);
		sleave.addActionListener(this); 
		leave.add(sleave);

		//show Leave
		JMenu showleave =new JMenu("leave Details ");
		showleave.setForeground(Color.red);
		showleave.setFont(new Font("Tahoma",Font.BOLD,  17));
		JMenuItem vFleave =new JMenuItem("Faculty leave Details");
		vFleave.setBackground(Color.white);
		vFleave.addActionListener(this);
		showleave.add(vFleave);
		JMenuItem vSleave =new JMenuItem("Student leave Details");
		vSleave.setBackground(Color.white);
		vSleave.addActionListener(this);
		showleave.add(vSleave);
		
		JMenu exam =new JMenu("Examination ");
		exam.setForeground(Color.black);
		exam.setFont(new Font("Tahoma",Font.BOLD,  17));
		JMenuItem umarks =new JMenuItem("Uplode Marks");
		umarks.setBackground(Color.white);
		umarks.addActionListener(this);
		exam.add(umarks);
		JMenuItem vmarks =new JMenuItem("View Reasult");
		vmarks.setBackground(Color.white);
		vmarks.addActionListener(this);
		exam.add(vmarks);
		
		JMenu fees =new JMenu("Fees Detail ");
		fees.setForeground(Color.blue);
		fees.setFont(new Font("Tahoma",Font.BOLD,  17));
		JMenuItem fstruct =new JMenuItem("Fees Structure");
		fstruct.setBackground(Color.white);
		fees.add(fstruct);
		JMenuItem fform =new JMenuItem("Fee Form");
		fform.setBackground(Color.white);
		fees.add(fform);
		
		JMenu udetails =new JMenu("Update Details ");
		udetails.setForeground(Color.red);
		udetails.setFont(new Font("Tahoma",Font.BOLD,  17));
		JMenuItem ufac =new JMenuItem("Faculty details");
		ufac.setBackground(Color.white);
		ufac.addActionListener(this);
		udetails.add(ufac);
		JMenuItem ustu =new JMenuItem("Student details");
		ustu.setBackground(Color.white);
		ustu.addActionListener(this);
		udetails.add(ustu);
		
		JMenu utility =new JMenu("Utilities ");
		utility.setForeground(Color.black);
		utility.setFont(new Font("Tahoma",Font.BOLD,  17));
		JMenuItem notepad =new JMenuItem("Notepad");
		notepad.setBackground(Color.white);
		notepad.addActionListener(this);
		utility.add(notepad);
		JMenuItem calci =new JMenuItem("Calculator");
		calci.setBackground(Color.white);
		calci.addActionListener(this);
		utility.add(calci);
		
		JMenu empty =new JMenu("Add Admin");
		empty.setForeground(Color.blue);
		empty.setFont(new Font("Tahoma",Font.BOLD,  17));
		JMenuItem admin =new JMenuItem("Add");
		admin.setBackground(Color.white);
		admin.addActionListener(this);
		empty.add(admin);
		
		JMenu exit =new JMenu("Ecit");
		exit.setForeground(Color.green);
		exit.setFont(new Font("Tahoma",Font.BOLD,  17));
		JMenuItem out =new JMenuItem("Exit now");
		out.setBackground(Color.white);
		out.addActionListener(this);
		out.addActionListener(this);
		exit.add(out);
		
		adBar.add(newInfo);	
		adBar.add(showInfo);
		adBar.add(leave);
		adBar.add(showleave);	
		adBar.add(exam);
		adBar.add(fees);
		adBar.add(udetails);
		adBar.add(utility);
		adBar.add(empty);
		adBar.add(exit);



		setJMenuBar(adBar);
		setVisible(true);
	}
	public static void main(String[] args)  {
		new Project();
		
	}
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		String msg =e.getActionCommand();
		//New & view  Information
		if (msg.equals("Add Faculty")){
			new AddFaculty();
			System.out.println("in faculty");
		}if (msg.equals("Add Student")) {
			new AddStudentt();
			System.out.println("in student");
		}if (msg.equals("Faculty Imformation")){
			new FacultyDetails();
			System.out.println("in faculty");
		}if (msg.equals("Student Imformation")) {
			new StudentDetails();
			System.out.println("in student");
		}
		
		//Update  Information
		if (msg.equals("Faculty details")){
			new UpdateFaculty();
			System.out.println("in update faculty");
		}if (msg.equals("Student details")) {
			new UpdateStudent();
			System.out.println("in update student");
		}
		
		//leave apply and leave details
		if (msg.equals("Student Application")){
			new StudentLeave();
			System.out.println("Student leave application");
		}if (msg.equals("Faculty Application")) {
			new FacultyLeave();
			System.out.println("faculty leave application");
		}if (msg.equals ("Faculty leave Details")){
			new LeaveDetailsFaculty();
			System.out.println("faculty leave details");
		}if (msg.equals("Student leave Details")) {
			new LeaveDetailsStudent();
			System.out.println("student leave details");
		}
		//add admin
		if (msg.equals("Add" )) {
			new AddUser();
			System.out.println("in admin");
		}
		//utilites and exit
		if (msg.equals("Notepad")) {
			try {
				Runtime.getRuntime().exec("notepad.exe");
			} catch (Exception e2) {
				e2.printStackTrace();
			}		
		}if (msg.equals("Calculator" )) {
			try {
				Runtime.getRuntime().exec("calc.exe");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}if (msg.equals("Exit now" )) {
			setVisible(false);
		}
	}
}
