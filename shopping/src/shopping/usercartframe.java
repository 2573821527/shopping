package shopping;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import port.TCPClient;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class usercartframe extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private float sum = 0;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public usercartframe(String name) {
		;
		setTitle("购物车详情");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 377);
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
		model.addColumn("单价(元)");
		model.addColumn("数量");
		String msg = "data2@#@" + name;
		String result2 = new TCPClient().send(msg);
		int x = Integer.parseInt(result2);

		System.out.println(x);
		for (int i = 0; i < x; i++) {
			String msg6 = "cart@#@" + i + "@#@" + name;
			String result = new TCPClient().send(msg6);
			String[] str = result.split("@#@");
			model.addRow(new String[] { str[0], str[1], str[2], str[3] });
			sum += Float.parseFloat(str[2]) * Float.parseFloat(str[3]);
		}

		JLabel lblNewLabel = new JLabel("总金额:??");

		lblNewLabel.setBounds(342, 232, 211, 15);
		contentPane.add(lblNewLabel);

		JButton button = new JButton("结账");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText("总金额:" + String.valueOf(sum));
				for (int i = 0; i < x; i++) {
					String msg = "count@#@" + i + "@#@" + name;
					String result = new TCPClient().send(msg);
				}
			}
		});
		button.setBounds(456, 283, 93, 23);
		contentPane.add(button);

		table = new JTable(model);
		table.setBounds(10, 38, 543, 184);

		JScrollPane pane = new JScrollPane(table);
		panel.add(pane);
		contentPane.add(panel);

	}

}
