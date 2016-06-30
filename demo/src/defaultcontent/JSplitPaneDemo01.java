package defaultcontent;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;

public class JSplitPaneDemo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      JFrame frame= new JFrame();
      Container cont =frame.getContentPane();
      JSplitPane lfsplit=null;
      JSplitPane tbsplit=null;
      lfsplit=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,new JLabel("left"),new JLabel("right"));
      lfsplit.setDividerSize(3);
      tbsplit=new JSplitPane(JSplitPane.VERTICAL_SPLIT,lfsplit,new JLabel("bottom"));
      tbsplit.setDividerSize(10);
      tbsplit.setOneTouchExpandable(true);
      cont.add(tbsplit);
      frame.setVisible(true);
      frame.setLocation(300,200);
      frame.setSize(230, 80);
	}

}
