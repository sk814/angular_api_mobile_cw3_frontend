package Shan.mobile.copy;

import org.w3c.dom.*;
import org.apache.xerces.parsers.DOMParser;

public class WebAppInterfaceParser {
	
	static int Space = 0;
	static int flag = 0;
	static int flag2 = 0;

	public static void main(String[] args) {
		try {

			DOMParser parser = new DOMParser();
			parser.parse("WebAppInterface.xml");
			Document doc = parser.getDocument();
			NodeList nodes = doc.getElementsByTagName("abstract_method");
			for (int c = 0; c < nodes.getLength(); c++) {

				Node node = nodes.item(c);
				
				if(c< nodes.getLength()/2)
				{
				System.out.println("{\n  " + "\"" + node.getNodeName() + "\": [");
				System.out.print("      {");
				}
				
				display_names(node);
				}
			System.out.print("    }\n");
			System.out.print("  ]\n");
			System.out.print("}");
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}


	public static void display_names(Node node) {

		Space++;


		int type = node.getNodeType();
		switch (type) {
		case Node.ELEMENT_NODE: {

 				if(node.getNodeName()=="parameter")
				{
					if(flag>1)
						System.out.print("" + spaces(Space) + node.getNodeName() +":"+ "\n");

					System.out.print("" + spaces(Space)+ "\"" +"type"+ "\"" +": " +  "\""  + node.getAttributes().getNamedItem("type").getNodeValue()+ "\"" + ","+ "\n");
					System.out.print("" + spaces(Space) + "\""  +"variable"+ "\""  +": "  +  "\""  + node.getTextContent()+  "\"");
					

					flag++;
					
					}
 				
 				else if (node.getNodeName().toLowerCase() == "exception")
 				{
 					System.out.print("" + spaces(Space) + "\"" + node.getTextContent() + "\"," ); 						
 				}
 				
        
 				else if( node.getNodeName()=="abstract_method") {
        			 Element element = (Element)node;
        			 System.out.print("\n" + spaces(Space)+ "\"" +"name"+ "\"" + ": " + "\"" +element.getAttribute("name")+ "\"" +",");
        			 
        		 }
 				
 				else if(node.getNodeName() == "access_level" || node.getNodeName() == "return" )
 					System.out.print("" + spaces(Space) + "\"" + node.getNodeName() + "\""+ ": " + "\"" + node.getTextContent() + "\""+",");
        		 
        		 else
        		 {        			 
        			System.out.print("" + spaces(Space) + "\"" + node.getNodeName()+ "\":" );
        		 }

        	
        	 System.out.println();
        	 
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

  Space--;
}

	public static String spaces(int t) {
		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < t; i++) {
			sb.append("\t");
		}
		return sb.toString();
	}
}
