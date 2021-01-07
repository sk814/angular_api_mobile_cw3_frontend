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
				while (len < abChildNodes.getLength()) {
					display_names(abChildNodes.item(len));
					len++;
				}

				System.out.println(spaces(spaceBefore) + "}");
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
	

	public static void display_names(Node node) {
		numberOfSpaces++;
		
		if (node == null) {
			return;
		}
		int type = node.getNodeType();
		switch (type) {
		case Node.DOCUMENT_NODE: {
			System.out.println("IM HERE");
			display_names(((Document) node).getDocumentElement());
			break;
		}
		case Node.ELEMENT_NODE: {
			if(tracker-1==numberOfSpaces) {
				System.out.println(spaces(numberOfSpaces)+"],");
				tracker =-1;
			}
				
			System.out.print("" + spaces(numberOfSpaces) + "\"" + node.getNodeName() + "\"");

			if (node.getChildNodes().getLength() == 1) {
				System.out.print(": \"" + node.getTextContent() + "\",");
					
				
			}
			
			if (node.getChildNodes().getLength() > 1) {
				numberOfSpaces++;
				System.out.print(": [\n" + spaces(numberOfSpaces) + " {");
				tracker=numberOfSpaces--;
			}			
			
			
			System.out.println();
			
			
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
