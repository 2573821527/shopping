package QQ;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class qqserver {
    private static Socket socket;
	private static  JFrame frame;
	private static BufferedReader br;
	private static JTextArea txt1;
	private static JTextArea txt2;
    private static ServerSocket ss;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		getConnetction();
	}

	/**
	 * Create the application.
	 */
	public qqserver(){}
	/**
	 * Initialize the contents of the frame.
	 */
	private static  void initialize() {
		frame = new JFrame();
		frame.setTitle("\u804A\u5929\u7A0B\u5E8F");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 499,527);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
		
		txt1 = new JTextArea();
		txt1.setBounds(0, 356, 346, 109);
		txt1.setBorder(BorderFactory.createTitledBorder(""));
		frame.getContentPane().add(txt1);

		
		txt2 = new JTextArea();
		txt2.setEditable(false);
		txt2.setBounds(0, 61, 346, 266);
		txt2.setBorder(BorderFactory.createTitledBorder(""));
		frame.getContentPane().add(txt2);

		JButton close = new JButton("关闭");
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		close.setBackground(new Color(250, 240, 230));
		close.setBounds(196, 466, 70, 23);
		frame.getContentPane().add(close);
		
		JButton send = new JButton("发送");
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						if(!(txt1.getText()==null)&&!"".equals(txt1.getText().trim())){//检查textID的文本是不是全部为空格或者干脆就是空字符串,trim()是用来去掉字符串开头和尾巴上的所以空格的。
							PrintWriter pw=null;
							Date date=new Date(System.currentTimeMillis());
							SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd HH:MM:SS");
							txt2.setCaretPosition(txt2.getText().length());//举例说明：jTextArea.setCaretPosition(jTextArea.getDocument().getLength());
                                                                           //以上是将滚动条自动拉到JTextArea最底端，这样就可以看到最低端的数据了。
                                                                           //jTextArea.setCaretPosition(0);
                                                                           //将滚动条一直固定在JTextArea的顶端，这样的话就可以看到最顶端的数据了。
						if(txt2.getText()==null||txt2.getText().trim().equals("")){
							txt2.append("我"+sdf.format(date)+"\n"+txt1.getText());
							//txt1.setText("");
						}else{
							txt2.append("\n我"+sdf.format(date)+"\n"+txt1.getText());
							//txt1.setText("");
						}
						try {
							pw=new PrintWriter(socket.getOutputStream());
							pw.append(txt1.getText());
							txt1.setText("");
							pw.flush();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}finally{
							if(pw!=null){
								pw.close();
							}
						}
				}
			}
		});

		send.setBounds(276, 467, 70, 23);
		send.setBackground(new Color(250,240,230));
		frame.getContentPane().add(send);
		
		JButton btnNewButton_2 = new JButton("A");
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 17));
		btnNewButton_2.setToolTipText("\u5B57\u4F53\u9009\u62E9\u5DE5\u5177\u680F");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//btnNewButton_2.setBorder(null);
				
			}
		});
		//btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBounds(0, 327, 35, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\javaproject\\demo\\images\\QQ\u622A\u56FE20160701145016.png"));
		lblNewLabel.setBounds(0, 0, 60, 58);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\javaproject\\demo\\images\\QQ\u622A\u56FE20160701150525.png"));
		lblNewLabel_1.setBounds(346, 56, 138, 433);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("",new ImageIcon("images/3.png"));
		btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton.setBackground(new Color(255,255,255));
		btnNewButton.setBorder(null);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(41, 326, 35, 30);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("",new ImageIcon("images/2.png"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num=15;
				Point point=frame.getLocation();
				for(int i=15;i>0;i--){
					for(int j=num;j>0;j--){
						point.y+=i;
						frame.setLocation(point);
						point.x+=i;
						frame.setLocation(point);
						point.y-=i;
						frame.setLocation(point);
						point.x-=i;
						frame.setLocation(point);
					}
				}
			}
		});
		button.setContentAreaFilled(false);
		button.setBounds(86,328,35,30);
		button.setBorder(null);
		frame.getContentPane().add(button);
		frame.setBackground(new Color(255,255,255));
		
		JButton btnNewButton_1 = new JButton("New button",new ImageIcon("images/4.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_1.setBounds(131, 327, 32, 30);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setContentAreaFilled(false);
		frame.getContentPane().add(btnNewButton_1);
        frame.setVisible(true);
	}
    private static  void getConnetction(){
    	try {
			ss=new ServerSocket(9000, 10, InetAddress.getLocalHost());			
			initialize();		
			while(true){
				socket=ss.accept();
				socket.setKeepAlive(true);
				System.out.println("连接服务器:" + socket.getRemoteSocketAddress() + "成功！");
				getMessage();
				
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	private static  void getMessage() {
		// TODO Auto-generated method stub
		String temp=new String();
		try {
			br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(!socket.isClosed()){
				temp=br.readLine();
				if(temp==null){
					break;
				}
				Date date=new Date(System.currentTimeMillis());
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd HH:MM:SS");
				if(txt2.getText()==null||"".equals(txt2.getText().trim())){
					txt2.append("\n你"+sdf.format(date)+"\n"+temp);
				}else{
					txt2.append("\n你"+sdf.format(date)+"\n"+temp);
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
}
