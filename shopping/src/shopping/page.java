package shopping;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;

public class page extends JFrame {

	private JPanel contentPane;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					page pg = new page();
					pg.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public page() {
		setTitle("购物系统");
		this.frame=this;
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\javaproject\\shopping\\images\\0.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1020, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		//contentPane.setLayout(null);

		JButton btnNewButton = new JButton("管理员登录");
		btnNewButton.setForeground(Color.CYAN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminlogin al = new adminlogin();
				al.setVisible(true);
				al.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			}
		});
		contentPane.setLayout(null);
		btnNewButton.setBounds(478, 196, 129, 54);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(null);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("用户登录");
		btnNewButton_1.setForeground(Color.CYAN);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userlogin1 ul = new userlogin1();
				ul.setVisible(true);
				ul.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			}
		});
		btnNewButton_1.setBounds(478, 278, 129, 49);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorder(null);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("退出");
		btnNewButton_2.setForeground(Color.CYAN);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_2.setBounds(503, 347, 72, 23);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorder(null);
		contentPane.add(btnNewButton_2);

		JLabel lblNewLabel = new JLabel("欢迎光临购物系统");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setBounds(447, 119, 219, 49);
		contentPane.add(lblNewLabel);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/12.jpg"));//这是背景图片
		JLabel imgLabel = new JLabel(img);//将背景图放在标签里。

		getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));//注意这里是关键，将背景标签添加到jfram的LayeredPane面板里。
		imgLabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());
		contentPane.setOpaque(false);
		
		setContentPane(contentPane);
	}
}
