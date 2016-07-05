package shopping;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import io.ObjectStream;
import model.goods;
import port.TCPClient;

public class userstore extends JFrame {

	private static JPanel contentPane;
	private JTextField textField;
	private JTable table;
   
	private JFrame frame;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userstore frame = new userstore();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */

	public userstore(JFrame parents) {
        this.frame=this;
		setTitle("中北在线商场--当前用户:李四");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 732, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 78, 696, 341);
		panel.setLayout(new GridLayout(1, 1, 0, 0));

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("商品编号");
		model.addColumn("名称");
		model.addColumn("单价(人民币)");
		model.addColumn("库存");
		File f = new File("D:/store/goods/");
		String[] str = f.list();

		for (int i = 0; i < str.length; i++) {
			goods g = ObjectStream.read(goods.class, "/goods/" + str[i]);
			model.addRow(new String[] { String.valueOf(g.getGid()), g.getGoodsName(), String.valueOf(g.getPrice()),
					g.getSum() });
		}
		String msg5="duqu@#@";
		String result = new TCPClient().send(msg5);
		String[] str2 = result.split("@#@");
		model.setRowCount(0);
		model.addRow(new String[] { str[0], str[1], str[2], str[3] });
		table = new JTable(model);

		JScrollPane pane = new JScrollPane(table);

		panel.add(pane);
		contentPane.add(panel);

		JButton button_2 = new JButton("查看商品详细信息(或双单击商品列表)");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1) {
					int id = Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 0));
					goods g3 = ObjectStream.read(goods.class, "/goods/" + id + ".dat");
					usergoods d = new usergoods(g3.getGid(), g3.getGoodsName(), g3.getPrice(), g3.getSum());
					d.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					d.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "请选择一个物品");
				}
			}
		});
		button_2.setBounds(407, 45, 299, 23);
		contentPane.add(button_2);

		JButton button_3 = new JButton("退出登录");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				parents.setVisible(true);
				
			}
		});
		button_3.setBounds(613, 6, 93, 23);
		contentPane.add(button_3);

		JLabel lblid = new JLabel("商品名称:");
		lblid.setBounds(10, 53, 65, 15);
		contentPane.add(lblid);

		textField = new JTextField();
		textField.setBounds(85, 46, 104, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		JToggleButton button_4 = new JToggleButton("搜索");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button_4.isSelected()) {
					String msg4 = "search@#@" + textField.getText();
					String result = new TCPClient().send(msg4);
					String[] str = result.split("@#@");
					model.setRowCount(0);
					model.addRow(new String[] { str[0], str[1], str[2], str[3] });
				} else {
					model.setRowCount(0);
					File f = new File("D:/store/goods/");
					String[] str = f.list();

					for (int i = 0; i < str.length; i++) {
						goods g = ObjectStream.read(goods.class, "/goods/" + str[i]);
						model.addRow(new String[] { String.valueOf(g.getGid()), g.getGoodsName(),
								String.valueOf(g.getPrice()), g.getSum() });
					}
				}
				/*
				 * int id = Integer.parseInt(textField.getText());
				 * model.setRowCount(0); goods g2 =
				 * ObjectStream.read(goods.class, "/goods/" + id + ".dat");
				 * model.addRow(new String[] { String.valueOf(g2.getGid()),
				 * g2.getGoodsName(), String.valueOf(g2.getPrice()), g2.getSum()
				 * });
				 */
			}
		});
		button_4.setBounds(197, 45, 93, 23);
		contentPane.add(button_4);

		JLabel label = new JLabel("购物详情: 8 件商品");
		label.setBounds(10, 10, 124, 15);
		contentPane.add(label);

		JButton button_5 = new JButton("查看购物车");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				usercartframe cf = new usercartframe();
				cf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				cf.setVisible(true);
			}
		});
		button_5.setBounds(133, 6, 110, 23);
		contentPane.add(button_5);
	}
}
