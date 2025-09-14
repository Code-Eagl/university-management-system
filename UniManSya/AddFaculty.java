package UniManSya;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

public class AddFaculty extends JFrame implements ActionListener{
	JLabel srolno;
	JTextField tfname, tffname,tfaddr, tfpno,tfemail,tfano,tfdid, tfksub;
	JComboBox ccourse, branchb;
	JButton add, cancel;
	Random ran=new Random();
	long first4=Math.abs((ran.nextLong()%9000L)+1000L);
	JDateChooser dcbob;
	
	public AddFaculty() {
		getContentPane().setBackground(Color.white);
		setSize(900, 530);
		setLocation(150, 140);
		setLayout(null);
		
		JLabel heading= new JLabel("New Faculty Details");
		heading.setBounds(300, 10, 500, 30);
		heading.setFont(new Font("Tahoma",Font.BOLD, 30));
		add(heading);
		
		JLabel course= new JLabel("Qualifications");
		course.setBounds(40, 70, 100, 30);
		course.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(course);
		String courses[] = {"phd", "BBA", "MBA", "MCOM","MCA"};
		ccourse =new JComboBox(courses);
		ccourse.setBackground(Color.white);
		ccourse.setBounds(170, 70,100, 30);
		add(ccourse);
		
		JLabel branch= new JLabel("Department");
		branch.setBounds(400, 100, 100, 30);
		branch.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(branch);
		String cbranch[] = {"CSE", "IT", "Civil", "DA", "Graphic Design"};
		branchb =new JComboBox(cbranch);
		branchb.setBackground(Color.white);
		branchb.setBounds(600, 70,100, 30);
		add(branchb);
		
		JLabel name= new JLabel("Name");
		name.setBounds(40, 120, 100, 30);
		name.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(name);
		tfname = new JTextField();
		tfname.setBounds(170, 120, 150, 30);
		tfname.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(tfname);
		
		JLabel fname= new JLabel("Middle Name");
		fname.setBounds(400, 120, 150, 30);
		fname.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(fname);
		tffname = new JTextField();
		tffname.setBounds(600, 120, 150, 30);
		tffname.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(tffname);
		
		JLabel rolno= new JLabel("Emp. Id");
		rolno.setBounds(40, 170, 150, 30);
		rolno.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(rolno);
		srolno= new JLabel("01-"+first4);
		srolno.setBounds(170, 170, 150, 30);
		srolno.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(srolno);
		
		JLabel dob= new JLabel("DOB");
		dob.setBounds(400, 170, 150, 30);
		dob.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(dob);
		dcbob =new JDateChooser();
		dcbob.setBounds(600, 170, 150, 30);
		dcbob.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(dcbob);

		JLabel addr= new JLabel("Address");
		addr.setBounds(40, 230, 150, 30);
		addr.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(addr);
		tfaddr= new JTextField();
		tfaddr.setBounds(170, 230, 150, 30);
		tfaddr.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(tfaddr);
		
		JLabel email= new JLabel("Email");
		email.setBounds(400, 230, 150, 30);
		email.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(email);
		tfemail= new JTextField();
		tfemail.setBounds(600, 230, 150, 30);
		tfemail.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(tfemail);
		
		JLabel pno= new JLabel("Phone No");
		pno.setBounds(40, 290, 150, 30);
		pno.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(pno);
		tfpno= new JTextField();
		tfpno.setBounds(170, 290, 150, 30);
		tfpno.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(tfpno);
		
		JLabel ano= new JLabel("Adhar No");
		ano.setBounds(400, 290, 150, 30);
		ano.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(ano);
		tfano= new JTextField();
		tfano.setBounds(600, 290, 150, 30);
		tfano.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(tfano);
		
		JLabel lab= new JLabel("Lab Syatus");
		lab.setBounds(40, 350, 150, 30);
		lab.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(lab);
		tfdid= new JTextField();
		tfdid.setBounds(170, 350, 150, 30);
		tfdid.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(tfdid);
		
		JLabel ksub= new JLabel("Spelization");
		ksub.setBounds(400, 350, 150, 30);
		ksub.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(ksub);
		tfksub= new JTextField();
		tfksub.setBounds(600, 350, 150, 30);
		tfksub.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(tfksub);
		
		
		add=new JButton("Submit");
		add.setBounds(300, 410, 120, 30);
		add.setBackground(Color.black);
		add.setForeground(Color.white);
		add.setFont(new Font("Tahoma",Font.BOLD, 20));
		add.addActionListener(this);
		add(add);
		
		cancel=new JButton("cancel");
		cancel.setBounds(490, 410, 120, 30);
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.setFont(new Font("Tahoma",Font.BOLD, 20));
		cancel.addActionListener(this);
		add(cancel);
		
		
		setVisible(true);
	}

	public static void main(String[] args) {
		 new AddFaculty();
	} 

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==add) {
			String department = (String) ccourse.getSelectedItem();
			String branch = (String) branchb.getSelectedItem();
			String name=tfname.getText();
			String fname= tffname.getText();
			String id=srolno.getText();
			String dob= ((JTextField)dcbob.getDateEditor().getUiComponent()).getText();
			String address=tfaddr.getText();
			String phone=tfpno.getText();
			String email=tfemail.getText();
			String adhar=tfano.getText();
			String lab=tfdid.getText();
			String spelization=tfksub.getText();
			try {
				String quary ="insert into faculty values('"+department+"','"+branch+"','"+name+"', '"+fname+"','"+id+"', '"+dob+"','"+address+"','"+phone+"','"+email+"','"+adhar+"','"+lab+"','"+spelization+"')";
				Conn con =new Conn();
				con.s.executeUpdate(quary);
				JOptionPane.showMessageDialog(null, "New Entry Inserted Sucessfully");
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
