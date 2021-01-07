package uk.ac.le.cs.CO3098;
import org.w3c.dom.*;
import org.apache.xerces.parsers.DOMParser;

public class Lab2DOMEmpty {
	public static void main(String[] args)
    {
       try{
  		DOMParser parser = new DOMParser();
  		parser.parse("student.xml");
  		Document doc = parser.getDocument();
  	    //TO DO 
       }
       catch(Exception e){
          e.printStackTrace(System.err);
	}
    }

	public static void display_names(Node node)
	{
	//TO DO 	
	}
}
