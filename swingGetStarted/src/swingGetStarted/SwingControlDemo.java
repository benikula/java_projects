package swingGetStarted;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingControlDemo {

	private JFrame mainFrame;
	private JLabel header;
	private JLabel status;
	private JPanel controlPanel;
	
	SwingControlDemo() {
		initWindow();
	}

	private void initWindow() {
		mainFrame = new JFrame("very nice window");
		mainFrame.setLayout(new GridLayout(3, 1));
		mainFrame.setSize(400, 400);
		header = new JLabel("", JLabel.CENTER);
		status = new JLabel("", JLabel.CENTER);
		
		mainFrame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
		        System.exit(0);
	         }        
	      }); 
		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());
		
		mainFrame.add(header);
		mainFrame.add(controlPanel);
		mainFrame.add(status);
		
		mainFrame.setVisible(true);
		
	}
	
	public void showWindow() {
		header.setText("Control in action: Button");
		JButton next = new JButton("Next");
		JButton prev = new JButton("Prev");
		JButton finish = new JButton("Finish");
		
		next.setActionCommand("Next");
		prev.setActionCommand("Prev");
		finish.setActionCommand("Finish");
		
		next.addActionListener(new ButtonClickListener());
		prev.addActionListener(new ButtonClickListener());
		finish.addActionListener(new ButtonClickListener());
		
		controlPanel.add(next);
		controlPanel.add(prev);
		controlPanel.add(finish);       

		mainFrame.setVisible(true);
	}
	
	private class ButtonClickListener implements ActionListener{
	      public void actionPerformed(ActionEvent e) {
	         String command = e.getActionCommand();  
	         if( command.equals( "Next" ))  {
	            status.setText("Next Button clicked.");
	         }
	         else if( command.equals( "Prev" ) )  {
	            status.setText("Prev Button clicked."); 
	         }
	         else  {
	            status.setText("Finish Button clicked.");
	         }  	
	      }		
	   }
}
