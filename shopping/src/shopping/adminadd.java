package shopping;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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


public class adminadd extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JFrame addframe;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminadd frame = new adminadd(null);
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
	public adminadd(JFrame parents) {
		this.addframe=this;
		setTitle("添加商品");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("商品名称:");
		label.setBounds(35, 57, 67, 15);
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
		
		JLabel label_2 = new JLabel("单位:");
		label_2.setBounds(321, 100, 54, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("数量:");
		label_3.setBounds(35, 143, 54, 15);
		contentPane.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(99, 140, 269, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_4 = new JLabel("简介:");
		label_4.setBounds(35, 191, 54, 15);
		contentPane.add(label_4);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(99, 187, 269, 103);
		contentPane.add(textArea);
		
		JButton button = new JButton("确定添加");
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
				addframe.setVisible(false);
				parents.dispose();
				new adminstore(addframe);
				
			}
		});
		button.setBounds(273, 312, 93, 23);
		contentPane.add(button);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(35, 22, 54, 15);
		contentPane.add(lblId);
		
		textField_3 = new JTextField();
		textField_3.setBounds(99, 19, 269, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				((adminadd)e.getSource()).setVisible(false);
			}
		});
	}
}
