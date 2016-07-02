package QQ;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.text.html.ImageView;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class qqtest extends Thread{
	private static final String InetAdderss = null;
	private static Socket socket;
	private static JFrame frame;
	private static BufferedReader br;
	private static JTextArea txt1;
	private static JTextArea txt2;
	private static int rgb;
	private static Graphics g;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		getConnection();
	}

	/**
	 * Create the application.
	 */
	public qqtest() {}

	/**
	 * Initialize the contents of the frame.
	 */
	private static  void initialize() {
		frame = new JFrame();
		frame.setTitle("\u804A\u5929\u7A0B\u5E8F");
		frame.getContentPane().setBackground(new Color(255,255,255));
		frame.setBounds(100, 100, 495, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrS = new JTextArea();
		txtrS.setText("s");
		txtrS.setBounds(-3, 259, 4, 24);
		frame.getContentPane().add(txtrS);
		
		txt1 = new JTextArea();
		txt1.setLineWrap(true);
		txt1.setWrapStyleWord(true);
		txt1.setBounds(-3, 336, 346, 114);
		txt1.setComponentZOrder(txt1, 9);
		frame.getContentPane().add(txt1);
		txt1.setBackground(new Color(255,255,255));
        txt1.setBorder(BorderFactory.createTitledBorder(""));

		
		txt2 = new JTextArea();
		txt2.setEditable(false);
		txt2.setBounds(-3, 63, 346, 249);
		txt2.setBackground(new Color(255,255,255));
		txt2.setBorder(BorderFactory.createTitledBorder(""));
		frame.getContentPane().add(txt2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(-3, 259, 4, 24);
		frame.getContentPane().add(textArea);
		
		JButton close = new JButton("关闭");
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		close.setBackground(new Color(250,240,230));
		close.setBounds(188, 448, 70, 24);
		frame.getContentPane().add(close);
		
		JButton send = new JButton("发送");
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						if(!(txt1.getText()==null)&&!"".equals(txt1.getText().trim())){//检查textID的文本是不是全部为空格或者干脆就是空字符串,trim()是用来去掉字符串开头和尾巴上的所以空格的。
							PrintWriter pw=null;
							Date date=new Date(System.currentTimeMillis());
							SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd HH:MM:SS E");
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

		send.setBounds(273, 449, 70, 23);
		send.setBackground(new Color(250,240,230));
		frame.getContentPane().add(send);
		
		JButton btnNewButton_2 = new JButton("A");
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 17));
		btnNewButton_2.setToolTipText("字体选择工具栏");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//btnNewButton_2.setBorder(null);
				
			}
		});
		//btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBounds(-3, 313, 35, 24);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\javaproject\\demo\\images\\QQ\u622A\u56FE20160701145016.png"));
		lblNewLabel.setBounds(0, 0, 61, 62);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\javaproject\\demo\\images\\QQ\u622A\u56FE20160701150525.png"));
		lblNewLabel_1.setBounds(343, 63, 136, 409);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		JButton btnNewButton = new JButton("",new ImageIcon("images/3.png"));
		btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton.setBackground(new Color(255,255,255));
		btnNewButton.setBorder(null);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(39, 315, 35, 24);
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
		JLabel picture2=new JLabel();
		picture2.setLabelFor(txt1);
		picture2.setIcon(new ImageIcon("D:\\javaproject\\demo\\images\\20090112112114631.jpg"));
		picture2.setForeground(Color.BLACK);
		picture2.setBackground(Color.BLUE);
		picture2.setBounds(7, 367, 122, 80);
		//picture2.setComponentZOrder(null, 88888);
		frame.getContentPane().setComponentZOrder(picture2, 10);
	   // frame.getContentPane().add(picture2);
		
		button.setContentAreaFilled(false);
		button.setBounds(76,312,35,30);
		button.setBorder(null);
		frame.getContentPane().add(button);
		
		JButton picture = new JButton("New button",new ImageIcon("images/4.png"));
		picture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
              picture.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
                    JFileChooser jfc=new JFileChooser();
                    jfc.showSaveDialog(null);
                    File f=jfc.getSelectedFile();
/*                   try {
					BufferedImage image=ImageIO.read(f);
					ImageIO.write(image, "png",new File("d:\\test.png"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
                   Image[] array=new Image[10];
                   try {
					Image image=ImageIO.read(f);
				    picture2.setIcon(new ImageIcon("images/4.png"));
				    

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                   
				}
			});  
			}
		});

		
		picture.setBounds(127, 313, 25, 25);
		picture.setBorder(null);
		//picture.setContentAreaFilled(false);
		picture.setBackground(new Color(255,255,255));
		frame.getContentPane().add(picture);

        frame.setVisible(true);
	}
	private static  void getConnection(){

			try {
				initialize();
				while(true){
				socket=new Socket(InetAddress.getLocalHost(),9000);
				socket.setKeepAlive(true);
				 System.out.println("连接服务器:" + socket.getRemoteSocketAddress() + "成功！");
				//client.setKeepAlive(true);
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

	private static void getMessage() {
		// TODO Auto-generated method stub
		String temp=new String();
		try {
			br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(true){
			temp=br.readLine();
			if(temp==null){
				break;
			}
			Date date=new Date(System.currentTimeMillis());
			SimpleDateFormat sdf=new SimpleDateFormat("yyy-mm-dd HH:MM:SS E");
			txt2.setCaretPosition(txt2.getText().length());
			if("".equals(txt2.getText().trim())){
				txt2.append("\n你"+sdf.format(date)+"\n"+temp);
			}
			else{
				txt2.append("\n你"+sdf.format(date)+"\n"+temp);
			}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
