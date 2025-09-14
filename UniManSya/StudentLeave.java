package UniManSya;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class StudentLeave  extends JFrame implements ActionListener{
	Choice choice , ctmo;
	JDateChooser ldate;
	JButton add, cancel;
	//JTextArea fild;
	JTextField fild;
	public StudentLeave() {
		getContentPane().setBackground(Color.white);
		setSize(500, 430);
		setLocation(350, 140);
		setLayout(null);
		
		JLabel heading= new JLabel("Leave Application for Students");
		heading.setBounds(50, 10, 500, 30);
		heading.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(heading);
		
		JLabel rolheading= new JLabel("Search by RollNo");
		rolheading.setBounds(20,70,200,30);
		rolheading.setFont(new Font("Tahoma",Font.BOLD, 17));
		add(rolheading);
		
		choice = new Choice();
		choice.setBounds(220,75,150,20);
		choice.setFont(new Font("Tahoma",Font.BOLD, 17));
		add(choice);

		try {
			Conn conn= new Conn();
			ResultSet re =conn.s.executeQuery("select * from student");
			while(re.next()) {
				choice.add(re.getString("rollno"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JLabel dateLabel= new JLabel("Leave Date");
		dateLabel.setBounds(20, 120, 150, 30);
		dateLabel.setFont(new Font("Tahoma",Font.BOLD, 17));
		add(dateLabel);
		ldate =new JDateChooser();
		ldate.setBounds(220,125, 150, 30);
		ldate.setFont(new Font("Tahoma",Font.BOLD, 17));
		add(ldate);
		
		JLabel time= new JLabel("Duration");
		time.setBounds(20,170,150,30);
		time.setFont(new Font("Tahoma",Font.BOLD, 17));
		add(time);
		
		ctmo = new Choice();
		ctmo.setBounds(220,176,150,20);
		ctmo.setFont(new Font("Tahoma",Font.BOLD, 17));
		ctmo.add("Full Day");
		ctmo.add("Half Day");
		add(ctmo);
		
		JLabel note= new JLabel("Write your reason in 5 words max");
		note.setBounds(20,240,450,30);
		note.setFont(new Font("Tahoma",Font.BOLD, 17));
		add(note);

		
		JLabel lfild= new JLabel("Search by RollNo");
		lfild.setBounds(20,270,150,30);
		lfild.setFont(new Font("Tahoma",Font.BOLD, 17));
		add(lfild);
		
//		fild= new JTextArea(10,30);
//		JScrollPane pane=new JScrollPane(fild);
//		pane.setBounds(220,275,250,30);
//		fild.setLineWrap(true);
//		fild.setWrapStyleWord(true);
//		fild.setBorder(BorderFactory.createLineBorder(Color.black, 2));
//		fild.setFont(new Font("Tahoma",Font.BOLD, 17));
//		add(pane);
		fild = new JTextField();
		fild.setBounds(220,275,250,30);
		fild.setFont(new Font("Tahoma",Font.BOLD, 17));
		add(fild);

		



		add=new JButton("Submit");
		add.setBounds(60, 350, 120, 30);
		add.setBackground(Color.black);
		add.setForeground(Color.white);
		add.setFont(new Font("Tahoma",Font.BOLD, 20));
		add.addActionListener(this);
		add(add);
		
		cancel=new JButton("cancel");
		cancel.setBounds(240, 350, 120, 30);
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.setFont(new Font("Tahoma",Font.BOLD, 20));
		cancel.addActionListener(this);
		add(cancel);


		
		setVisible(true);
	}

	public static void main(String[] args) {
		new StudentLeave();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==add) {
			String rollno= choice.getSelectedItem();	
			String date =((JTextField) ldate.getDateEditor().getUiComponent()).getText();
			String duration = ctmo.getSelectedItem();
			String readon= fild.getText();
			
			String query="insert into studentleave values ('"+rollno+"','"+date+"','"+duration+"','"+readon+"')";
			try {
				Conn c=new Conn();
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Leave Conformed");
				setVisible(false);
			} catch (Exception e2) {
					e2.printStackTrace();
			}
		}else {
			setVisible(false);
		}
		
	}

}
