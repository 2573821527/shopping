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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import io.ObjectStream;
import model.goods;
import port.TCPClient;
import port.TCPServer;

public class adminstore extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminstore frame = new adminstore(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public adminstore(JFrame parents) {
		this.frame = this;
		setTitle("中北商场后台管理系统--当前用户:张三");
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
		table = new JTable(model);

		JScrollPane pane = new JScrollPane(table);

		panel.add(pane);
		contentPane.add(panel);

		JButton button = new JButton("添加商品");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				adminadd add = new adminadd(frame);
				add.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				add.setVisible(true);

			}
		});
		button.setBounds(386, 45, 93, 23);
		contentPane.add(button);

		JButton button_1 = new JButton("修改商品");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*	*/
				if (table.getSelectedRow() != -1) {
					int id = Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 0));
					goods g3 = ObjectStream.read(goods.class, "/goods/" + id + ".dat");
					adminupdate u = new adminupdate(frame, g3.getGid(), g3.getGoodsName(), g3.getPrice(), g3.getSum());
					u.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					u.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "请选中一行");
				}
			}
		});
		button_1.setBounds(489, 45, 93, 23);
		contentPane.add(button_1);

		JButton button_2 = new JButton("删除选中商品");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 得到当前选中商品�?
				// JOptionPane.showConfirmDialog(null, "确定要删除\"" );
				admindelete ad = new admindelete(frame);
				ad.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				ad.setVisible(true);

			}
		});
		button_2.setBounds(587, 45, 119, 23);
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

		JLabel label = new JLabel("当前在线用户人数: 5");
		label.setBounds(10, 10, 162, 15);
		contentPane.add(label);

		JLabel lblid = new JLabel("商品编号:");
		lblid.setBounds(10, 53, 54, 15);
		contentPane.add(lblid);

		textField = new JTextField();
		textField.setBounds(68, 50, 104, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		JToggleButton button_4 = new JToggleButton("搜索");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button_4.isSelected()) {
					int id = Integer.parseInt(textField.getText());
					model.setRowCount(0);
					goods g2 = ObjectStream.read(goods.class, "/goods/" + id + ".dat");
					model.addRow(new String[] { String.valueOf(g2.getGid()), g2.getGoodsName(),
							String.valueOf(g2.getPrice()), g2.getSum() });
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

			}
		});
		button_4.setBounds(180, 49, 93, 23);
		contentPane.add(button_4);
		this.setVisible(true);
		parents.setVisible(false);

	}
}
