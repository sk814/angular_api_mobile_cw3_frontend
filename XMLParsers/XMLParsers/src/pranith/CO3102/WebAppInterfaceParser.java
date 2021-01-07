package pranith.CO3102;

import org.w3c.dom.*;
import org.apache.xerces.parsers.DOMParser;

public class WebAppInterfaceParser {

	public static void main(String[] args) {
		try {

			DOMParser parser = new DOMParser();
			parser.parse("WebAppInterface.xml");
			Document doc = parser.getDocument();
			NodeList nodes = doc.getElementsByTagName("abstract_method");
			for (int i = 0; i < nodes.getLength(); i++) {
				if (i == 0)
					System.out.println("{");
				Node node = nodes.item(i);
				display_names(node);
				if (i == nodes.getLength() - 1)
					System.out.println("}");
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}

	static int numberOfSpaces = 0;
	static int childCount = 0;
	static int numberOfExecution = 0;
	static int spaceOpenCurly = 0;

	public static void display_names(Node node) {

		numberOfSpaces++;
		numberOfExecution++;
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
			if (numberOfExecution == 53)
				System.out.print("");
			else if (node.getChildNodes().getLength() == 1 && node.getNodeName() == "parameter"
					&& numberOfExecution < 55) {

				System.out.print("" + spaces(numberOfSpaces) + "{" + "\n" + "\t" + spaces(numberOfSpaces) + "\""
						+ "type" + "\"" + ": " + "\"" + node.getAttributes().getNamedItem("type").getNodeValue() + "\""
						+ "," + "\n");
				System.out.print("" + "\t" + spaces(numberOfSpaces) + "\"" + "variable" + "\"" + ": " + "\""
						+ node.getTextContent() + "\"" + "\n" + spaces(numberOfSpaces) + "}");

				if (numberOfExecution == 19)
					System.out.print("\n" + spaces(numberOfSpaces - 1) + "],");
				else
					System.out.print(",");

			} else if (node.getChildNodes().getLength() == 1 && node.getNodeName() == "parameter"
					&& numberOfExecution > 50) {
//	if(node.getNodeName()=="parameter")
//	{
//		Element element = (Element) node;
//		System.out.print("\n" + spaces(numberOfSpaces)+"\t" + "\"" + "name" + "\"" + ": " + "\""
//				+ element.getAttribute("name") + "\"" + ",");
//	}

				System.out.print("" + spaces(numberOfSpaces) + "\"" + node.getNodeName() + "\"" + ":" + "\n");

				System.out.print("" + spaces(numberOfSpaces) + "{" + "\n" + "\t" + spaces(numberOfSpaces) + "\""
						+ "type" + "\"" + ": " + "\"" + node.getAttributes().getNamedItem("type").getNodeValue() + "\""
						+ "," + "\n");
				System.out.print("" + "\t" + spaces(numberOfSpaces) + "\"" + "variable" + "\"" + ": " + "\""
						+ node.getTextContent() + "\"" + "\n" + spaces(numberOfSpaces) + "}");

			}

			else if (node.getChildNodes().getLength() == 1 && node.getNodeName() == "exception") {
//				System.out.print("" + spaces(numberOfSpaces) + "\"" + node.getNodeName() + "\"");
				System.out.print("" + spaces(numberOfSpaces) + "\"" + node.getTextContent() + "\"");
//				System.out.println(numberOfExecution);
				if (numberOfExecution == 37)
					System.out.print("\n" + spaces(numberOfSpaces) + "],");
				else
					System.out.print(",");
			} else
			{
				if(numberOfExecution==74)
					System.out.print("" + spaces(numberOfSpaces) +"},"+"\n");
				System.out.print("" + spaces(numberOfSpaces) + "\"" + node.getNodeName() + "\"" );
				
			}

			if (node.getChildNodes().getLength() == 1 && node.getNodeName() != "parameter"
					&& node.getNodeName() != "exception") {

				if(node.getNodeName() =="return")
				{
					if(numberOfExecution>47)
					System.out.print(":" + "\"" + node.getTextContent() + "\"" + "\n" + spaces(numberOfSpaces) + "}");
					else
						System.out.print(":" + "\"" + node.getTextContent() + "\"" + "\n" + spaces(numberOfSpaces) + "},");
				}
				else
				System.out.print(":" + "\"" + node.getTextContent() + "\"" + ",");
				


			} else if (node.getNodeName() != "parameter" && node.getNodeName() != "exception") {
//				System.out.println(numberOfExecution);
				if (numberOfExecution == 62) {

					System.out.print(": {");
					spaceOpenCurly = numberOfSpaces;

				} else if (numberOfExecution < 51) {
					System.out.print(":" + "[");
					if (node.getNodeName() == "abstract_method") {

						Element element = (Element) node;
						System.out.print("\n" + spaces(numberOfSpaces) + "   {" + "\n" + spaces(numberOfSpaces) + "\t"
								+ "\"" + "name" + "\"" + ": " + "\"" + element.getAttribute("name") + "\"" + ",");

					}
				} else {

					if (node.getNodeName() == "abstract_method") {

						Element element = (Element) node;
						System.out.print("\n" + spaces(numberOfSpaces) + "   {" + "\n" + spaces(numberOfSpaces) + "\t"
								+ "\"" + "name" + "\"" + ": " + "\"" + element.getAttribute("name") + "\"" + ",");

					}

				}
			}
			System.out.println();
			NodeList childNodes = node.getChildNodes();
			if (childNodes != null) {
				// int childCount = 0;
				int length = childNodes.getLength();
				for (int index = 0; index < length; index++) {
					childCount++;
					display_names(childNodes.item(index));
				}

			}
			break;
		}
		}

		numberOfSpaces--;
		numberOfExecution++;

		if (numberOfSpaces == 1 && numberOfExecution > 77)
			System.out.println("\t" + "]");

	}

	public static String spaces(int t) {
		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < t; i++) {
			sb.append("\t");
		}
		return sb.toString();
	}
}
