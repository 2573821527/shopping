package shopping;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import io.ObjectStream;
import model.person;
import port.TCPClient;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class userlogin1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private static JFrame frame;
	private Socket socket;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new userlogin1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public userlogin1() {
		this.frame=this;
		setTitle("中北线在商场-登录");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("用户登录:");
		label.setBounds(87, 146, 54, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("密码:");
		label_1.setBounds(87, 185, 54, 15);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(151, 146, 197, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(151, 185, 197, 21);
		contentPane.add(passwordField);
		
		JButton button = new JButton("登录系统");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String account=textField.getText().trim();
				String password=new String(passwordField.getPassword());
				String msg="login@#@"+account+"@#@"+password;
				String result=new TCPClient().send(msg);
				
				if("success".equals(result)){
					userstore us=new userstore(frame,textField.getText());
					us.setVisible(true);
					frame.setVisible(false);
				}else{
					JOptionPane.showMessageDialog(null, result.split("@#@")[1]);
				}
				
			}
		});
		button.setBounds(87, 221, 93, 23);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\javaproject\\shopping\\images\\a.jpg"));
		lblNewLabel.setBounds(208, 54, 70, 82);
		contentPane.add(lblNewLabel);
		
		JButton button_1 = new JButton("注册");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg2="regist@#@"+textField.getText()+"@#@"+new String(passwordField.getPassword());
				String result=new TCPClient().send(msg2);
				if(result.equals("success")){
					JOptionPane.showMessageDialog(null, "注册成功");
				}else{
					JOptionPane.showMessageDialog(null, "注册失败");
				}
			}
		});
		button_1.setBounds(255, 221, 93, 23);
		contentPane.add(button_1);
	}
}
