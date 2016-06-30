package defaultcontent;

import java.awt.Container;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class JScrollPaneDemo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    JFrame frame=new JFrame("welcome to mldn");
    Container cont=frame.getContentPane();
    Icon icon=new ImageIcon("images/20090112112114631.jpg");
    JPanel pan=new JPanel();
    JLabel lab=new JLabel(icon);
    pan.add(lab);
    JScrollPane scr1=null;
    scr1=new JScrollPane(pan,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    cont.add(scr1);
    frame.setSize(230, 120);
    frame.setVisible(true);
    frame.setLocation(300,200);
	}

}
