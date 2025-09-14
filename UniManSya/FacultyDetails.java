
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

public class FacultyDetails extends JFrame implements ActionListener{
	Choice cid;
	JTable table;
	JButton search, print, update,add, cancel;
	
	public FacultyDetails() {
		getContentPane().setBackground(Color.white);
		setSize(900, 530);
		setLocation(150, 140);
		setLayout(null);
		
		JLabel heading= new JLabel("See Faculty Details");
		heading.setBounds(300, 10, 500, 30);
		heading.setFont(new Font("Tahoma",Font.BOLD, 30));
		add(heading);
		
		JLabel rolheading= new JLabel("Search by Employ Id");
		rolheading.setBounds(20,50,150,30);
		rolheading.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(rolheading);
		
		cid = new Choice();
		cid.setBounds(180,55,150,20);
		cid.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(cid);
		
		try {
			Conn conn= new Conn();
			ResultSet re =conn.s.executeQuery("select * from faculty");
			while(re.next()) {
				cid.add(re.getString("empid"));
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
		
		update=new JButton("Update");
		update.setBounds(320, 90, 120, 25);
		update.setBackground(Color.black);
		update.setForeground(Color.white);
		update.setFont(new Font("Tahoma",Font.BOLD, 20));
		update.addActionListener(this);
		add(update);
		
		add=new JButton("Add");
		add.setBounds(470, 90, 120, 25);
		add.setBackground(Color.black);
		add.setForeground(Color.white);
		add.setFont(new Font("Tahoma",Font.BOLD, 20));
		add.addActionListener(this);
		add(add);
		
		cancel=new JButton("Cancel");
		cancel.setBounds(620, 90, 120, 25);
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.setFont(new Font("Tahoma",Font.BOLD, 20));
		cancel.addActionListener(this);
		add(cancel);
		
		table = new JTable();
		JScrollPane jsp= new JScrollPane(table);
		jsp.setBounds(10,140, 900, 400);
		jsp.setBackground(Color.white);
		table.setFont(new Font("Tahoma",Font.BOLD, 10));
		add(jsp);
		
		try {
			Conn conn= new Conn();
			ResultSet re =conn.s.executeQuery("select * from faculty");
			table.setModel(DbUtils.resultSetToTableModel(re));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		setVisible(true);
	}
	public static void main(String[] args) {
		new FacultyDetails();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==search) {
			String quary= "select * from  faculty where empid ='"+cid.getSelectedItem()+"'";
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
		}else if(e.getSource()==update) {
			setVisible(false);
			new UpdateFaculty();
		}else if(e.getSource()==add){
			setVisible(false);
			new AddStudentt();
		}else {
			setVisible(false);
		}
		
	}

}
