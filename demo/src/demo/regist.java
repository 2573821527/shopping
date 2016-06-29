package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout.Group;

public class regist {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					regist window = new regist();
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
	public regist() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setSize(410,300);
		 //设置此窗口永远为最上方 是window的方法
		frame.setAlwaysOnTop(true);
		 //不允许用户改变窗口的大小
		frame.setResizable(false);
		//让窗口在屏幕的正中间显示
		frame.setLocationRelativeTo(null); 
		frame.setTitle("注册");
		frame.setVisible(true);
		
		JLabel label = new JLabel("\u6CE8\u518C\u4FE1\u606F");
		label.setBounds(164, 10, 54, 15);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setBounds(55, 50, 54, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setBounds(55, 82, 54, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setBounds(55, 111, 66, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		
		ButtonGroup bg = new ButtonGroup();
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\u7537");
		
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBounds(120, 132, 54, 23);
		bg.add(rdbtnNewRadioButton);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\u5973");
		rdbtnNewRadioButton_1.setBounds(188, 132, 54, 23);
		bg.add(rdbtnNewRadioButton_1);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		textField = new JTextField();
		textField.setBounds(128, 47, 181, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6027\u522B");
		label_1.setBounds(55, 136, 54, 15);
		frame.getContentPane().add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(129, 79, 180, 21);
		frame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(131, 108, 178, 21);
		frame.getContentPane().add(passwordField_1);
		
		JButton button = new JButton("\u5B8C\u6210\u6CE8\u518C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "注册成功");
			}
		});
		button.setBounds(67, 214, 93, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u67E5\u770B\u6CE8\u518C\u4FE1\u606F");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(new String(passwordField.getPassword()).equals(new String(passwordField_1.getPassword()))){
					System.out.println("注册信息");
					System.out.println(textField.getText());
					System.out.println(passwordField.getPassword());
					System.out.println(bg.getElements().toString());
					System.out.println(JComboBox.getDefaultLocale());
					
				} else {
					JOptionPane.showConfirmDialog(null, "两次密码不一致");
				}
				
			}
		});
		button_1.setBounds(236, 214, 105, 23);
		frame.getContentPane().add(button_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"aaa", "bbb"}));
		comboBox.setBounds(128, 168, 59, 21);
		frame.getContentPane().add(comboBox);
		
		JLabel label_2 = new JLabel("\u6237\u7C4D\uFF1A");
		label_2.setBounds(55, 171, 54, 15);
		frame.getContentPane().add(label_2);
	}
	 public regist(JFrame frame){
	      frame.setVisible(false);
	      regist r=new regist();
	      r.initialize();
		 }
}
