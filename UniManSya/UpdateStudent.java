package UniManSya;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.DataOutput;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class UpdateStudent extends JFrame implements ActionListener{
	JLabel srolno;
	JTextField cbranch , ccourse , tfaddr, tfpno,tfemail,tfano;
	JButton add, cancel;
	Choice choice;
	Random ran=new Random();
	long first4=Math.abs((ran.nextLong()%9000L)+1000L);
	JDateChooser dcbob;
	public UpdateStudent() {
		getContentPane().setBackground(Color.white);
		setSize(900, 530);
		setLocation(150, 140);
		setLayout(null);
		
		JLabel heading= new JLabel("Update Student Details");
		heading.setBounds(300, 10, 500, 30);
		heading.setFont(new Font("Tahoma",Font.BOLD, 30));
		add(heading);
		
		JLabel rolheading= new JLabel("Search by Rol No.");
		rolheading.setBounds(50,50,200,30);
		rolheading.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(rolheading);
		
		choice = new Choice();
		choice.setBounds(280,55,150,20);
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
		
		
		JLabel course= new JLabel("Course");
		course.setBounds(40, 110, 150, 30);
		course.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(course);
		ccourse =new JTextField();
		ccourse.setBackground(Color.white);
		ccourse.setBounds(170, 110,100, 30);
		add(ccourse);
		
		JLabel branch= new JLabel("Branch");
		branch.setBounds(400, 110, 150, 30);
		branch.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(branch);
		cbranch =new JTextField();
		cbranch.setBackground(Color.white);
		cbranch.setBounds(600, 110,100, 30);
		add(cbranch);
		
		JLabel name= new JLabel("Name");
		name.setBounds(40, 160, 100, 30);
		name.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(name);
		JLabel tfname = new JLabel();
		tfname.setBounds(170, 160, 150, 30);
		tfname.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(tfname);
		
		JLabel fname= new JLabel("Fatheer Name");
		fname.setBounds(400, 160, 150, 30);
		fname.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(fname);
		JLabel tffname = new JLabel();
		tffname.setBounds(600, 160, 150, 30);
		tffname.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(tffname);
		
		JLabel rolno= new JLabel("Roll No");
		rolno.setBounds(40, 210, 150, 30);
		rolno.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(rolno);
		srolno= new JLabel();
		srolno.setBounds(170, 210, 150, 30);
		srolno.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(srolno);
		
		JLabel dob= new JLabel("DOB");
		dob.setBounds(400, 210, 150, 30);
		dob.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(dob);
		JLabel dcdob =new JLabel();
		dcdob.setBounds(600, 210, 150, 30);
		dcdob.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(dcdob);

		JLabel addr= new JLabel("Address");
		addr.setBounds(40, 270, 150, 30);
		addr.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(addr);
		tfaddr= new JTextField();
		tfaddr.setBounds(170, 270, 150, 30);
		tfaddr.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(tfaddr);
		
		JLabel email= new JLabel("Email");
		email.setBounds(400, 270, 150, 30);
		email.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(email);
		tfemail= new JTextField();
		tfemail.setBounds(600, 270, 150, 30);
		tfemail.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(tfemail);
		
		JLabel pno= new JLabel("Phone");
		pno.setBounds(40, 330, 150, 30);
		pno.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(pno);
		tfpno= new JTextField();
		tfpno.setBounds(170, 330, 150, 30);
		tfpno.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(tfpno);
		
		JLabel ano= new JLabel("Adhar");
		ano.setBounds(400, 330, 150, 30);
		ano.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(ano);
		tfano= new JTextField();
		tfano.setBounds(600, 330, 150, 30);
		tfano.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(tfano);
		
		JLabel m10= new JLabel("Class 10 %");
		m10.setBounds(40, 390, 150, 30);
		m10.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(m10);
		JLabel tfm10= new JLabel();
		tfm10.setBounds(170, 390, 150, 30);
		tfm10.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(tfm10);
		
		JLabel m12= new JLabel("Class 12 %");
		m12.setBounds(400, 390, 150, 30);
		m12.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(m12);
		JLabel tfm12= new JLabel();
		tfm12.setBounds(600, 390, 150, 30);
		tfm12.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(tfm12);
		
		
		choice.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				//filling values in the Jlabel from database according to choice
				try {
					Conn con =new Conn();
					String query ="select * from student where rollno='"+choice.getSelectedItem()+"'";
					ResultSet rs = con.s.executeQuery(query);
					while(rs.next()) {
						ccourse.setText(rs.getString("course"));
						cbranch.setText(rs.getString("branch"));
						tfname.setText(rs.getString("name"));
						tffname.setText(rs.getString("fname"));
						srolno.setText(rs.getString("rollno"));
						dcdob.setText(rs.getString("dob"));
						tfaddr.setText(rs.getString("address"));
						tfemail.setText(rs.getString("email"));
						tfpno.setText(rs.getString("phone"));
						tfano.setText(rs.getString("adhar"));
						tfm10.setText(rs.getString("m10"));
						tfm12.setText(rs.getString("m12"));

					}
					
				} catch (Exception e2) {
					e2.printStackTrace();		
				}
			}
		});

		add=new JButton("Update");
		add.setBounds(300, 445, 120, 30);
		add.setBackground(Color.black);
		add.setForeground(Color.white);
		add.setFont(new Font("Tahoma",Font.BOLD, 20));
		add.addActionListener(this);
		add(add);
		
		cancel=new JButton("cancel");
		cancel.setBounds(490, 445, 120, 30);
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.setFont(new Font("Tahoma",Font.BOLD, 20));
		cancel.addActionListener(this);
		add(cancel);
		
		
		setVisible(true);
	}

	public static void main(String[] args) {
		 new UpdateStudent();
	} 

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == add ) {
			String course = ccourse.getText();
			String branch =cbranch.getText();			
			String rollno =srolno.getText();
			String address =tfaddr.getText();
			String email =tfemail.getText();			
			String phone =tfpno.getText();
			
			try {
				String quary ="update student set course= '"+course+"',branch='"+branch+"',address='"+address+"',phone='"+phone+"',email='"+email+"' where rollno = '"+rollno+"'";
				Conn con =new Conn();
				con.s.executeUpdate(quary);
				JOptionPane.showMessageDialog(null, "Student Details Updated Sucessfully");
				System.out.println("New Entry Inserted Sucessfully");
				setVisible(false);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}else {
			setVisible(false);
			new Project();

		}
	}

}
