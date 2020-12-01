package uk.ac.le.cs.CO3102;

import java.util.List;
import java.util.Vector;

import com.google.gson.annotations.Expose;

public class Person {
   public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void addModule(String m){
		module.add(m);
	}
	
	public List<String> getModule(){
		return module;
	}
	
	public Person(String name, int id) {
			super();
			this.name = name;
			this.id = id;
	}
	
   String password;
   @Expose
   String name;
   @Expose
   List<String> module=new Vector<String>();
   @Expose
   int id;
}
