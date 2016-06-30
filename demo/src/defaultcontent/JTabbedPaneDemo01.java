package defaultcontent;

import java.awt.Container;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class JTabbedPaneDemo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       JFrame frame=new JFrame("welcome to mldn");
       Container cont=frame.getContentPane();
       JTabbedPane tab=null;
       tab=new JTabbedPane(JTabbedPane.TOP);
       JPanel pan1=new JPanel();
       JPanel pan2=new JPanel();
       JButton but=new JButton("按钮");
       JLabel lab=new JLabel("标签");
       pan1.add(but);
       pan2.add(lab);
       //String path="";
       tab.addTab("aa", new ImageIcon("images/20090112112114631.jpg"),pan1,"图像");
       //tab.addTab("图片选项", pan1);
       //tab.addTab("文字选项", pan2);
       tab.addTab("文字选项", pan2);
       cont.add(tab);
       frame.setSize(230, 120);
       frame.setVisible(true);
       frame.setLocation(300,200);
	}

}
