package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class OpenJFrame2 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpenJFrame2 window = new OpenJFrame2();
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
	public OpenJFrame2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(380,245);
		 //设置此窗口永远为最上方 是window的方法
		frame.setAlwaysOnTop(true);
		 //不允许用户改变窗口的大小
		frame.setResizable(false);
		//让窗口在屏幕的正中间显示
		frame.setLocationRelativeTo(null); 
		frame.setTitle("用户");
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u767B\u5F55\u6210\u529F");
		label.setBounds(10, 10, 54, 15);
		frame.getContentPane().add(label);
		frame.setVisible(true);
	}
	 public OpenJFrame2(JFrame frame){
	      frame.setVisible(false);
	      initialize();
		 }
}

