package text;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.Dialog.ModalExclusionType;
import java.awt.FlowLayout;

public class text3 extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					text3 frame = new text3();
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
	public text3() {
		setTitle("\u8BB0\u4E8B\u672C");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u6587\u4EF6");
		menu.setHorizontalAlignment(SwingConstants.RIGHT);
		menuBar.add(menu);
		
		JMenuItem menuItem_3 = new JMenuItem("\u65B0\u5EFA");
		menuItem_3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		menuItem_3.setHorizontalAlignment(SwingConstants.LEFT);
		menu.add(menuItem_3);
		
		JMenuItem menuItem = new JMenuItem("\u6253\u5F00");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		menu.add(menuItem);
		
		JMenuItem menuItem_2 = new JMenuItem("\u4FDD\u5B58");
		menuItem_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		menu.add(menuItem_2);
		
		JMenuItem menuItem_1 = new JMenuItem("\u53E6\u5B58\u4E3A");
		menuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		menu.add(menuItem_1);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}
}
