package uk.ac.le.cs.CO3102;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JSONDemo {
	
	public static void main(String[] args) {
		
		try {

		    
		    String json="{\n" + 
		    		"   'name': {\n" + 
		    		"      '@id': 'CO3102',\n" + 
		    		"      '#text': 'WTech'\n" + 
		    		"   },\n" + 
		    		"   'teacher': {\n" + 
		    		"      '@id': 'yh37',\n" + 
		    		"      'name': 'Y Hong'\n" + 
		    		"   },\n" + 
		    		"   'students': [\n" + 
		    		"      {\n" + 
		    		"         '@id': 'ls1',\n" + 
		    		"         'name': 'Lisa Simpson',\n" + 
		    		"         'cw1': '30',\n" + 
		    		"         'project': '80',\n" + 
		    		"         'final': '85'\n" + 
		    		"      },\n" + 
		    		"      {\n" + 
		    		"         '@id': 'bs1',\n" + 
		    		"         'name': 'Bart Simson',\n" + 
		    		"         'cw1': '80',\n" + 
		    		"         'project': '100',\n" + 
		    		"         'final': '82'\n" + 
		    		"      },\n" + 
		    		"      {\n" + 
		    		"         '@id': 'hs1',\n" + 
		    		"         'name': 'Homer Simpson',\n" + 
		    		"         'cw1': '60',\n" + 
		    		"         'project': '50',\n" + 
		    		"         'final': '90'\n" + 
		    		"      }\n" + 
		    		"   ]\n" + 
		    		"}";
		    

		
		   // Object object = gson.fromJson(new FileReader("student.json"), Object.class);

		    JsonParser parser = new JsonParser();
		    
		    JsonObject obj = parser.parse(json).getAsJsonObject();
		    
		    JsonArray arr=obj.get("students").getAsJsonArray();
	
		    //1: get LisaSimpson's cw1 mark
		    
		    for(JsonElement o: arr) {
		    //	System.out.println(o.getAsJsonObject().get("name").getAsString());
		    	if(o.getAsJsonObject().get("name").getAsString().equals("Lisa Simpson")) {
		    		System.out.println(o.getAsJsonObject().get("cw1").getAsString());
		    	}
		    	
		    }	 
		    
		    //2: get all students' name
		    for(JsonElement o: arr) {
		    		System.out.println(o.getAsJsonObject().get("name").getAsString());
		    }	
		    
		    
		    //3: get the average project mark
		    double sum=0;
		    int count=0;
		    double avg=0;
		    for(JsonElement o: arr) {
		    	     count++;
		    		sum+=Double.parseDouble(o.getAsJsonObject().get("project").getAsString());
		    }	 
		    avg=sum/count;
		    
		    System.out.println(avg);
		    

		} catch (Exception ex) {
		    ex.printStackTrace();
		}
		
	}

}
