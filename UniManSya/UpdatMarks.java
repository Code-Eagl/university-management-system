package UniManSya;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdatMarks extends JFrame implements ActionListener{
	JTextField tfsub1, tfsub2, tfsub3, tfsub4, tfsub5, tfmarks1, tfmarks2, tfmarks3, tfmarks4, tfmarks5;
	Choice choice;
	JComboBox sem;
	JButton add, cancel;
	
	public UpdatMarks() {
		getContentPane().setBackground(Color.white);
		setSize(900, 460);
		setLocation(150, 140);
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
		Image i2 = i1.getImage().getScaledInstance(400, 300,  Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(480, 45, 400, 300 );
		add(image);
		
		
		JLabel heading= new JLabel("Update Student Marks");
		heading.setBounds(30, 10, 500, 30);
		heading.setFont(new Font("Tahoma",Font.BOLD, 30));
		add(heading);
		
		JLabel rolheading= new JLabel("Search by Rol No.");
		rolheading.setBounds(20,70,200,30);
		rolheading.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(rolheading);
		
		choice = new Choice();
		choice.setBounds(250,70,150,20);
		choice.setFont(new Font("Tahoma",Font.BOLD, 18));
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
		
		JLabel semister= new JLabel("Select Semester");
		semister.setBounds(20,110,200,30);
		semister.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(semister);
		String courses[] = {"1st Semester", "2nd Semester", "3rd Semester", "4th Semester","5th Semester" ,"6th Semester" ,"8th Semester" ,"8th Semester"};
		sem =new JComboBox(courses);
		sem.setBackground(Color.white);
		sem.setBounds(250, 110, 150, 30);
		add(sem);
		
		JLabel lsub= new JLabel("Enter Subject");
		lsub.setBounds(40, 150, 150, 30);
		lsub.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(lsub);
		
		JLabel lMarks= new JLabel("Enter Marks");
		lMarks.setBounds(270, 150, 150, 30);
		lMarks.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(lMarks);
		
		
		tfsub1 =new JTextField();
		tfsub1.setBackground(Color.white);
		tfsub1.setBounds(20, 200,200, 30);
		add(tfsub1);
		tfsub2 =new JTextField();
		tfsub2.setBackground(Color.white);
		tfsub2.setBounds(20, 230,200, 30);
		add(tfsub2);
		tfsub3 =new JTextField();
		tfsub3.setBackground(Color.white);
		tfsub3.setBounds(20, 260,200, 30);
		add(tfsub3);
		tfsub4 =new JTextField();
		tfsub4.setBackground(Color.white);
		tfsub4.setBounds(20, 290,200, 30);
		add(tfsub4);
		tfsub5 =new JTextField();
		tfsub5.setBackground(Color.white);
		tfsub5.setBounds(20, 320,200, 30);
		add(tfsub5);
		
		tfmarks1 =new JTextField();
		tfmarks1.setBackground(Color.white);
		tfmarks1.setBounds(250, 200,200, 30);
		add(tfmarks1);
		tfmarks2 =new JTextField();
		tfmarks2.setBackground(Color.white);
		tfmarks2.setBounds(250, 230,200, 30);
		add(tfmarks2);
		tfmarks3 =new JTextField();
		tfmarks3.setBackground(Color.white);
		tfmarks3.setBounds(250, 260,200, 30);
		add(tfmarks3);
		tfmarks4 =new JTextField();
		tfmarks4.setBackground(Color.white);
		tfmarks4.setBounds(250, 290,200, 30);
		add(tfmarks4);
		tfmarks5 =new JTextField();
		tfmarks5.setBackground(Color.white);
		tfmarks5.setBounds(250, 320,200, 30);
		add(tfmarks5);
		
		 add=new JButton("Submit");
		 add.setBounds(50, 370, 160, 30);
		 add.setBackground(Color.black);
		 add.setForeground(Color.white);
		 add.setFont(new Font("Tahoma",Font.BOLD, 20));
		 add.addActionListener(this);
		add(add);
		
		cancel=new JButton("cancel");
		cancel.setBounds(230, 370, 160, 30);
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.setFont(new Font("Tahoma",Font.BOLD, 20));
		cancel.addActionListener(this);
		add(cancel);
		
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==add) {
			try {
				Conn con =new Conn();
				String quary1 ="insert into subject values('"+choice.getSelectedItem()+"', '"+sem.getSelectedItem()+"','"+tfmarks1.getText()+"', '"+tfmarks2.getText()+"', '"+tfmarks3.getText()+"', '"+tfmarks4.getText()+"', '"+tfmarks5.getText()+"')";
				String quary2 ="insert into marks values('"+choice.getSelectedItem()+"', '"+sem.getSelectedItem()+"','"+tfmarks1.getText()+"', '"+tfmarks2.getText()+"', '"+tfmarks3.getText()+"', '"+tfmarks4.getText()+"', '"+tfmarks5.getText()+"')";

				con.s.executeUpdate(quary1);
				con.s.executeUpdate(quary2);

				JOptionPane.showMessageDialog(null, "New Entry Inserted Sucessfully");
				System.out.println("New Entry Inserted Sucessfully");
				setVisible(false);
				
			 	}catch (Exception e2) {
				e2.printStackTrace();			
			}
		}else if(e.getSource()==cancel) {
			setVisible(false);
			new Project();

		}
	}
	public static void main(String[] args) {
		new UpdatMarks();
	}


}
