package uk.ac.le.cs.CO3102;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GSONDemo {
	
	public static void main(String args[]){
	
		Person p1=new Person("stu1",1);
		p1.addModule("CO7098");
		p1.addModule("CO3098");
		p1.setPassword("1234");

		Gson gson = 	new GsonBuilder()
			.excludeFieldsWithoutExposeAnnotation()
			.create();  
		String json=gson.toJson(p1);
	//	System.out.println(json); 
		
	
		
		json="{'name':'stu1','module':['CO7098','CO3098'],'id':1}";
		
		Person p2=gson.fromJson(json, Person.class);		
		
		System.out.println(p2.getName());
		
		for(String m: p2.getModule()){
			System.out.println(m);
		}

		

		
	}

}
