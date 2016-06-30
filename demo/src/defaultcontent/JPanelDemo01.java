package defaultcontent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelDemo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       JFrame frame =new JFrame("welcome to mldn");
       JPanel pan=new JPanel();
       pan.add(new JLabel("1"));
       pan.add(new JLabel("2"));
       pan.add(new JLabel("3"));
       pan.add(new JLabel("4"));
       pan.add(new JLabel("5"));
       pan.add(new JLabel("6"));
       frame.add(pan);
       frame.pack();
       frame.setVisible(true);
       frame.setLocation(300,200);      
	}

}
