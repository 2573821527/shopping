package shopping;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import io.ObjectStream;
import model.Admin;
import port.TCPServer;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class adminlogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private static JFrame frame;
	private ServerSocket ss;
	private Socket socket;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new adminlogin();
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
	public adminlogin() {
		setTitle("中北线在商场管理系统-管理员登录");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("用户名:");
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
				Admin a = new Admin();
				Admin a2 = ObjectStream.read(Admin.class, "/admin/" + a.getName() + ".dat");
				if (a2.getName().equals(textField.getText())
						&& a2.getPass().equals(new String(passwordField.getPassword()))) {
					new adminstore(frame);
				} else {
					JOptionPane.showMessageDialog(null, "用户名密码错误");
				}
				// as.setVisible(true);
			}
		});
		button.setBounds(255, 216, 93, 23);
		contentPane.add(button);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\javaproject\\shopping\\images\\a.jpg"));
		lblNewLabel.setBounds(189, 33, 70, 94);
		contentPane.add(lblNewLabel);
		TCPServer server = new TCPServer();
		server.setDaemon(true);
		server.start();
	}
}
