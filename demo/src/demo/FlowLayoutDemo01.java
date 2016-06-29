package demo;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutDemo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          JFrame frame =new JFrame("welcome to mldn");
          frame.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
          JButton but=null;
          for(int i=0;i<9;i++){
        	  but= new JButton("°´Å¥-"+i);
        	  frame.add(but);
          }
          frame.setVisible(true);
          frame.setSize(280, 123);
	}

}
