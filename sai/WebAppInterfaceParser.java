package sai.kiran;

import org.w3c.dom.*;
import org.apache.xerces.parsers.DOMParser;

public class WebAppInterfaceParser {
	


	public static void main(String[] args) {
		try {

			DOMParser parser = new DOMParser();
			parser.parse("WebAppInterface.xml");
			Document doc = parser.getDocument();
			NodeList nodeList = doc.getElementsByTagName("abstract_method");
			
			int k=0;
			while(k<nodeList.getLength())
			{
				Node node = nodeList.item(k);
				display_names(node);
				k++;
			}
			
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}
	
	static int numberOfSpaces = 0;
	static int calledTimes = 0;


	public static void display_names(Node node) {

		numberOfSpaces++;
		if (node == null) {
			return;
		}
		int type = node.getNodeType();
		switch (type) {
		case Node.DOCUMENT_NODE: {
			display_names(((Document) node).getDocumentElement());
			break;
		}
		case Node.ELEMENT_NODE: {
			
			calledTimes++;
//			System.out.println(calledTimes);
			if (calledTimes == 1 ) {
				System.out.print("" + spaces(numberOfSpaces) +"{"+ "\n");
				numberOfSpaces++;
			}
			

			if ( node.getNodeName() == "abstract_method" && calledTimes != 1 ) {
				
				Element element = (Element) node;
				System.out.print("\n" + spaces(numberOfSpaces) + "\"" + "name" + "\"" + ": " + "\""
						+ element.getAttribute("name") + "\"" + ",");

			}

			else {
				if(node.getNodeName() == "access_level" || node.getNodeName() == "return")
					System.out.print("" + spaces(numberOfSpaces) + "\"" + node.getNodeName() + "\"");
				else if (node.getNodeName() != "exception" && node.getNodeName() != "parameter")
				{
					if(calledTimes==1)
					System.out.print("" + spaces(numberOfSpaces) + "\"" + node.getNodeName() + "\"" +": ["+"\n"+ spaces(numberOfSpaces)+ "{");
					else if(calledTimes==7)
					System.out.print("" + spaces(numberOfSpaces) + "\"" + node.getNodeName() + "\"" +": [");

					else if(calledTimes==19)
						System.out.print("" + spaces(numberOfSpaces) + "\"" + node.getNodeName() + "\"" +": [");
					else
					{
						
						System.out.print("" + spaces(numberOfSpaces) + "\"" + node.getNodeName() + "\"" +": {");
					}	
					
				}
				if (node.getNodeName() == "abstract_method") {
					numberOfSpaces++;
					Element element = (Element) node;
					System.out.print("\n" + spaces(numberOfSpaces) + "\"" + "name" + "\"" + ": " + "\""
							+ element.getAttribute("name") + "\"" + ",");
					numberOfSpaces--;
				}
			}
			
			if (node.getNodeName() == "parameter") {
				if (calledTimes>13)
				{
					System.out.print("" + spaces(numberOfSpaces) + node.getNodeName() +":" + "\n");
				}
				System.out.print("" + spaces(numberOfSpaces)+ "{"+ "\n" + spaces(numberOfSpaces) + "\"" + "type" + "\"" + ": " + "\""
						+ node.getAttributes().getNamedItem("type").getNodeValue() + "\"" + "," + "\n");
				System.out.print("" + spaces(numberOfSpaces) + "\"" + "variable" + "\"" + ": " + "\""
						+ node.getTextContent() + "\"" + "\n" + spaces(numberOfSpaces) + "},");
				if (calledTimes==13)
					System.out.print("\n" + spaces(numberOfSpaces-1) + "],");
			}


			if (node.getChildNodes().getLength() == 1) {
				
				if (node.getNodeName() == "exception")
				{
					System.out.print("" + spaces(numberOfSpaces) + "\"" + node.getTextContent() + "\",");
					if(calledTimes==25)
						System.out.print("\n" + spaces(numberOfSpaces) + "],");
						
				}
				else if (node.getNodeName() == "parameter")
					System.out.print("");
				else
				{

					
						System.out.print(": " + "\"" + node.getTextContent() + "\""+",");
						
						if(calledTimes==50)
							System.out.print("\n" + spaces(numberOfSpaces) +"}\n"+ spaces(numberOfSpaces-1)+"]\n}");
					
					if(calledTimes==31)
						System.out.print("\n" + spaces(numberOfSpaces) + "},\n"+ spaces(numberOfSpaces)+"{");
					

				
				}

			}

			System.out.println();
		}

		NodeList childNodes = node.getChildNodes();
		if (childNodes != null) {
			int length = childNodes.getLength();
			for (int index = 0; index < length; index++) {
				display_names(childNodes.item(index));
			}
		}

			
			break;
		}
		
	numberOfSpaces--;
	calledTimes++;
}
	

	public static String spaces(int t) {
		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < t; i++) {
			sb.append("\t");
		}
		return sb.toString();
	}
}
