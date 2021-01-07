package uk.ac.le.cs.CO3102;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JSONParserDemo2 {
	
	public static void main(String[] args) {
		
		try {

		//    Gson gson = new Gson();

		    String json1="     {\n" + 
		    		"         '@id': 'ls1',\n" + 
		    		"         'name': 'Lisa Simpson',\n" + 
		    		"         'cw1': '30',\n" + 
		    		"         'project': '80',\n" + 
		    		"         'final': '85'\n" + 
		    		"      }";
		    
		    String json2="{\n" + 
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

		    JsonParser parser1 = new JsonParser();
		     JsonObject obj = parser1.parse(json1).getAsJsonObject();
		     String id= obj.get("@id").getAsString();	
		     
		    System.out.println("id="+id);
    
		    JsonParser parser2 = new JsonParser();
		    JsonObject obj2 = parser2.parse(json2).getAsJsonObject();
		    
		    JsonArray arr=obj2.get("students").getAsJsonArray();
		   
		    for(JsonElement o: arr) {
		    	System.out.println("student name:"+o.getAsJsonObject().get("name"));
		    }	 

		} catch (Exception ex) {
		    ex.printStackTrace();
		}
		
	}

}
