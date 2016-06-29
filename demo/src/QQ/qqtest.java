package QQ;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class qqtest extends Thread{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					qqtest window = new qqtest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public qqtest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 466, 404);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrS = new JTextArea();
		txtrS.setText("s");
		txtrS.setBounds(-3, 259, 4, 24);
		frame.getContentPane().add(txtrS);
		
		JTextArea txtrAa = new JTextArea();
		txtrAa.setBounds(0, 259, 346, 85);
		frame.getContentPane().add(txtrAa);
		
		JTextArea txtrDd = new JTextArea();
		txtrDd.setEditable(false);
		txtrDd.setBounds(0, 10, 346, 229);
		frame.getContentPane().add(txtrDd);
		
		JButton btnNewButton = new JButton("\u5173\u95ED");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(196, 343, 70, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D1\u9001");
		btnNewButton_1.setHorizontalAlignment(SwingConstants.TRAILING);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(new String(txtrDd.getText()).equals("")){
					txtrDd.setText(txtrAa.getText());
				    txtrAa.setText("");
				    }else{
				    	txtrDd.setText(txtrDd.getText()+"\n"+txtrAa.getText());
				    	txtrAa.setText("");
				    }
			}
		});
		btnNewButton_1.setBounds(276, 343, 70, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("A");
		btnNewButton_2.setBackground(new Color(240, 240, 240));
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setFont(new Font("ËÎÌו", Font.BOLD | Font.ITALIC, 17));
		btnNewButton_2.setToolTipText("\u5B57\u4F53\u9009\u62E9\u5DE5\u5177\u680F");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//btnNewButton_2.setBorder(null);
				
			}
		});
		//btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBounds(-13, 238, 51, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(-3, 259, 4, 24);
		frame.getContentPane().add(textArea);
		

		
	}
}
