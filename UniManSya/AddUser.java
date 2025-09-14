package UniManSya;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.cj.protocol.Resultset;

public class AddUser extends JFrame implements ActionListener{
	JTextField tfusername, tfpassword;
	//JPasswordField tfpassword;
	JButton login, cancel;
	public AddUser() {
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel heading= new JLabel("Add New Admin");
		heading.setBounds(140, 20, 250, 50);
		heading.setFont(new Font("Tahoma",Font.BOLD, 30));
		add(heading);
		
		JLabel username= new JLabel("User Name");
		username.setBounds(40, 80, 150, 30);
		username.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(username);
		tfusername= new JTextField();
		tfusername.setBounds(190, 80, 150, 30);
		tfusername.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(tfusername);
		
		JLabel password= new JLabel("Password");
		password.setBounds(40, 140, 100, 30);
		password.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(password);
		tfpassword= new JTextField();
		tfpassword.setBounds(190, 140, 150, 30);
		tfpassword.setFont(new Font("Tahoma",Font.BOLD, 20));
		add(tfpassword);

		login=new JButton("Add User");
		login.setBounds(40, 200, 120, 30);
		login.setBackground(Color.black);
		login.setForeground(Color.white);
		login.setFont(new Font("Tahoma",Font.BOLD, 20));
		login.addActionListener(this);
		add(login);
		
		cancel=new JButton("cancel");
		cancel.setBounds(180, 200, 120, 30);
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.setFont(new Font("Tahoma",Font.BOLD, 20));
		cancel.addActionListener(this);
		add(cancel);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
		Image i2 = i1.getImage().getScaledInstance(200, 200,  Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(350, 20, 200, 200 );
		add(image);

		
		setSize(600, 300);
		setLocation(300, 210);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login) {
			String uname=tfusername.getText();
			String password=tfpassword.getText();
			String quary="insert into login values('"+uname+"','"+password+"')";
			try {
				Conn con =new Conn();
				con.s.executeUpdate(quary);
				JOptionPane.showMessageDialog(null, "New User Added");
				System.out.println("New User Added");
				setVisible(false);
				new Login();
			} catch (Exception e2) {
				e2.printStackTrace();			
			}
		}else if(e.getSource()==cancel) {
			setVisible(false);
			new Project();
		}
	}

	public static void main(String[] args) {
		new AddUser();
	}

}
