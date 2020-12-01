package com.sanjeev.xmlparsers.dom;
import org.w3c.dom.*;
import org.apache.xerces.parsers.DOMParser;

public class Lab2DOM2 {
	static int rotationNumber=0;
	static String br="\"";
	public static void main(String[] args)
    {
       try{
  		DOMParser parser = new DOMParser();
  		parser.parse("WebAppInterface.xml");
  		Document doc = parser.getDocument();

  		
  		display_names(doc);
       }
       catch(Exception e){
          e.printStackTrace(System.err);
	}
    }

	static int numberOfSpaces=0;
	public static void display_names(Node node)
	   {
		
		  numberOfSpaces++;
	      if(node == null) {return;}
	      int type = node.getNodeType();
	      switch (type) {
	         case Node.DOCUMENT_NODE: {
	            	display_names(((Document)node).getDocumentElement());
	    		break;
		    }
	         case Node.ELEMENT_NODE: {
	        	 
//	        	System.out.println(node.getNodeName());
	        	 if(node.getNodeName()=="abstract_method" || node.getNodeName()=="access_level" || node.getNodeName()=="arguments" || node.getNodeName()=="throws"
	        			 || node.getNodeName()=="return" || node.getNodeName()=="exception" || node.getNodeName()=="parameter")
	        	 		{
	 				if(node.getNodeName()=="parameter")
					{
	 					if(rotationNumber>7)
	 						System.out.print("" + spaces(numberOfSpaces) +node.getNodeName()+"\n");
						numberOfSpaces++;
						System.out.print("" + spaces(numberOfSpaces)+br+"type"+br+": " + br + node.getAttributes().getNamedItem("type").getNodeValue()+br+ ","+ "\n");
						System.out.print("" + spaces(numberOfSpaces) +br +"variable"+br +": "  + br + node.getTextContent()+ br+"\n");
						numberOfSpaces--;
						
					}
	        		 rotationNumber++;
	        		 
	        		 if(rotationNumber==1)
	        		 {
	        			 System.out.print("" + spaces(numberOfSpaces)+"{\n");
	        			 numberOfSpaces++;
	        		 }
	        	
	        		 
	        		 if(rotationNumber!=1 && node.getNodeName()=="abstract_method") {
	        			 numberOfSpaces++;
	        			 Element element = (Element)node;
	        			 System.out.print("\n" + spaces(numberOfSpaces)+br+"name"+br+ ": " +br+element.getAttribute("name")+br+",");
	        			 numberOfSpaces--;
	        			 
	        		 }
	        		 
	        		 else
	        		 {
//	        			 System.out.print("" + spaces(numberOfSpaces) +"{\n");
	        			 
	        			 if(node.getNodeName()!="exception" && node.getNodeName()!="parameter")
	        				 System.out.print("" + spaces(numberOfSpaces) +br+ node.getNodeName()+br);
	        			if(node.getNodeName()=="abstract_method")
	        			{
	        				numberOfSpaces++;
	        			Element element = (Element)node;
	        			 System.out.print("\n" + spaces(numberOfSpaces)+br+"name"+br +": " +br+element.getAttribute("name")+br+",");
	        			 numberOfSpaces--;
	        			}
	        		 }
	        		 
	        	 
	        	 if(node.getChildNodes().getLength()==1){
	        		 if(node.getNodeName()=="exception")
	        			 System.out.print("" + spaces(numberOfSpaces)+br+node.getTextContent()+br);
	        		 else if(node.getNodeName()=="parameter")
	        			 System.out.println("");
	        		 else
	        			 System.out.print(": "+br+node.getTextContent()+br);
	        		 
	        	 }
	        	
	        	 System.out.println();
	        	 
	        	 if(rotationNumber==14)
	        	 {
	        		 numberOfSpaces--; 
	        		 System.out.print("" + spaces(numberOfSpaces)+"}");
	        	 }
	        }
	        	 
	        	 NodeList childNodes = node.getChildNodes();	
	             if(childNodes != null) {
	                int length = childNodes.getLength();
	                for (int index = 0; index < length ; index++)
	                {
	                   display_names(childNodes.item(index));
	                }
	             }
	        	 
		         break;
	      
	         }
	      }  
	    
	      
	      numberOfSpaces--;
	   }
	public static String spaces(int t){
		StringBuffer sb=new StringBuffer("");
		for(int i=0;i<t;i++){
			sb.append("\t");
		}		
		return sb.toString();
	}
}