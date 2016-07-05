package shopping;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import io.ObjectStream;
import model.goods;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class adminupdate extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JFrame upframe;
	private JTextField textField_3;
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminupdate frame = new adminupdate(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public adminupdate(JFrame parents,int id,String name,float price,String num) {
		this.upframe=this;
		setTitle("修改商品");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("商品名称:");
		label.setBounds(23, 57, 66, 15);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(99, 54, 269, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("单价:");
		label_1.setBounds(35, 100, 54, 15);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(99, 97, 212, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("单位:元");
		label_2.setBounds(321, 100, 54, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("数量:");
		label_3.setBounds(35, 143, 54, 15);
		contentPane.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(99, 140, 212, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_4 = new JLabel("简介:");
		label_4.setBounds(35, 188, 54, 15);
		contentPane.add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(99, 19, 269, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(99, 184, 269, 103);
		contentPane.add(textArea);
		
		textField_3.setText(String.valueOf(id));
		textField.setText(name);
		textField_1.setText(String.valueOf(price));
		textField_2.setText(num);
		JButton button = new JButton("确定修改");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				DefaultTableModel model = new DefaultTableModel();
				goods g=new goods();
				
				g.setGid(Integer.parseInt(textField_3.getText()));
				g.setGoodsName(textField.getText());
				g.setPrice(Float.parseFloat(textField_1.getText()));
				g.setSum(textField_2.getText());
				ObjectStream.write("/goods/"+g.getGid()+".dat", g);
				model.addRow(new String[]{String.valueOf(g.getGid()),g.getGoodsName(),String.valueOf(g.getPrice()),g.getSum()});
				JTable table = new JTable( model );
				JScrollPane pane = new JScrollPane( table );
				upframe.setVisible(false);
				parents.dispose();
				new adminstore(upframe);
				
			}
		});
		button.setBounds(275, 310, 93, 23);
		contentPane.add(button);
		
		JLabel label_5 = new JLabel(">=0");
		label_5.setBounds(321, 143, 43, 15);
		contentPane.add(label_5);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(23, 22, 54, 15);
		contentPane.add(lblId);
		

		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				((adminupdate)e.getSource()).setVisible(false);
			}
		});
	}
}
