package shopping;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import io.ObjectStream;
import model.person;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class regist extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					regist frame = new regist(null);
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
	public regist( JFrame parents) {
		setTitle("注册页面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("用户名：");
		label.setBounds(92, 21, 54, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("密码：");
		label_1.setBounds(92, 66, 54, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("姓名：");
		label_2.setBounds(92, 109, 68, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("年龄：");
		label_3.setBounds(92, 150, 54, 15);
		contentPane.add(label_3);
		
		JButton button = new JButton("完成注册");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				person p=new person();
                p.setUsername(textField.getText());
                p.setPassword(new String(passwordField.getPassword()));
                p.setName(textField_2.getText());
                p.setAge(textField_3.getText());
				ObjectStream.write("/users/" +textField.getText()+ ".dat", p);
/*				person p1=ObjectStream.read(person.class, "/users/"+textField.getText()+".dat");
				System.out.println(p1);*/
				JOptionPane.showMessageDialog(null, "注册成功");
			}
		});
		button.setBounds(156, 206, 93, 23);
		contentPane.add(button);
		
		textField = new JTextField();
		textField.setBounds(156, 18, 152, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(157, 106, 151, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(156, 147, 152, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(156, 63, 152, 21);
		contentPane.add(passwordField);
		this.setVisible(true);
	}
}
