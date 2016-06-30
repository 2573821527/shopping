package defaultcontent;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JInternalFrameDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Welcome To MLDN") ;
		frame.setLayout(new BorderLayout());
		Container cont = frame.getContentPane() ;
		JDesktopPane desk=new JDesktopPane();
		cont.add(desk, BorderLayout.CENTER);
		cont.add(new JLabel("ÄÚ²¿´°Ìå"), BorderLayout.SOUTH);
		JInternalFrame lif=null;
		Icon icon=new ImageIcon("images/20090112112114631.jpg");
		JPanel pan=null;
		for(int i=0;i<3;i++){
			lif=new JInternalFrame("mldn"+i,true,true,true,true);
			pan=new JPanel();
			pan.add(new JLabel(icon));
			lif.setLocation(35-i*10, 35-i*10);
			lif.add(pan);
			lif.pack();
			lif.setVisible(true);
			desk.add(lif);
		}
		frame.setSize(300, 270) ;			
		frame.setLocation(300,200) ;			
		frame.setVisible(true) ;
	}

}
