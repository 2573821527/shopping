package text;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class text2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					text2 frame = new text2();
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
	public text2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JFrame frame = new JFrame("Welcome To MLDN"); 	// 定义窗体
		JTextArea text = new JTextArea(); 		// 定义文本域
		text.setEditable(true); 			// 定义文本组件可编辑
		frame.getContentPane().add(new JScrollPane(text)); // 在面板中加入文本框及滚动条
		JMenu menuFile = new JMenu("文件");
		menuFile.setHorizontalAlignment(SwingConstants.RIGHT);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		JMenuItem newItem = new JMenuItem("新建");	// 创建JMenuItem
		JMenuItem openItem = new JMenuItem("打开");	// 创建JMenuItem
		JMenuItem closeItem = new JMenuItem("关闭");	// 创建JMenuItem
		JMenuItem exitItem = new JMenuItem("退出");	// 创建JMenuItem
		newItem.setMnemonic('N') ;						// 设置快捷键N
		openItem.setMnemonic('O') ;					// 设置快捷键O
		closeItem.setMnemonic('C') ;					// 设置快捷键C
		exitItem.setMnemonic('E') ;					// 设置快捷键E
		newItem.setAccelerator(KeyStroke.getKeyStroke('N',java.awt.Event.CTRL_MASK));		// Ctrl + N
		openItem.setAccelerator(KeyStroke.getKeyStroke('O',java.awt.Event.CTRL_MASK));		// Ctrl + O
		closeItem.setAccelerator(KeyStroke.getKeyStroke('C',java.awt.Event.ALT_MASK));		// Alt + C
		exitItem.setAccelerator(KeyStroke.getKeyStroke('E',	java.awt.Event.ALT_MASK));		// Alt + E
		menuFile.add(newItem) ;					// 加入菜单项
		menuFile.add(openItem) ;					// 加入菜单项
		menuFile.add(closeItem) ;					// 加入菜单项
		menuFile.addSeparator() ;					// 加入分隔线
		menuFile.add(exitItem) ;					// 加入菜单项
		menuBar.add(menuFile);					// 加入JMenu
		contentPane.add(menuBar);
	}

}
