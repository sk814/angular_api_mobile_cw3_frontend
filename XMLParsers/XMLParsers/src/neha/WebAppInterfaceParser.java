package neha;

import org.w3c.dom.*;
import org.apache.xerces.parsers.DOMParser;

public class WebAppInterfaceParser {
	

	static int numberOfSpaces = 0;
	
	public static void main(String[] args) {
		try {

			DOMParser parser = new DOMParser();
			parser.parse("WebAppInterface.xml");
			Document doc = parser.getDocument();
			NodeList nodeList = doc.getElementsByTagName("abstract_method");
			
			for (int cnt = 0; cnt < nodeList.getLength(); cnt++) {
				Node node = nodeList.item(cnt);
				display_names(node);
			}
			
			System.out.println("" + spaces(numberOfSpaces) +"]"+ "\n"+"}");
			
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}
	
	
	static int flagBraces = 0;
	static String[] bracketsStack= { "{","}","[","]" };


	public static void display_names(Node node) {

		numberOfSpaces++;
		
		int type = node.getNodeType();
		switch (type) {
		case Node.DOCUMENT_NODE: {
			display_names(((Document) node).getDocumentElement());
			break;
		}
		case Node.ELEMENT_NODE: {
			
			if (flagBraces == 0 ) {
				System.out.print("" + spaces(numberOfSpaces) +"{"+ "\n");
				numberOfSpaces++;
			}
			flagBraces++;

			if (node.getNodeName() == "abstract_method") {
					
					if (flagBraces < 5)
					{
						System.out.print("" + spaces(numberOfSpaces) + "\"" + node.getNodeName() + "\""+ ":" + "[" );
						
					}

					Element element = (Element) node;
					System.out.print("\n" + spaces(numberOfSpaces) + "   {" + "\n" + spaces(numberOfSpaces) + "\t"
							+ "\"" + "name" + "\"" + ": " + "\"" + element.getAttribute("name") + "\"" + ",");

				}
			
			else if(node.getNodeName() == "access_level" )
				System.out.print("" + spaces(numberOfSpaces) + "\"" + node.getNodeName() + "\""+ ": " + "\"" + node.getTextContent() + "\""+",");
			else if(node.getNodeName() == "return" )
				System.out.print("" + spaces(numberOfSpaces) + "\"" + node.getNodeName() + "\""+ ": " + "\"" + node.getTextContent() + "\""+"\n" +spaces(numberOfSpaces-1)+"}");

			
			else if (node.getNodeName().toLowerCase() == "parameter") {
				if(flagBraces>5)
					System.out.print("\n" + spaces(numberOfSpaces) + node.getNodeName() +":"+ "\n");
				System.out.print("" + spaces(numberOfSpaces)+ "{"+ "\n" + spaces(numberOfSpaces+1)+  "\"" + "type" + "\"" + ":" + "\""
						+ node.getAttributes().getNamedItem("type").getNodeValue() + "\"" + "," + "\n");
				System.out.print("" + spaces(numberOfSpaces+1) + "\"" + "variable" + "\"" + ":" + "\""
						+ node.getTextContent() + "\"" + "\n" + spaces(numberOfSpaces) + "},");
				
				if (flagBraces>4)
					System.out.print("\n" + spaces(numberOfSpaces-1) + "],\n");
//				else
//					System.out.print("");
			}
			
			else if (node.getNodeName().toLowerCase() == "exception")
			{
				System.out.print("" + spaces(numberOfSpaces+1) + "\"" + node.getTextContent() + "\"," + flagBraces);
				if(flagBraces==8)
					System.out.print("\n" + spaces(numberOfSpaces) + "],");
					
			}
			
			else if (node.getChildNodes().getLength() == 1) {
				System.out.print(": " + "\"" + node.getTextContent() + "\""+",");

	}
			else
				
						System.out.print("" + spaces(numberOfSpaces) + "\"" + node.getNodeName() + "\"" +": [");
			
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
}
	

	public static String spaces(int t) {
		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < t; i++) {
			sb.append("\t");
		}
		return sb.toString();
	}
}
