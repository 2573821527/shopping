package shopping;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import port.TCPClient;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class usergoods extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JFrame frame;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public usergoods(int id,String name,float price,String num,String username) {
		this.frame=this;
		setTitle("商品详情");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("商品名称:");
		label.setBounds(23, 57, 66, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("ID:");
		label_1.setBounds(35, 100, 54, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("单位:元");
		label_2.setBounds(321, 100, 54, 15);
		contentPane.add(label_2);
		
		JLabel label_4 = new JLabel("单价:");
		label_4.setBounds(35, 141, 44, 46);
		contentPane.add(label_4);
		
		textField = new JTextField();
		textField.setText("1");
		textField.setBounds(99, 244, 66, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("加入购物");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg="add@#@"+id+"@#@"+textField.getText()+"@#@"+username;
				String result=new TCPClient().send(msg);
				if(result.equals("addsuccess")){
					JOptionPane.showMessageDialog(null, "添加成功");
					frame.setVisible(false);
				}else{
					JOptionPane.showMessageDialog(null, "添加失败");
				}
			}
		});
		button.setBounds(175, 243, 126, 23);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel(name);
		lblNewLabel.setBounds(99, 57, 162, 15);
		contentPane.add(lblNewLabel);
		
		JLabel label_3 = new JLabel(String.valueOf(id));
		label_3.setBounds(99, 100, 54, 15);
		contentPane.add(label_3);
		
		JLabel lblNewLabel_1 = new JLabel(String.valueOf(price));
		lblNewLabel_1.setBounds(99, 141, 251, 46);
		contentPane.add(lblNewLabel_1);
		

		
		JLabel lblNewLabel_2 = new JLabel("购买数量:");
		lblNewLabel_2.setBounds(35, 247, 71, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel label_5 = new JLabel("库存: "+num);
		label_5.setBounds(99, 273, 135, 15);
		contentPane.add(label_5);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				((usergoods)e.getSource()).setVisible(false);
			}
		});
	}

}
