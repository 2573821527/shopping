package port;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {
    private Socket client=null;

	public TCPClient(){
    	try {
			client=new Socket("127.0.0.1",9000);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public String send(String msg){
        PrintWriter pw=null;
        BufferedReader br=null;
    	try {
			pw=new PrintWriter(client.getOutputStream(),true);
			pw.println(msg);
			
			br=new BufferedReader(new InputStreamReader(client.getInputStream()));
			String result=br.readLine();
			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			
				try {
					if(pw!=null) pw.close();
					if(client!=null) client.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
    	return "error";
    	
    }
}
