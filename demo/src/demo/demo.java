package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

import java.awt.BorderLayout;
import java.awt.Color;

public class demo {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					demo window = new demo();
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
	public demo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 165, 0));
		frame.getContentPane().setForeground(Color.PINK);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setBounds(52, 55, 54, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setBounds(52, 86, 54, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setForeground(Color.RED);
		textField.setBounds(116, 52, 185, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.setToolTipText("\u70B9\u51FB\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username=textField.getText();
				String password=new String(passwordField.getPassword());
				if("mugang".equals(username)&&"123".equals(password)){
					//JOptionPane.showConfirmDialog(null, "µÇÂ¼³É¹¦");
					new OpenJFrame2(frame);
				}else{
					JOptionPane.showConfirmDialog(null, "µÇÂ¼Ê§°Ü");
				}
			}
		});
		btnNewButton.setBounds(52, 125, 93, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(" ");
				passwordField.setText("");
			}
		});
		btnNewButton_1.setToolTipText("\u70B9\u51FB\u91CD\u7F6E");
		btnNewButton_1.setBounds(155, 125, 93, 23);
		frame.getContentPane().add(btnNewButton_1);
		passwordField = new JPasswordField();
		passwordField.setBounds(116, 83, 185, 21);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("\u767B\u5F55\u7A0B\u5E8F");
		lblNewLabel_2.setBounds(158, 10, 54, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton button = new JButton("\u6CE8\u518C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new regist(frame);
			}
		});
		button.setBounds(258, 125, 93, 23);
		frame.getContentPane().add(button);
	}
}