package listener;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MyKeyHandle extends JFrame implements KeyListener{
   private JTextArea text=new JTextArea();

public MyKeyHandle() throws HeadlessException {
	super.setTitle("welcome to mldn");
	JScrollPane scr=new JScrollPane(text);
	super.add(scr);
	text.addKeyListener(this);
	super.setSize(310, 201);
	super.setVisible(true);
    super.addWindowListener(new WindowListener() {
		
		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			System.exit(1);
		}
		
		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
	});	
}
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	text.append("输入的内容是"+e.getKeyChar()+"\n");
}

@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	text.append("键盘"+KeyEvent.getKeyText(e.getKeyCode())+"键按下\n");
}

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	text.append("键盘"+KeyEvent.getKeyText(e.getKeyCode())+"键松开\n");
}

}
