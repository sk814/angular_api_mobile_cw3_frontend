package uk.ac.le.cs.CO3102;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMParserDemoFigure {

	public static void main(String[] args)
    {
       try{
  		DOMParser parser = new DOMParser();
  		parser.parse("figures.xml");
  		Document doc = parser.getDocument();
  		traverse_tree(doc);
       }
       catch(Exception e){
          e.printStackTrace(System.err);
	}
    }

	public static void traverse_tree(Node node)
	   {

	      if(node == null) {return;}
	      int type = node.getNodeType();
	    //  System.out.println(node);
	      switch (type) {
	         case Node.DOCUMENT_NODE: {
	        	 traverse_tree(((Document)node).getDocumentElement());
	    		break;
		    }
	         case Node.ELEMENT_NODE: { 
	       
	             String elementName = node.getNodeName();
	             NamedNodeMap attrs = node.getAttributes();
	             if(elementName.equals("circle")) {
	                Attr attrib = (Attr)attrs.getNamedItem("r");
	                String sr = attrib.getValue();
	                float radius = Float.valueOf(sr).floatValue();
	                float area = (float)Math.PI *radius*radius;
	               System.out.println("Circle : Radius = " + radius + " Area = " + area);
	             }  
	             
	             NodeList childNodes = node.getChildNodes();	
                 
	                if(childNodes != null) {  
	               
	                int length = childNodes.getLength();
	       			for (int loopIndex = 0; loopIndex < length ; loopIndex++){ 
	       				traverse_tree(childNodes.item(loopIndex));  }	 
	                	}    
	               	} 
	             
	             	break;  
	         }   
	               
        
	      
	   }
	
}
