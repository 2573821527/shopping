package io;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectStream {
	
	private final static String BASE_PATH = "D:/store/";
	
	public static boolean write(String path, Serializable obj){
		try
		(
			FileOutputStream fos = new FileOutputStream(BASE_PATH + path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
		)
		{
			
			oos.writeObject(obj);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Serializable> T read(Class<T> clazz, String path){
		
		try
		(
				FileInputStream fis = new FileInputStream(BASE_PATH + path);
				ObjectInputStream ois = new ObjectInputStream(fis);
		)
		{
			return (T)ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}