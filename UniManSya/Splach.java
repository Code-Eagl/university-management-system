package UniManSya;

import java.awt.Image;
import java.util.concurrent.ThreadPoolExecutor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Splach  extends JFrame implements Runnable{
	Thread t;
	public Splach() {
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1000, 600,  Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		add(image);
		t=new Thread(this);
		t.start();
		
		setVisible(true);
		int x =1;
		for(int i=2; i<=500; i+=4, x+=1) {
			setLocation(450-((i+x)/2), 300-(i/2));
			setSize(i+4*x,i+x/2);
			try {
				Thread.sleep(5);
			} catch (Exception e) {
			}

		}
	}
	@Override
	public void run() {
		try {
			Thread.sleep(7000);
			setVisible(false);
			
			//next frame
			new Login();
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {
		new Splach();

	}

}
