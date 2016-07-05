package shopping;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class admindelete extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
    private JFrame delframe;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admindelete frame = new admindelete(null);
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
	public admindelete(JFrame parents) {
		this.delframe=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(79, 20, 54, 15);
		contentPane.add(lblId);
		
		textField = new JTextField();
		textField.setBounds(143, 17, 187, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("下架原因");
		label.setBounds(79, 64, 54, 15);
		contentPane.add(label);
		
		JCheckBox checkBox = new JCheckBox("商品销售慢");
		checkBox.setBounds(143, 60, 103, 23);
		contentPane.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("厂家停产");
		checkBox_1.setBounds(143, 85, 103, 23);
		contentPane.add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("客户评价低");
		checkBox_2.setBounds(143, 110, 103, 23);
		contentPane.add(checkBox_2);
		
		JCheckBox checkBox_3 = new JCheckBox("价格过高");
		checkBox_3.setBounds(143, 135, 103, 23);
		contentPane.add(checkBox_3);
		
		JLabel label_1 = new JLabel("其他原因");
		label_1.setBounds(79, 167, 54, 15);
		contentPane.add(label_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(143, 164, 187, 51);
		contentPane.add(textArea);
		
		JButton button = new JButton("确认删除");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File f=new File("D:/store/goods/"+textField.getText()+".dat");
				if(f.exists()){
					f.delete();
				}
				delframe.setVisible(false);
				parents.dispose();
				new adminstore(delframe);	
			}
		});
		button.setBounds(166, 225, 93, 23);
		contentPane.add(button);
		
	}
}
