package model;

import java.io.File;
import java.io.Serializable;

import io.ObjectStream;

public class Admin implements Serializable{
	
		private String name;
		private String pass;
	
		public String getPass() {
			return pass;
		}
		public String getName() {
			return name;
		}
		public Admin(){
			this.name="admin";
			this.pass="admin";
			File f=new File("D:/store/admin");
			if(!f.exists()){
				f.mkdirs();
			}						
			ObjectStream.write("/admin/"+this.name+".dat",this);
		}
}
