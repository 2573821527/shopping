package model;

import java.io.Serializable;

public class person implements Serializable{
			private String name;
			private String age;
			//private String type;
			private String username;
			private String password;  
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public String getAge() {
				return age;
			}
			public void setAge(String age) {
				this.age = age;
			}
/*			public String getType() {
				return type;
			}
			public void setType(String type) {
				this.type = type;
			}*/
			public String getUsername() {
				return username;
			}
			public void setUsername(String username) {
				this.username = username;
			}
			public String getPassword() {
				return password;
			}
			public void setPassword(String password) {
				this.password = password;
			}
			
			@Override
			public String toString() {
				return "person [name=" + name + ", age=" + age + ", username=" + username + ", password=" + password
						+ "]";
			}
  
}
