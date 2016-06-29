package demo;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutDemo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          JFrame frame=new JFrame("welcome to mldn");
          frame.setLayout(new GridLayout(3, 5, 3, 3));
          JButton but=null;
          for(int i=0;i<13;i++){
        	  but =new JButton("°´Å¥"+i);
        	  frame.add(but);
          }
          frame.setVisible(true);
          frame.pack();
	}

}
