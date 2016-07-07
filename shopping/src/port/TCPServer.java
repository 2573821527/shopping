package port;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import io.ObjectStream;
import model.cart;
import model.goods;
import model.person;
import shopping.adminadd;
import shopping.regist;
import shopping.userstore;

public class TCPServer extends Thread {

	private ServerSocket ss = null;
	private int num=0;

	public TCPServer() {
		try {
			ss = new ServerSocket(9000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		List<goods> a = null;
		Socket socket = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		File f = null;
		while (true) {

			try {
				socket = ss.accept();
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String msg = br.readLine();
				System.out.println(msg);
				String[] m = msg.split("@#@");
				String result = "error";

				switch (m[0]) {
				case "login":
					f = new File("D:/store/users/" + m[1] + ".dat");
					if (f.exists()) {
						person p = ObjectStream.read(person.class, "/users/" + m[1] + ".dat");
						if (p.getPassword().equals(m[2])) {
							num++;
							result = "success";
						} else {
							result = "error@#@用户名密码错误";
						}
					}
					break;
				case "exit":
					num--;
					break;
				case "pnum":
					result=String.valueOf(num);
					break;
				case "regist":
					File f2 = new File("D:/store/users/" + m[1] + ".dat");
					if (f2.exists()) {
						result = "error@#@用户已存在";
					} else {
						person p2 = new person();
						p2.setUsername(m[1]);
						p2.setPassword(m[2]);
						ObjectStream.write("/users/" + m[1] + ".dat", p2);
						result = "success";
					}
					break;
				case "search":
					int id = Integer.parseInt(m[1]);
					goods g = ObjectStream.read(goods.class, "/goods/" + id + ".dat");
					result = String.valueOf(g.getGid()) + "@#@" + g.getGoodsName() + "@#@"
							+ String.valueOf(g.getPrice()) + "@#@" + g.getSum();
					break;
				case "duqu":
					goods g4 = ObjectStream.read(goods.class, "/goods/" + m[1] + ".dat");
					result = String.valueOf(g4.getGid()) + "@#@" + g4.getGoodsName() + "@#@"
							+ String.valueOf(g4.getPrice()) + "@#@" + g4.getSum();
					break;
				case "data":
					File f4 = new File("D:/store/goods/");
					String[] str2 = f4.list();
					result = String.valueOf(str2.length);
					break;
				case "data2":
					File f5 = new File("D:/store/cart/user/" + m[1] + "/");
					if (!f5.exists()) {
						f5.mkdir();
					}
					String[] str3 = f5.list();
					result = String.valueOf(str3.length);
					break;
				case "cart":
					File f6 = new File("D:/store/cart/user/" + m[2] + "/");
					String[] str4 = f6.list();
					goods g6 = ObjectStream.read(goods.class,
							"/cart/user/" + m[2] + "/" + str4[Integer.parseInt(m[1])]);
					result = String.valueOf(g6.getGid()) + "@#@" + g6.getGoodsName() + "@#@"
							+ String.valueOf(g6.getPrice()) + "@#@" + g6.getSum();
					break;
				case "add":
					File f8 = new File("D:/store/cart/user/" + m[3] + "/");
					if (!f8.exists()) {
						f8.mkdir();
					}
					goods g7 = ObjectStream.read(goods.class, "/goods/" + m[1] + ".dat");
					g7.setSum(m[2]);
					g7.setGid(g7.getGid());
					g7.setGoodsName(g7.getGoodsName());
					g7.setPrice(g7.getPrice());
					ObjectStream.write("/cart/user/" + m[3] + "/" + g7.getGid() + ".dat", g7);

					result = "addsuccess";
					break;
				case "count":
					File f0 = new File("D:/store/cart/user/" + m[2] + "/");
					String[] str6 = f0.list();
					goods g5 = ObjectStream.read(goods.class, "cart/user/" + m[2] + "/" + str6[Integer.parseInt(m[1])]);
					goods g9 = ObjectStream.read(goods.class, "/goods/" + g5.getGid() + ".dat");
					int num = Integer.parseInt(g9.getSum()) - Integer.parseInt(g5.getSum());
					int num2 = g5.getGid();
					g9.setSum(String.valueOf(num));
					g9.setGid(g9.getGid());
					g9.setGoodsName(g9.getGoodsName());
					g9.setPrice(g9.getPrice());
					ObjectStream.write("/goods/" + g9.getGid() + ".dat", g9);
					File ff = new File("D:/store/cart/user/" + m[2] + "/" +str6[Integer.parseInt(m[1])]);
					ff.delete();
					result = String.valueOf(num2);
					break;
				case "info":
					File f9 = new File("D:/store/cart/user/" + m[1] + "/");
					if (!f9.exists()) {
						f9.mkdir();
					}
					String[] str5 = f9.list();
					goods g8 = ObjectStream.read(goods.class,
							"/cart/user/" + m[1] + "/" + str5[Integer.parseInt(m[2])]);
					System.out.println(">>\\" + g8.getSum());
					result = g8.getSum();
					break;
				}
				pw = new PrintWriter(socket.getOutputStream());
				pw.println(result);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {

				try {
					pw.close();
					br.close();
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}
}
