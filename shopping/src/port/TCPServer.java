package port;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;

import io.ObjectStream;
import model.goods;
import model.person;
import shopping.adminadd;
import shopping.regist;
import shopping.userstore;

public class TCPServer extends Thread {
    
	private ServerSocket ss = null;

	
    public TCPServer(){
		try {
			ss=new ServerSocket(9000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run(){
	        Socket socket = null;
	        BufferedReader br=null;
	        PrintWriter pw=null;
	        File f=null;
			while(true){  
				  
						try {
							socket=ss.accept();
							br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
							String msg=br.readLine();
							//System.out.println(msg);
							String[] m=msg.split("@#@");
							String result="error";
							switch(m[0]){
								case "login":
									f=new File("D:/store/users/"+m[1]+".dat");
									if(f.exists()){
										person p=ObjectStream.read(person.class, "/users/"+m[1]+".dat");
										if(p.getPassword().equals(m[2])){
											result="success";
										}else{
											result="error@#@用户名密码错误";
										}										
									}
									break;
								case "regist":
                                        File f2=new File("D:/store/users/"+m[1]+".dat");
                                        //System.out.println(f2);
                                        if(f2.exists()){
                                        	result="error@#@用户已存在";
                                        }else{
                                        	person p2=new person();
                                        	p2.setUsername(m[1]);
                                        	p2.setPassword(m[2]);
                                        	ObjectStream.write("/users/"+m[1]+".dat", p2);
                                        	result="success";
                                        }
									break;
								case "search":
									  int id=Integer.parseInt(m[1]);
                                      goods g=ObjectStream.read(goods.class, "/goods/"+id+".dat");
                                      result=String.valueOf(g.getGid())+"@#@"+g.getGoodsName()+"@#@"+String.valueOf(g.getPrice())+"@#@"+g.getSum();
									  
							}
							pw=new PrintWriter(socket.getOutputStream());
							pw.write(result);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}finally{
							
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
