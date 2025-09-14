package UniManSya;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class LeaveDetailsStudent extends JFrame implements ActionListener{
	Choice choice;
	JTable table;
	JButton search, print, all, cancel;
	
	public LeaveDetailsStudent() {
		getContentPane().setBackground(Color.white);
		setSize(630, 530);
		setLocation(250, 140);
		setLayout(null);
		
		JLabel heading= new JLabel("See Student's leave Details");
		heading.setBounds(100, 10, 500, 30);
		heading.setFont(new Font("Tahoma",Font.BOLD, 30));
		add(heading);
		
		JLabel rolheading= new JLabel("Search by Bol No.");
		rolheading.setBounds(20,50,150,30);
		rolheading.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(rolheading);
		
		choice = new Choice();
		choice.setBounds(180,55,150,20);
		choice.setFont(new Font("Tahoma",Font.BOLD, 20));
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
		
		search=new JButton("Search");
		search.setBounds(20, 90, 120, 25);;
		search.setBackground(Color.black);
		search.setForeground(Color.white);
		search.setFont(new Font("Tahoma",Font.BOLD, 20));
		search.addActionListener(this);
		add(search);
		
		print=new JButton("Print");
		print.setBounds(170, 90, 120, 25);
		print.setBackground(Color.black);
		print.setForeground(Color.white);
		print.setFont(new Font("Tahoma",Font.BOLD, 20));
		print.addActionListener(this);
		add(print);
		
		cancel=new JButton("cancel");
		cancel.setBounds(320, 90, 120, 25);
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.setFont(new Font("Tahoma",Font.BOLD, 20));
		cancel.addActionListener(this);
		add(cancel);
		
		table = new JTable();
		JScrollPane jsp= new JScrollPane(table);
		jsp.setBounds(10,140, 600, 400);
		jsp.setBackground(Color.white);
		table.setFont(new Font("Tahoma",Font.PLAIN, 15));
		add(jsp);
		
		try {
			Conn conn= new Conn();
			ResultSet re =conn.s.executeQuery("select * from studentleave");
			table.setModel(DbUtils.resultSetToTableModel(re));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		setVisible(true);
	}
	public static void main(String[] args) {
		new LeaveDetailsStudent();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==search) {
			String quary= "select * from  studentleave where rollno ='"+choice.getSelectedItem()+"'";
			try {
				Conn conn= new Conn();
				ResultSet re =conn.s.executeQuery(quary);
				table.setModel(DbUtils.resultSetToTableModel(re));
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}else if(e.getSource()==print) {
			try {
				table.print();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}else {
			setVisible(false);
		}
		
	}

}

