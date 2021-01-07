package com.saiveera;

import org.w3c.dom.*;

import java.util.Arrays;

import org.apache.xerces.parsers.DOMParser;

public class WebAppInterfaceParser {

	public static void main(String[] args) {
		try {
			DOMParser parser = new DOMParser();
			parser.parse("WebAppInterface.xml");
			Document doc = parser.getDocument();

			display_names(doc);
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}

	static int count = 0;
	static String quote = "\"";
	static String openCurly = "{";
	static String closeCurly = "}";
	static String openSquare = "[";
	static String closeSquare = "]";
	static int spaceses = 0;

	static String[] nodes = { "abstract_method", "access_level", "arguments", "throws", "return", "exception",
			"parameter" };

	public static void display_names(Node node) {
		spaceses++;
//		System.out.println(count);
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
			if (Arrays.asList(nodes).contains(node.getNodeName())) {

				count++;

				if (count == 1) {
					System.out.print("" + spaces(spaceses) + openCurly + "\n");
					spaceses++;
				}

				if (node.getNodeName() == "parameter") {
					if (count > 5)
						System.out.print("" + spaces(spaceses) + node.getNodeName() + ":" + "\n");
					spaceses++;
					System.out.print("" + spaces(spaceses) + openCurly + "\n" + spaces(spaceses) + quote + "type"
							+ quote + ": " + quote + node.getAttributes().getNamedItem("type").getNodeValue() + quote
							+ "," + "\n");
					System.out.print("" + spaces(spaceses) + quote + "variable" + quote + ": " + quote
							+ node.getTextContent() + quote + "\n" + spaces(spaceses) + closeCurly);
					spaceses--;
//					System.out.print("" + spaces(spaceses) + closeCurly);

				}

				if (count != 1 && node.getNodeName() == "abstract_method") {
					spaceses++;
					Element element = (Element) node;
					System.out.print("\n" + spaces(spaceses) + quote + "name" + quote + ": " + quote
							+ element.getAttribute("name") + quote + ",");
					spaceses--;

				} else {
//	        			 System.out.print("" + spaces(spaceses) +"{\n");
					if (node.getNodeName() == "access_level" || node.getNodeName() == "return")
						System.out.print("" + spaces(spaceses) + quote + node.getNodeName() + quote);
					else if (node.getNodeName() != "exception" && node.getNodeName() != "parameter") {
						if (count < 11) {
							System.out.print("" + spaces(spaceses) + quote + node.getNodeName() + quote + ": [");
//						System.out.print("\n" + spaces(spaceses) + openCurly);
						} else
							System.out.print("" + spaces(spaceses) + quote + node.getNodeName() + quote + ": {");

					}
					if (node.getNodeName() == "abstract_method") {
						spaceses++;
						Element element = (Element) node;
						System.out.print("\n" + spaces(spaceses) + quote + "name" + quote + ": " + quote
								+ element.getAttribute("name") + quote + ",");
						spaceses--;
					}
				}

				if (node.getChildNodes().getLength() == 1) {

					if (node.getNodeName() == "exception")
						System.out.print("" + spaces(spaceses) + quote + node.getTextContent() + quote);
					else if (node.getNodeName() == "parameter")
						System.out.println("");
					else
						System.out.print(": " + quote + node.getTextContent() + quote);

				}

				System.out.println();

				if (count == 14) {
					spaceses--;
					System.out.print("" + spaces(spaceses) + "}");
				}
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
		}

		spaceses--;
	}

	public static String spaces(int t) {
		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < t; i++) {
			sb.append("\t");
		}
		return sb.toString();
	}
}