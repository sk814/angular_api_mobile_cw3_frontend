package uk.ac.le.cs.CO3102;
import org.w3c.dom.*;
import org.apache.xerces.parsers.DOMParser;

public class DOMParserDemoGrade {
	
	
	 static float grades[][] = new float[100][4];
	   static int nstudent = 0;
	   static int gi = -1;

	
	public static void main(String[] args)
    {
       try{
  		DOMParser parser = new DOMParser();
  		parser.parse("student.xml");
  		Document doc = parser.getDocument();
  		traverse_tree(doc);
  		compute_final_grades();
       }
       catch(Exception e){
          e.printStackTrace(System.err);
	}
    }

	public static void traverse_tree(Node node)
	   {

	      if(node == null) {return;}
	      int type = node.getNodeType();
	      switch (type) {
	         case Node.DOCUMENT_NODE: {
	        	 traverse_tree(((Document)node).getDocumentElement());
	    		break;
		    }
	         case Node.ELEMENT_NODE: { handleElement(node); break;}   
	         case Node.TEXT_NODE: { handleText(node); break;}
	      }    
	   }

	
	
	private static void handleElement(Node node){
		String elementName = node.getNodeName();
		gi = -1;
		if(elementName.equals("cw1")) {gi = 0;}
		else if(elementName.equals("project")){ gi = 1;}
		else if(elementName.equals("final")) {gi = 2;}
		else if(elementName.equals("student")){ nstudent++;}
		NodeList childNodes = node.getChildNodes();	
		if(childNodes != null) {
			int length = childNodes.getLength();
			for (int loopIndex = 0; loopIndex < length ; loopIndex++)
			{
				traverse_tree(childNodes.item(loopIndex));
		 	}	 
		}
	}

	
	private static void handleText(Node node){
		String chData = node.getNodeValue().trim();
		if(chData.indexOf("\n") < 0 && chData.length() > 0) {
			if(gi >= 0) grades[nstudent-1][gi] = Integer.parseInt(chData);
		}
	} 
	
	private static void compute_final_grades(){
	      float Ave = 0;   int i = 0, j = 0;
	      System.out.println("Grades");
	      for(i = 0; i < nstudent ; i++) {
	         float total = 0;
	         for(j = 0; j < 3; j++){
		            total += grades[i][j];
	         }       
	         grades[i][3] = total/3;
	         Ave += grades[i][3];
	         System.out.println("Student " + i + "=" + grades[i][3]);
	      }
	      Ave /= nstudent;
	      System.out.println("Class Average =" + Ave);  }
}
