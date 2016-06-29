package demo;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutDemo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        JFrame frame=new JFrame("welcome to mldn");
        frame.setLayout(new BorderLayout(3,3));
        frame.add(new JButton("1"), BorderLayout.EAST);
        frame.add(new JButton("2"), BorderLayout.WEST);
        frame.add(new JButton("3"), BorderLayout.SOUTH);
        frame.add(new JButton("4"), BorderLayout.NORTH);
        frame.add(new JButton("5"), BorderLayout.CENTER);
        frame.setVisible(true);
        frame.pack();
	}

}
