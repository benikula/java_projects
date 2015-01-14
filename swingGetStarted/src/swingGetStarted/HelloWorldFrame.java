package swingGetStarted;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelloWorldFrame extends JFrame {

	private static final long serialVersionUID = 6882695623629402800L;
	
	public HelloWorldFrame() {
		JLabel jlbHelloWorld = new JLabel("Hello World", JLabel.CENTER);
		JLabel lable2 = new JLabel("12345", JLabel.CENTER);
		add(jlbHelloWorld);
		setLayout(new GridLayout(2, 2));
		add(lable2);
		this.setSize(200, 200);
		setVisible(true);
		
	}
}
