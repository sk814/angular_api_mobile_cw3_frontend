package com.sanjeev.xmlparsers.dom;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.*;


public class Lab2DOM {
	public static int spaceBefore = 0;
	

	public static void main(String[] args) {
		try {
			DOMParser parser = new DOMParser();
			parser.parse("src/xml/WebAppInterface.xml");

			Document doc = parser.getDocument();

			NodeList ab_met = doc.getElementsByTagName("abstract_method");

			for (int i = 0; i < ab_met.getLength(); i++) {
				spaceBefore = 0;
				Node abNode = ab_met.item(i);
				spaceBefore++;
				if (i == 0)
					System.out.println("{\n" + spaces(spaceBefore) + "\"" + abNode.getNodeName() + "\": [");

				Element eElement = (Element) abNode;
				spaceBefore++;
				System.out.println(spaces(spaceBefore) + "{\n" + spaces(spaceBefore) + "\t\"name\": \""
						+ eElement.getAttribute("name") + "\",");

				NodeList abChildNodes = abNode.getChildNodes();

				int len = 0;
				int childnodes= abChildNodes.getLength();
				while (len < childnodes) {
					display_names(abChildNodes.item(len));
//					System.out.println("LENGTH of clild:"+childnodes);
//					System.out.println("LENGTH of lenght:"+len);
					len++;
				}
				
				
				if(numberofvisit==38)
				System.out.println(spaces(spaceBefore) + "}");
				else
					System.out.println(spaces(spaceBefore) + "},");
				spaceBefore--;
				if (i == ab_met.getLength() - 1) {
					System.out.println(spaces(spaceBefore) + "]");
					spaceBefore--;
					System.out.println(spaces(spaceBefore) + "}");
				}

			}

//			display_names(addressNode);
//			display_names(ab_met.item(1));

		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}

	static int numberOfSpaces = 2;
	static int tracker = -1;
	static int argno=1;
	static int numberofvisit=0;
//	-----------------------------------------------------------------------------------------------------------

	public static void display_names(Node node) {
		numberOfSpaces++;
		numberofvisit++;
		
		if (node == null) {
			return;
		}
		int type = node.getNodeType();
		switch (type) {
		case Node.DOCUMENT_NODE: {
//			System.out.println("IM HERE");
			display_names(((Document) node).getDocumentElement());
			break;
		}
		case Node.ELEMENT_NODE: {
			if(tracker-1==numberOfSpaces && argno<6) {
				System.out.println(spaces(numberOfSpaces)+"],");
				tracker =-1;
				argno++;
			}
			else if(argno==6)
				System.out.println(spaces(numberOfSpaces)+"},");
			
//			System.out.println(spaces(numberOfSpaces)+numberofvisit);
			
				if(node.getNodeName()!="exception" && node.getNodeName()!="parameter" )
			System.out.print("" + spaces(numberOfSpaces) + "\"" + node.getNodeName() + "\"");

			if (node.getChildNodes().getLength() == 1) {
				if(node.getNodeName()=="exception")
				{
//					System.out.println(numberofvisit);
					if(numberofvisit>=19)
					System.out.print("" + spaces(numberOfSpaces)+ "\"" + node.getTextContent() + "\"");
					else
						System.out.print("" + spaces(numberOfSpaces)+ "\"" + node.getTextContent() + "\",");
					
				}
				
				else if(node.getNodeName()=="parameter")
				{
					if (argno<3)
					{
					System.out.print("" + spaces(numberOfSpaces)+"{\n");
					numberOfSpaces++;
					System.out.print("" + spaces(numberOfSpaces)+"\"type\": "+ "\"" + node.getAttributes().getNamedItem("type").getNodeValue()+ "\","+ "\n");
					System.out.print("" + spaces(numberOfSpaces) +"\"variable\": " + "\"" + node.getTextContent()+ "\""+"\n");
					numberOfSpaces--;
					if(numberofvisit==10)
					System.out.print("" + spaces(numberOfSpaces)+"}");
					else
						System.out.print("" + spaces(numberOfSpaces)+"},");
//					System.out.println(numberofvisit);
					argno++;
					}
//					if (argno!=3)
					else
					{
					System.out.print("" + spaces(numberOfSpaces)+ "\""+node.getNodeName() +"\":" +"{\n");
					numberOfSpaces++;
					System.out.print("" + spaces(numberOfSpaces)+"\"type\": "+ "\"" + node.getAttributes().getNamedItem("type").getNodeValue()+ "\","+ "\n");
					System.out.print("" + spaces(numberOfSpaces) +"\"variable\": " + "\"" + node.getTextContent()+ "\""+"\n");
					numberOfSpaces--;
					System.out.print("" + spaces(numberOfSpaces)+"}");
					argno++;
					}
					
				}
//				if(node.getNodeName()=="parameter" && argno==1)
//				{
//					System.out.print(": \"" + node.getTextContent() + "\",");
//				}else
				else
				{
					
					if(numberofvisit==23 ||  numberofvisit==36)
				System.out.print(": \"" + node.getTextContent() + "\"");
					else
						System.out.print(": \"" + node.getTextContent() + "\",");
				}
				
			}
			
			if (node.getChildNodes().getLength() > 1) {
				numberOfSpaces++;
////				if(node.getNodeName()=="arguments")
////				System.out.print(": [\n" + spaces(numberOfSpaces) + " {");
//				if(node.getNodeName()=="throws")
				if (argno<5)
					System.out.print(": [" + spaces(numberOfSpaces));
				else if (argno==5)
					System.out.print(": {" + spaces(numberOfSpaces));
				tracker=numberOfSpaces--;
			}			
			
			
			System.out.println();
//			System.out.println(numberofvisit);
			
			
			NodeList childNodes = node.getChildNodes();
			if (childNodes != null) {
				int length = childNodes.getLength();
				for (int index = 0; index < length; index++) {
					display_names(childNodes.item(index));	
				}
//				System.out.println(spaces(numberOfSpaces) +'}');
			}
			break;
		}
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
