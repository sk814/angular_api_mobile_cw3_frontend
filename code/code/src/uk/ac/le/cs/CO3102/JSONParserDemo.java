package uk.ac.le.cs.CO3102;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

import com.google.gson.Gson;

public class JSONParserDemo {
	
	public static void main(String[] args) {
		
		try {

		    Gson gson = new Gson();
		    Reader reader = Files.newBufferedReader(Paths.get("student.json"));

		    // convert JSON file to map
		    Map<?, ?> map = gson.fromJson(reader, Map.class);

		    // print map entries
		    for (Map.Entry<?, ?> entry : map.entrySet()) {
		        System.out.println(entry.getKey() + "=" + entry.getValue() );
		        if(entry.getValue() instanceof ArrayList<?>) {
		        	for(Object o: (ArrayList<?>)entry.getValue()) {
		        		System.out.println(o);
		        	}
		        }
		    }

		    reader.close();

		} catch (Exception ex) {
		    ex.printStackTrace();
		}
		
	}

}
